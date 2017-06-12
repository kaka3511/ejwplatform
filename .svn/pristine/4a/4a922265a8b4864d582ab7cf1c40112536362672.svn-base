package com.huaao.ejwplatform.api.control;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huaao.ejwplatform.api.dto.bean.Message;
import com.huaao.ejwplatform.api.dto.bean.MessageAppraiseInfo;
import com.huaao.ejwplatform.api.dto.dept.DtoDeptFindByIdResponse;
import com.huaao.ejwplatform.api.dto.msg.DtoAppraiseMsgRequest;
import com.huaao.ejwplatform.api.dto.msg.DtoMsgDelRequest;
import com.huaao.ejwplatform.api.dto.msg.DtoMsgListByIdRequest;
import com.huaao.ejwplatform.api.dto.msg.DtoMsgListRequest;
import com.huaao.ejwplatform.api.dto.msg.DtoMsgOpenRequest;
import com.huaao.ejwplatform.api.dto.msg.DtoMsgPubRequest;
import com.huaao.ejwplatform.api.dto.msg.DtoMsgReplyRequest;
import com.huaao.ejwplatform.api.dto.msg.DtoMsgSendRequest;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponse;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponseList;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponsePager;
import com.huaao.ejwplatform.api.model.MsgClassifyEnum;
import com.huaao.ejwplatform.api.model.MsgOpenEnum;
import com.huaao.ejwplatform.api.model.MsgReadEnum;
import com.huaao.ejwplatform.api.model.MsgReplyEnum;
import com.huaao.ejwplatform.common.Constants;
import com.huaao.ejwplatform.common.Page;
import com.huaao.ejwplatform.common.util.FuncTool;
import com.huaao.ejwplatform.common.util.JSONUtil;
import com.huaao.ejwplatform.common.web.ApiDescription;
import com.huaao.ejwplatform.common.web.SystemException;
import com.huaao.ejwplatform.dao.SysDeptWithBLOBs;
import com.huaao.ejwplatform.dao.SysDict;
import com.huaao.ejwplatform.dao.SysMessage;
import com.huaao.ejwplatform.dao.SysMessageAppraise;
import com.huaao.ejwplatform.dao.SysMessageExampleExt;
import com.huaao.ejwplatform.dao.SysMessageExt;
import com.huaao.ejwplatform.dao.SysUser;
import com.huaao.ejwplatform.mapper.SysDictMapper;
import com.huaao.ejwplatform.mapper.SysMessageAppraiseMapper;
import com.huaao.ejwplatform.service.MessageService;
import com.huaao.ejwplatform.service.UserService;
import com.huaao.ejwplatform.service.system.DeptService;
import com.huaao.ejwplatform.service.system.DictService;

@ApiDescription("信箱留言消息")
@Controller
@RequestMapping("api/msg")
public class MsgController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DeptService deptService;

	@Autowired
	private SysMessageAppraiseMapper appraiseMapper;
	
	@Autowired
	private SysDictMapper dicMapper;
	
	@Autowired
	private DictService dictService;
	
	@ApiDescription("查询所长信箱&咨询列表&我要找警留言;查询咨询列表时，status参数传1查询包含已回复和已评价的列表;负责人：shilei")
	@RequestMapping("list")
	@ResponseBody
	public DtoPublicResponsePager<Message> list(@Valid DtoMsgListRequest req)  throws Exception {
		DtoPublicResponsePager<Message> resp =new DtoPublicResponsePager<Message>();
		log.info("msg list param {}", JSONUtil.jsonEncode(req));
		//校验
		if(req.getType()==null){
			resp.setCode(Constants.API_CODE_FAIL);//500
			resp.setMsg(Constants.formErrorMsg);
			return resp;
		}

		String deptCode = null;
		SysUser user = userService.getUserById(req.getUid());
		if (req.getType().intValue() != 3) {
			if(!"authed".equals(user.getAuth())){
				resp.setCode(Constants.API_CODE_PERMISSION_DENIED);
				resp.setMsg(Constants.API_MSG_PERMISSION_DENIED);
				return resp;
			}
			//所在部门
			SysDeptWithBLOBs dept = deptService.getDeptById(user.getDeptId());
			
			if(dept==null){
				resp.setCode(Constants.API_CODE_FAIL);//500
				resp.setMsg("找不到用户归属");
				return resp;
			}
			deptCode = dept.getCode();
			
			//派出所人员没法查看
			if(deptCode.length()>15&&(req.getAppType()==null||(req.getAppType()!=null&&req.getAppType().intValue()==2))){
				resp.setCode(Constants.API_CODE_SUCCESS);
				return resp;
			}
		}
		
		
		//分页&排序
		Page page = new Page(req.getPage(),req.getPageSize());
		String orderby = StringUtils.isBlank(req.getSortby())?"time desc":req.getSortby();
		
		try{
			//设置查询条件
			SysMessageExampleExt msg = new SysMessageExampleExt();
			BeanUtils.copyProperties(req, msg);
			if(StringUtils.isNotBlank(req.getKeyword())){
				/*if(StringUtils.isNumeric(req.getKeyword())){
					//去掉按手机号搜索
					msg.setPhone(req.getKeyword());
				}else{
					msg.setRealName(req.getKeyword());
				}*/
				msg.setRealName(req.getKeyword());
			}
			//1居民咨询 2所长信箱 3我要找警
			if (req.getType().intValue() != 3) {
				if(req.getAppType()==null||(req.getAppType()!=null&&req.getAppType().intValue()==2)){
					//警察身份 只能派出所民警看到
					msg.setDeptCode(deptCode.length()>15?deptCode.substring(0,15):deptCode);
 
					if(req.getOpen() != null){
						msg.setOpen(req.getOpen());
					}
				}else{
					//居民身份
					//Open = 1 查阅所有公开
					if(req.getOpen()!=null){
						msg.setOpen(req.getOpen());
						msg.setDeptCode(deptCode.length()>15?deptCode.substring(0,15):deptCode);
					}else{
						msg.setUserId(req.getUid());
						msg.setOpen(null);
					}
					if(req.getClassify()!=null){
						msg.setClassify(req.getClassify());
					}
				}
			} else {
				//警察
				if (req.getAppType() != null && req.getAppType().intValue() == 2) {
					msg.setReplyUserId(req.getUid());
				} else {
					//默认居民
					msg.setUserId(req.getUid());
				}
				
			}
			if(req.getStatus() != null){
				msg.setStatus(req.getStatus());
			}
			
			long s = new Date().getTime();
			List<SysMessageExt> reslist = messageService.list(msg, page, orderby);
			
			
			long e = new Date().getTime();
			log.info("cost{}",(e-s));
			
			SysDict parentDict = dictService.findByCode("counselingClassifyDict");
			List<SysDict> dicts = dictService.findByParent(parentDict.getId());
			List<Message> repList = new ArrayList<Message>();
			for(SysMessageExt me : reslist){
				Message m = FuncTool.copyPropertiesClass(me, Message.class);
				if (req.getType().intValue() == 3 
						&& m != null
						&& m.getReplyUserId() != null) {
					SysDeptWithBLOBs sysDept = deptService.getDeptByUserId(m.getReplyUserId());
					DtoDeptFindByIdResponse deptResp = FuncTool.copyPropertiesClass(sysDept, DtoDeptFindByIdResponse.class);
					m.setDept(deptResp);
				}
				if(me.getStatus() == 3){
					MessageAppraiseInfo appraise = queryAppraiseInfo(me);
				    m.setAppraise(appraise);
				}
				for(SysDict item:dicts)
					if(StringUtils.equals(item.getCode(), m.getClassify().toString()))
						m.setClassifyName(item.getName());
				repList.add(m);
			}
			
			resp.setPage(req.getPage());
			resp.setPageSize(req.getPageSize());
			resp.setData(repList);
			resp.setRecords(page.getTotalCount());
			resp.setCode(Constants.API_CODE_SUCCESS);//0
		}catch(Exception e){
			throw e;
		}
		
		return resp;
	}

	private MessageAppraiseInfo queryAppraiseInfo(SysMessageExt me) {
		SysMessageAppraise sysMessageAppraise = appraiseMapper.selectByPrimaryKey(me.getId());
		if(sysMessageAppraise == null){
			return null;
		}
		MessageAppraiseInfo appraise = FuncTool.copyPropertiesClass(sysMessageAppraise, MessageAppraiseInfo.class);
		SysUser u = userService.getUserById(sysMessageAppraise.getUserId());
		appraise.setUserName(u.getRealname());
		int totalScore = appraise.getFeedbackResult()
			+ appraise.getProcessingEfficiency()
			+ appraise.getTurningSpeed();
		if(totalScore < 6){
			appraise.setAppraiseResult("差评");
		}else if(totalScore >= 10){
			appraise.setAppraiseResult("好评");
		}else{
			appraise.setAppraiseResult("中评");
		}
		return appraise;
	}
	
	@ApiDescription("添加留言;负责人：shilei")
	@RequestMapping("send")//1居民咨询	2所长信箱
	@ResponseBody
	public DtoPublicResponse send(@Valid DtoMsgSendRequest req){
		DtoPublicResponse resp = new DtoPublicResponse();
		
		//校验
//		if(StringUtils.isBlank(req.getContent())||StringUtils.isBlank(req.getTitle())||StringUtils.isBlank(req.getUserId())||req.getType()==null){
//			resp.setCode(Constants.API_CODE_FAIL);//500
//			resp.setMsg(Constants.formErrorMsg);
//			return resp;
//		}
		
		try{
			//我要找警回复人需校验
			if (req.getType().intValue() == 3) {
				if (StringUtils.isBlank(req.getReplyUserId())) {
					throw SystemException.init("回复人id不能为空");
				}
			}
					
			SysMessage msg = new SysMessage();
			BeanUtils.copyProperties(req, msg);
			//添加时未查看 未回复
			msg.setIsRead(MsgReadEnum.UNREAD.getCode());
			msg.setStatus(MsgReplyEnum.UNREPLY.getCode());
			msg.setOpen(MsgOpenEnum.UNOPEN.getCode());
			msg.setClassify(MsgClassifyEnum.OTHER.getCode());
			messageService.addMsg(msg);
			resp.setCode(Constants.API_CODE_SUCCESS);//0
		}catch(Exception e){
			log.error("send msg fail", e);
			resp.setCode(Constants.API_CODE_FAIL);//500
			resp.setMsg("添加消息异常");
		}
		
		return resp;
	}
	
	@ApiDescription("回复留言;负责人：shilei")
	@RequestMapping("reply")
	@ResponseBody
	public DtoPublicResponse reply(@Valid DtoMsgReplyRequest req) throws Exception{
		DtoPublicResponse resp = new DtoPublicResponse();
		
		//校验
//		if(StringUtils.isBlank(req.getId())||StringUtils.isBlank(req.getReplyContent())||StringUtils.isBlank(req.getReplyUserId())){
//			resp.setCode(Constants.API_CODE_FAIL);//500
//			resp.setMsg(Constants.formErrorMsg);
//			return resp;
//		}
		
		try{
			//查询信息
			SysMessage msgOld = messageService.getMsgById(req.getId());
//			if(msgOld!=null&&StringUtils.isNotBlank(msgOld.getReplyContent())){
//				resp.setCode(Constants.API_CODE_APPLY_DUPLICATE);//500
//				resp.setMsg(Constants.API_MSG_ACTION_DUPLICATE);
//				return resp;
//			}
			SysMessage msg = new SysMessage();
			msg.setType(msgOld.getType());
			msg.setUserId(msgOld.getUserId());
			msg.setId(req.getId());
			msg.setReplyContent(req.getReplyContent());
			msg.setReplyUserId(req.getReplyUserId());
			msg.setClassify(req.getClassify()==null?MsgClassifyEnum.OTHER.getCode():req.getClassify());
			//is open
			msg.setOpen(req.getOpen()==null?MsgOpenEnum.UNOPEN.getCode():req.getOpen());
			//回复时已查看 已回复
			msg.setIsRead(MsgReadEnum.READ.getCode());
			msg.setStatus(MsgReplyEnum.REPLY.getCode());
			messageService.replyMsg(msg);
			resp.setCode(Constants.API_CODE_SUCCESS);//0
		}catch(Exception e){
			throw e;
		}
		
		return resp;
	}
	
	@ApiDescription("删除留言;负责人：shilei")
	@RequestMapping("delete")
	@ResponseBody
	public DtoPublicResponse delete(DtoMsgDelRequest req)  throws Exception{
		DtoPublicResponse resp = new DtoPublicResponse();
		//校验
		if(StringUtils.isBlank(req.getId())){
			resp.setCode(Constants.API_CODE_FAIL);//500
			resp.setMsg(Constants.formErrorMsg);
			return resp;
		}
		try{
			messageService.delMsgById(req.getId());
			resp.setCode(Constants.API_CODE_SUCCESS);//0
		}catch(Exception e){
			throw e;
		}
		
		return resp;
	}
	
	@ApiDescription("设置已读;负责人：shilei")
	@RequestMapping("read")
	@ResponseBody
	public DtoPublicResponse read(DtoMsgPubRequest req)  throws Exception{
		DtoPublicResponse resp = new DtoPublicResponse();
		try{
			SysMessage msg = new SysMessage();
			msg.setId(req.getId());
			//设置为已读
			msg.setIsRead(MsgReadEnum.READ.getCode());
			messageService.updateMsg(msg);
			resp.setCode(Constants.API_CODE_SUCCESS);//0
		}catch(Exception e){
			throw e;
		}
		
		return resp;
	}
	
	@ApiDescription("设置消息公开与否;负责人：shilei")
	@RequestMapping("open")
	@ResponseBody
	public DtoPublicResponse open(DtoMsgOpenRequest req)  throws Exception{
		DtoPublicResponse resp = new DtoPublicResponse();
		 
			String[] ids = req.getId().split(",");
			for(String id : ids){
				SysMessage msg = new SysMessage();
				msg.setId(id);
				//设置公开
				msg.setOpen(req.getOpen());
				messageService.updateMsg(msg);
				resp.setCode(Constants.API_CODE_SUCCESS);//0
			}
			
		return resp;
	}
	
	@ApiDescription("咨询留言评价;负责人：hongli")
	@RequestMapping("appraiseMsg")
	@ResponseBody
	public DtoPublicResponse appraiseMsg(@Valid DtoAppraiseMsgRequest dtoRequest) throws Exception {
		SysMessageAppraise messageAppraise = new SysMessageAppraise();
		messageAppraise.setMsgId(dtoRequest.getMsgId());
		messageAppraise.setFeedbackResult(dtoRequest.getFeedbackResult());
		messageAppraise.setProcessingEfficiency(dtoRequest.getProcessingEfficiency());
		messageAppraise.setTurningSpeed(dtoRequest.getTurningSpeed());
		messageAppraise.setCreateTime(Calendar.getInstance().getTime());
		messageAppraise.setUserId(dtoRequest.getUid());
		messageService.appraiseMsg(messageAppraise);
		return DtoPublicResponse.init();
	}

	@ApiDescription("根据消息Id查询消息;负责人：luping")
	@RequestMapping("getMsgByIds")
	@ResponseBody
	public DtoPublicResponseList<Message> listbyIds(@Valid DtoMsgListByIdRequest req) throws Exception {
		DtoPublicResponseList<Message> resp = new DtoPublicResponseList<Message>();
		log.info("msg list param {}", JSONUtil.jsonEncode(req));
		SysUser user = userService.getUserById(req.getUid());
		if (!"authed".equals(user.getAuth())) {
			resp.setCode(Constants.API_CODE_PERMISSION_DENIED);
			resp.setMsg(Constants.API_MSG_PERMISSION_DENIED);
			return resp;
		}
		// 所在部门
		SysDeptWithBLOBs dept = deptService.getDeptById(user.getDeptId());

		if (dept == null) {
			resp.setCode(Constants.API_CODE_FAIL);// 500
			resp.setMsg("找不到用户归属");
			return resp;
		}
		SysDict parentDict = dictService.findByCode("counselingClassifyDict");
		List<SysDict> dicts = dictService.findByParent(parentDict.getId());
		try {
			List<SysMessageExt> reslist = messageService.selectByMessIds(req.getIds());
			List<Message> repList = new ArrayList<Message>();
			for (SysMessageExt me : reslist) {
				Message m = FuncTool.copyPropertiesClass(me, Message.class);
				if (me.getStatus() == 3) {
					MessageAppraiseInfo appraise = queryAppraiseInfo(me);
					m.setAppraise(appraise);
				}
				if (m.getReplyUserId() != null) {
					SysDeptWithBLOBs sysDept = deptService.getDeptByUserId(m.getReplyUserId());
					DtoDeptFindByIdResponse deptResp = FuncTool.copyPropertiesClass(sysDept, DtoDeptFindByIdResponse.class);
					m.setDept(deptResp);
				}
				for (SysDict item : dicts) {
					if (StringUtils.equals(item.getCode(), m.getClassify().toString()))
						m.setClassifyName(item.getName());
				}
				repList.add(m);
			}
			if(repList.size()>0){
			resp.setData(repList);
			}else{
				resp.setData(null);
			}
			resp.setCode(Constants.API_CODE_SUCCESS);// 0
		} catch (Exception e) {
			throw e;
		}
		return resp;
	}

	
}
