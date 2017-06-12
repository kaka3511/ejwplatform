package com.huaao.ejwplatform.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huaao.ejwplatform.common.Page;
import com.huaao.ejwplatform.common.util.DateTool;
import com.huaao.ejwplatform.common.util.FuncTool;
import com.huaao.ejwplatform.common.web.ApiDescription;
import com.huaao.ejwplatform.common.web.SystemException;
import com.huaao.ejwplatform.dao.JwContent;
import com.huaao.ejwplatform.dao.JwContentDept;
import com.huaao.ejwplatform.dao.JwContentDeptExample;
import com.huaao.ejwplatform.dao.JwContentExample;
import com.huaao.ejwplatform.dao.JwContentExample.Criteria;
import com.huaao.ejwplatform.dao.JwContentExampleExt;
import com.huaao.ejwplatform.dao.JwLearnRecordExampleExt;
import com.huaao.ejwplatform.dao.JwLearnRecordExt;
import com.huaao.ejwplatform.dao.SysDeptWithBLOBs;
import com.huaao.ejwplatform.dao.SysDeptExt;
import com.huaao.ejwplatform.dao.SysSubject;
import com.huaao.ejwplatform.dao.SysUser;
import com.huaao.ejwplatform.mapper.JwContentDeptMapper;
import com.huaao.ejwplatform.mapper.JwContentMapper;
import com.huaao.ejwplatform.mapper.JwLearnRecordMapper;
import com.huaao.ejwplatform.mapper.SysSubjectMapper;
import com.huaao.ejwplatform.service.model.ContentStatusEnum;
import com.huaao.ejwplatform.service.system.DeptService;

@ApiDescription("栏目内容")
@Service
@Transactional
public class JwContentService{
	private static final Logger LOG = LoggerFactory.getLogger(JwContentService.class);
	
	@Autowired
	private JwContentMapper jwContentMapper;
	
	@Autowired
	private SysSubjectMapper sysSubjectMapper;
	
	@Autowired
	private JwContentDeptMapper jwContentDeptMapper;
	
	@Autowired
	private PushService pushService;
	
	@Autowired
	private DeptService deptService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwLearnRecordMapper jwLearnRecordMapper;
	
	@Autowired
	private JwLearnRecordService jwLearnRecordService;
	
	@Value("${contentPath}")
	private String contentPath;

	@Autowired
	private SysSubjectService subjectService;
	
	/**
	 * 新增
	 * @param jwContent
	 */
	@Transactional
	public void add(JwContent jwContent, String uid) throws Exception{
		Date dd = new Date();
		jwContent.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		jwContent.setCreateTime(dd);
		jwContent.setUpdateTime(dd);
		jwContent.setLikenum(0);
		jwContent.setReadnum(0);
		String subjectId = jwContent.getSubjectId();
		SysSubject sysSubject = sysSubjectMapper.selectByPrimaryKey(subjectId);
		if(jwContent.getStatus() == null || jwContent.getStatus() == 0){
			if(sysSubject.getIsAudit().intValue() == 0){//该类别栏目不需审批,待发布
				jwContent.setStatus(ContentStatusEnum.DAI_FA_BU.getCode());
			}else{
				jwContent.setStatus(ContentStatusEnum.WEI_SHEN_PI.getCode());//该类别栏目需要审批,未审批
			}
		}
		this.addContentInfo(jwContent, null, uid);
	}
	
	/**
	 * 更新办事指南
	 * @param jwContent
	 */
	@Transactional
	public void update(JwContent jwContent)  throws Exception{
		if(!StringUtils.isBlank(jwContent.getId())){
			JwContent jw = jwContentMapper.selectByPrimaryKey(jwContent.getId());
			if(jw != null){
				Date dd = new Date();
				jwContent.setUpdateTime(dd);
				SysSubject sysSubject = sysSubjectMapper.selectByPrimaryKey(jw.getSubjectId());
				if(jwContent.getStatus() == null || jwContent.getStatus() == 0){
					if(sysSubject.getIsAudit().intValue() == 0){//该类别栏目不需审批,待发布
						jwContent.setStatus(ContentStatusEnum.DAI_FA_BU.getCode());//1
					}else{
						jwContent.setStatus(ContentStatusEnum.WEI_SHEN_PI.getCode());//该类别栏目需要审批,未审批2
					}
				}
				this.updateContentInfo(jwContent, null, 0);
			}
		}
	}

	@Transactional
	public void edit(JwContent jwContent) {
		jwContentMapper.updateByPrimaryKey(jwContent);
	}
	
	/**
	 * 发布
	 * @param id
	 */
	@Transactional
	public void publish(String id, String uid) {
		JwContent jwContent = jwContentMapper.selectByPrimaryKey(id);
		jwContent.setStatus(ContentStatusEnum.YI_FA_BU.getCode());//3//设定为发布状态
		jwContent.setUpdateTime(Calendar.getInstance().getTime());
		jwContent.setUpdaterId(uid);//设定更新人为当前操作用户
		jwContentMapper.updateByPrimaryKey(jwContent);
	}
	
	/**
	 * 撤下
	 * @param id
	 */
	@Transactional
	public void remove(String id, String uid) {
		JwContent jwContent = jwContentMapper.selectByPrimaryKey(id);
		jwContent.setStatus(ContentStatusEnum.YI_CHE_XIAO.getCode());//设定为已撤销状态4 
		jwContent.setUpdateTime(Calendar.getInstance().getTime());
		jwContent.setUpdaterId(uid);//设定更新人为当前操作用户
		jwContent.setUptopTime(null);
		jwContent.setUptopDays(null);
		jwContent.setUptopId(null);
		jwContent.setUptopEndtime(null);
		jwContentMapper.updateByPrimaryKey(jwContent);
	}

	/**
	 * 删除
	 * @param id
	 */
	@Transactional
	public void delete(String id) {
		jwContentMapper.deleteByPrimaryKey(id);
		JwContentDeptExample example = new JwContentDeptExample();
		example.createCriteria().andContentIdEqualTo(id);
		jwContentDeptMapper.deleteByExample(example);
	}
	
	/**
	 * 查询某类类别下的栏目内容条数
	 * @param id
	 * @return
	 */
	public int countContentBySubjectId(String id) {
		JwContentExampleExt exa = new JwContentExampleExt();
		exa.setSysSubjectId(id);
		return jwContentMapper.countMultiByExample(exa);
	}
	
	public int countByTitle(String title){
		JwContentExample exa = new JwContentExample(); 
		Criteria criteria = exa.createCriteria();
		criteria.andTitleEqualTo(title);
		List<JwContent> jwContents = jwContentMapper.selectByExample(exa);
		return jwContents == null ? 0 :jwContents.size();
	}
	
	public int countByTitle(String title, String id){
		if(StringUtils.isBlank(title)){
			return 0;
		}
		JwContentExample exa = new JwContentExample(); 
		Criteria criteria = exa.createCriteria();
		criteria.andTitleEqualTo(title).andIdNotEqualTo(id);
		List<JwContent> jwContents = jwContentMapper.selectByExample(exa);
		return jwContents == null ? 0 :jwContents.size();
	}
	
	/**
	 *  分页查询栏目内容
	 * @param id  栏目类型ID
	 * @param page
	 * @param orderby
	 * @param keyword
	 * @param status
	 * @param infoType
	 * @param userId
	 * @return
	 */
	public List<JwContent> list(String id, Page page, String orderby, String keyword, Integer status, String infoType, String userId) {
		SysUser u = userService.queryUser(userId);
		SysDeptWithBLOBs dept = deptService.getDeptById(u.getDeptId());
		JwContentExampleExt exa = new JwContentExampleExt();
		exa.setStatus(status);
		exa.setType(infoType);
		exa.setOffset(page.getOffset());
		exa.setLimit(page.getPageSize());
		exa.setOrderByClause(orderby);
		if(StringUtils.isNotBlank(id)){
			exa.setSysSubjectId(id);
		}
		if(StringUtils.isNotBlank(keyword)){
			exa.setKeyword(keyword);
		}
		//办事指南查询所属事项分类
		if("4".equals(infoType)){
			List<String> subjectIds = subjectService.getSubjectIdsByDeptId(u.getDeptId());
			if(subjectIds != null && !subjectIds.isEmpty()){
				exa.setSubjectIds(subjectIds);
			}
		}
		int total = 0;
		List<JwContent> jwContents = null;
		if(dept.getLevel().intValue() == 6){
			if("公安".equals(dept.getType())){//警务室用户。能查询到警务室和小区的信息 
				List<SysDeptWithBLOBs> depts = deptService.getDeptByLinkDeptId(dept.getId());
				List<String> deptCodes = new ArrayList<>();
				for(SysDeptWithBLOBs d:depts){
					deptCodes.add(d.getCode());
				}
				deptCodes.add(dept.getCode());
				exa.setDeptCodes(deptCodes);
			}else if("小区".equals(dept.getType())){//小区用户。仅能查小区的信息
				exa.setDeptCode(dept.getCode());
			}else if("物业".equals(dept.getType())){//物业显示所属派出所内的信息
				exa.setDeptCode(dept.getCode().substring(0,15));
			}
			total = jwContentMapper.countMultiByExampleExt(exa);
			jwContents = jwContentMapper.selectMultiByExampleExt(exa);
		}else{
			exa.setDeptCode(dept.getCode());
			total = jwContentMapper.countMultiByExampleExt(exa);
			jwContents = jwContentMapper.selectMultiByExampleExt(exa);
		}
		page.setTotalCount(total);
		for(JwContent content:jwContents){
			//查出每个消息的部门信息
			JwContentDeptExample example = new JwContentDeptExample();
			example.createCriteria().andContentIdEqualTo(content.getId());
			List<JwContentDept> jwContentDepts = jwContentDeptMapper.selectByExample(example);
			List<String> deptIds = new ArrayList<String>();
			for(JwContentDept jwContentDept:jwContentDepts){
				deptIds.add(jwContentDept.getDeptId());
			}
			List<SysDeptWithBLOBs> sysDepts = deptService.queryDeptByIds(deptIds);
			List<SysDeptExt> respDepts = new ArrayList<SysDeptExt>();
			respDepts = FuncTool.copyPropertiesList(sysDepts, SysDeptExt.class);
			content.setDept(respDepts);
		}
		return jwContents;
	}
	
	/**
	 * 查询i学习列表
	 * @param id
	 * @param page
	 * @param orderby
	 * @param keyword
	 * @param status
	 * @param infoType
	 * @param userId
	 * @return
	 */
	public List<JwContent> listZhengCheXueXi(String id, Page page, String orderby, String keyword, Integer status, String infoType, String userId) {
		SysUser u = userService.queryUser(userId);
		SysDeptWithBLOBs dept = deptService.getDeptById(u.getDeptId());
		JwContentExampleExt exa = new JwContentExampleExt();
		exa.setStatus(status);
		exa.setType(infoType);
		exa.setOffset(page.getOffset());
		exa.setLimit(page.getPageSize());
		exa.setOrderByClause(orderby);
		if(StringUtils.isNotBlank(id)){
			exa.setSysSubjectId(id);
		}
		if(StringUtils.isNotBlank(keyword)){
			exa.setKeyword(keyword);
		}
		List<String> deptCodes = new ArrayList<>();
		SysDeptWithBLOBs sysdept = deptService.getDeptByUserId(userId);
		deptCodes.add(dept.getCode());
		if(sysdept.getLevel().intValue() == 5 && "公安".equals(sysdept.getType())){//派出所用户，能查询到派出所和警务室的数据
			List<SysDeptWithBLOBs> depts = deptService.getDeptSubDept(sysdept);
			for(SysDeptWithBLOBs d:depts){
				deptCodes.add(d.getCode());
			}
		}
		exa.setDeptCodes(deptCodes);
		int total = jwContentMapper.countZhengCheXueXiByExample(exa);
		List<JwContent> jwContents = jwContentMapper.selectZhengCheXueXiByExample(exa);
		page.setTotalCount(total);
		for(JwContent content:jwContents){
			//查出每个消息的部门信息
			JwContentDeptExample example = new JwContentDeptExample();
			example.createCriteria().andContentIdEqualTo(content.getId());
			List<JwContentDept> jwContentDepts = jwContentDeptMapper.selectByExample(example);
			List<String> deptIds = new ArrayList<String>();
			for(JwContentDept jwContentDept:jwContentDepts){
				deptIds.add(jwContentDept.getDeptId());
			}
			List<SysDeptWithBLOBs> sysDepts = deptService.queryDeptByIds(deptIds);
			List<SysDeptExt> respDepts = new ArrayList<SysDeptExt>();
			respDepts = FuncTool.copyPropertiesList(sysDepts, SysDeptExt.class);
			content.setDept(respDepts);
			//i学习，根据内容ID查出所有已阅读的人员列表
			JwLearnRecordExampleExt recordExample = new JwLearnRecordExampleExt();
			recordExample.setContentId(content.getId());
			recordExample.setOrderByClause("name asc");
			List<JwLearnRecordExt> learn = jwLearnRecordMapper.selectReadUserList(recordExample);
			content.setLearn(learn);
			//根据部门ID查出总人数
			int usernum = userService.countByDeptIds(sysDepts);
			content.setTotal(usernum);
			//查询当前用户是否已阅读
			int read = jwLearnRecordService.selectReadByUidAndContentId(userId, content.getId());
			content.setCurrentUserRead(read);
		}
		return jwContents;
	}
	
	/**
	 * 新增内容消息
	 * @param jwContent
	 */
	@Transactional
	public void addContentInfo(JwContent jwContent, String communityIds, String createrId) throws Exception{
		if(jwContent.getType().intValue() == 9){
			//不同派出所,不能重复TITLE
			jwContent.setTitle(jwContent.getTitle().replace(" ", ""));
			JwContentExample jcExample = new JwContentExample();
			List<String> usersId = userService.queryManageUserIds(createrId);
			jcExample.createCriteria().andTitleEqualTo(jwContent.getTitle()).andCreateIdIn(usersId).andTypeEqualTo(9);
			if(jwContentMapper.selectByExample(jcExample).size() > 0){
				throw SystemException.init("常见问题名称不能重复");
			}
		}
		
		Date dd = new Date();
		String contentId = UUID.randomUUID().toString().replaceAll("-", "");
		jwContent.setId(contentId);
		jwContent.setCreateTime(dd);
		jwContent.setUpdateTime(dd);
		jwContent.setLikenum(0);
		jwContent.setReadnum(0);
		jwContentMapper.insert(jwContent);
		
		if(jwContent.getType().intValue() == 1 
				|| jwContent.getType().intValue() == 2
				|| jwContent.getType().intValue() == 4
				|| jwContent.getType().intValue() == 5
				|| jwContent.getType().intValue() == 7
				|| jwContent.getType().intValue() == 9){//1警情通报，2协查通报 5防范小贴士 7热点新闻
//			 SysUser user = userService.getUserById(createrId);
			 //按当前用户查询所有子部门
//			 List<SysDeptWithBLOBs> sysDepts= deptService.getAllDeptByDept(user.getDeptId());
			 List<SysDeptWithBLOBs> sysDepts = new ArrayList<>();
			 SysDeptWithBLOBs sysdept = deptService.getDeptByUserId(createrId);
			 if(sysdept.getLevel().intValue() == 6 && "公安".equals(sysdept.getType())){//警务室用户。能查询到警务室和小区的信息
				List<SysDeptWithBLOBs> depts = deptService.getDeptByLinkDeptId(sysdept.getId());
				sysDepts.addAll(depts);
				sysDepts.add(sysdept);
			 }else if(sysdept.getLevel().intValue() == 5 && "公安".equals(sysdept.getType())){//派出所用户
				 sysDepts= deptService.getAllDeptByDept(sysdept.getId());
			 }else{
				 sysDepts.add(sysdept);
			 }
			 for(SysDeptWithBLOBs dept:sysDepts){
				JwContentDept jwContentDept = new JwContentDept(); 
				jwContentDept.setId(UUID.randomUUID().toString().replaceAll("-", ""));
				jwContentDept.setContentId(contentId);
				jwContentDept.setDeptId(dept.getId());
				jwContentDeptMapper.insert(jwContentDept);
			 }
			 return ;
		}else{
			//维护关系表jw_content_dept
			if(StringUtils.isNotBlank(communityIds)){
				String[] ids = communityIds.split(",");
				if(ids != null && ids.length > 0){
					for(String communityId : ids){
						JwContentDept jwContentDept = new JwContentDept(); 
						jwContentDept.setId(UUID.randomUUID().toString().replaceAll("-", ""));
						jwContentDept.setContentId(contentId);
						jwContentDept.setDeptId(communityId);
						jwContentDeptMapper.insert(jwContentDept);
					}
					//msg notice send push message
					if((jwContent.getType() == 8 || jwContent.getType() == 6) 
							&& (jwContent.getMsgStatus() == null || jwContent.getMsgStatus() != 2)){
						sendPushMsg(contentId, createrId);
					}
				}
			}
		}
	}
	
	/**
	 * 发送推送消息
	 */
	
	public void sendPushMsg(String contentId, String createrId){
		pushService.createPushMessage(contentId, createrId);
	}
	
	/**
	 * 更新内容消息
	 * @param jwContent
	 */
	@Transactional
	public void updateContentInfo(JwContent jwContent, String communityIds, Integer istop) throws Exception{
		if(!StringUtils.isBlank(jwContent.getId())){
			if(jwContent.getType().intValue() == 9 && !StringUtils.isBlank(jwContent.getTitle())){
				//不能重复TITLE
				jwContent.setTitle(jwContent.getTitle().replace(" ", ""));
				JwContentExample jcExample = new JwContentExample();
				List<String> usersId = userService.queryManageUserIds(jwContent.getUpdaterId());
				jcExample.createCriteria().andTitleEqualTo(jwContent.getTitle()).andIdNotEqualTo(jwContent.getId()).andCreateIdIn(usersId).andTypeEqualTo(9);;
				if(jwContentMapper.selectByExample(jcExample).size() > 0){
					throw SystemException.init("常见问题名称不能重复");
				}
			}
			
			jwContentMapper.updateByPrimaryKeySelective(jwContent);
			try {
				if(istop == null || istop == 0){
					//编辑和取消置顶操作时,置顶参数置空
					jwContent.setUptopTime(null);
					jwContent.setUptopDays(null);
					jwContent.setUptopId(null);
					jwContent.setUptopEndtime(null);
					jwContentMapper.updateUptopInfoByPrimaryKey(jwContent);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(StringUtils.isNotBlank(communityIds)){
				JwContentDeptExample example = new JwContentDeptExample();
				example.createCriteria().andContentIdEqualTo(jwContent.getId());
				jwContentDeptMapper.deleteByExample(example);
				//维护关系表jw_content_dept
				String[] ids = communityIds.split(",");
				if(ids != null && ids.length > 0){
					for(String communityId : ids){
						JwContentDept jwContentDept = new JwContentDept(); 
						jwContentDept.setId(UUID.randomUUID().toString().replaceAll("-", ""));
						jwContentDept.setContentId(jwContent.getId());
						jwContentDept.setDeptId(communityId);
						jwContentDeptMapper.insert(jwContentDept);
					}
					//重新发送消息通知
					if((jwContent.getType() == 8 || jwContent.getType() == 6) 
							&& (jwContent.getMsgStatus() == null || jwContent.getMsgStatus() != 2)){
						sendPushMsg(jwContent.getId(), jwContent.getUpdaterId());
					}
				}
			}
		}
	}
	
	/**
	 * 按主键查询信息内容
	 * @param id
	 * @return
	 */
	public JwContent selectByPrimaryKey(String id){
		JwContent jwContent = jwContentMapper.selectByPrimaryKey(id);
		return jwContent;
		
	}
	
	/**
	 * 置顶检查.最多允许置顶条数
	 * @param maxUptopRows
	 * @return
	 */
	public boolean uptopCheck(int maxUptopRows, int type, String uid){
		SysDeptWithBLOBs depts = deptService.getDeptByUserId(uid);
		int total = 0;
		JwContentExampleExt exa = new JwContentExampleExt();
		exa.setStatus(ContentStatusEnum.YI_FA_BU.getCode());
		exa.setType(type+"");
		exa.setDeptCode(depts.getCode());
		total = jwContentMapper.countUptopsByExample(exa);
		if(total >= maxUptopRows){
			return false;
		}
		return true;
	}
	
	/**
	 * 更新置顶信息
	 */
	public void updateUpTopInfo() {
		try {
			String uptopEndtimeStr = DateTool.formatDate(new Date())+" 00:00:00";
			JwContentExample exa = new JwContentExample();
			//知识库不更新置顶信息
			exa.createCriteria().andUptopEndtimeLessThanOrEqualTo(DateTool.parseDateTime(uptopEndtimeStr)).andTypeNotEqualTo(9);
			List<JwContent> contents = jwContentMapper.selectByExample(exa);
			if(contents != null){
				for(JwContent content:contents){
					content.setUptopTime(null);
					content.setUptopDays(null);
					content.setUptopId(null);
					content.setUptopEndtime(null);
					jwContentMapper.updateUptopInfoByPrimaryKey(content);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("更新置顶信息出错", e);
		}
	}
	
	//根据iD查询内容
	public List<JwContent> quneryByIds(String ids) {
		if (ids == null || ids.equals("")) {
			return null;
		}
		String[] contIds = ids.split(",");
		return jwContentMapper.selectMultiByIds(Arrays.asList(contIds));
	}
	//查询已经学习列表
	public List<JwLearnRecordExt> selectReadUserList(String id) {
		JwLearnRecordExampleExt recordExample = new JwLearnRecordExampleExt();
		recordExample.setContentId(id);
		recordExample.setOrderByClause("name asc");
		List<JwLearnRecordExt> learn = jwLearnRecordMapper.selectReadUserList(recordExample);
		return learn;
	}
	
	public List<JwContentDept> selectByExample(JwContentDeptExample example) {
		List<JwContentDept> jwContentDepts = jwContentDeptMapper.selectByExample(example);
		return jwContentDepts;
	}
	
	
	
}
