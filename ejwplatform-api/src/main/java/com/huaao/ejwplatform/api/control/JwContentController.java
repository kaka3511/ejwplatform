package com.huaao.ejwplatform.api.control;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huaao.ejwplatform.api.dto.content.DtoCreateJWContentRequest;
import com.huaao.ejwplatform.api.dto.content.DtoJWContentRequest;
import com.huaao.ejwplatform.api.dto.content.DtoLearnRequest;
import com.huaao.ejwplatform.api.dto.content.DtoModifyJWContentRequest;
import com.huaao.ejwplatform.api.dto.content.DtoQueryItemResponse;
import com.huaao.ejwplatform.api.dto.content.DtoQueryJWContentByIdRequest;
import com.huaao.ejwplatform.api.dto.content.DtoQueryJWContentExtRequest;
import com.huaao.ejwplatform.api.dto.content.DtoQueryJWContentExtResponse;
import com.huaao.ejwplatform.api.dto.content.DtoQueryJWContentRequest;
import com.huaao.ejwplatform.api.dto.content.DtoQueryJWContentResponse;
import com.huaao.ejwplatform.api.dto.content.DtoUpdateJWContentRequest;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequestPager;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponse;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponseList;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponsePager;
import com.huaao.ejwplatform.api.model.ContentInfoTypeEnum;
import com.huaao.ejwplatform.api.model.ContentStatusEnum;
import com.huaao.ejwplatform.api.model.ContentTopEnum;
import com.huaao.ejwplatform.api.util.ApiTool;
import com.huaao.ejwplatform.api.util.ContentComparator;
import com.huaao.ejwplatform.common.Constants;
import com.huaao.ejwplatform.common.Page;
import com.huaao.ejwplatform.common.util.DateTool;
import com.huaao.ejwplatform.common.util.FuncTool;
import com.huaao.ejwplatform.common.web.ApiDescription;
import com.huaao.ejwplatform.dao.JwContent;
import com.huaao.ejwplatform.dao.JwContentDept;
import com.huaao.ejwplatform.dao.JwContentDeptExample;
import com.huaao.ejwplatform.dao.JwLearnRecord;
import com.huaao.ejwplatform.dao.JwLearnRecordExt;
import com.huaao.ejwplatform.dao.SysDeptWithBLOBs;
import com.huaao.ejwplatform.dao.SysDeptExt;
import com.huaao.ejwplatform.dao.SysUser;
import com.huaao.ejwplatform.service.JwContentService;
import com.huaao.ejwplatform.service.JwLearnRecordService;
import com.huaao.ejwplatform.service.UserService;
import com.huaao.ejwplatform.service.system.DeptService;

@ApiDescription("办事指南内容")
@Controller
@RequestMapping("api/jwContent")
public class JwContentController {

	private static final Logger LOG = LoggerFactory.getLogger(JwContentController.class);

	@Autowired
	private JwContentService jwContentService;

	@Autowired
	private UserService userSerivce;

	@Autowired
	private JwLearnRecordService jwLearnRecordService;
	@Autowired
	private DeptService deptService;
	@Autowired
	private UserService userService;
	
	@Value("${contentPath}")
	private String contentPath;

	@ApiDescription("查询办事指南某类信息列表;负责人：hongli")
	@RequestMapping("queryJWContentList")
	@ResponseBody
	public DtoPublicResponsePager<DtoQueryJWContentResponse> queryJWContentList (
			@Valid DtoQueryJWContentRequest dtoRequest) throws Exception{
		DtoPublicResponsePager<DtoQueryJWContentResponse> dtoResponse = new DtoPublicResponsePager<DtoQueryJWContentResponse>();
		try {
			List<DtoQueryJWContentResponse> dtoQueryJWContentResponseList = new ArrayList<DtoQueryJWContentResponse>();
			Page page = ApiTool.convert(dtoRequest);
			String uid = dtoRequest.getUid();
			SysUser user = userSerivce.getUserById(uid);
			if (!"authed".equals(user.getAuth())) {
				dtoResponse.setCode(Constants.API_CODE_SUCCESS);
				dtoResponse.setData(dtoQueryJWContentResponseList);
				ApiTool.fillPagerData(page, dtoResponse);
				LOG.info("{}暂未通过认证，无法查看办事指南列表。", user.getUserName());
				return dtoResponse;
			}
			String orderby = StringUtils.isBlank(dtoRequest.getSortby()) ? " create_time desc" : dtoRequest.getSortby();
			List<JwContent> jwContents = jwContentService.list(dtoRequest.getSysSubjectId(), page, orderby,
					dtoRequest.getKeyword(), dtoRequest.getStatus(), ContentInfoTypeEnum.BAN_SHI_ZHI_NAN.getCode().toString(),dtoRequest.getUid());
			for (JwContent jwContent : jwContents) {
				DtoQueryJWContentResponse dtoQueryJWContentResponse = new DtoQueryJWContentResponse();
				BeanUtils.copyProperties(jwContent, dtoQueryJWContentResponse);
				dtoQueryJWContentResponse.setLink(contentPath + jwContent.getId());
				dtoQueryJWContentResponseList.add(dtoQueryJWContentResponse);
			}
			ApiTool.fillPagerData(page, dtoResponse);
			dtoResponse.setData(dtoQueryJWContentResponseList);
		} catch (Exception e) {
			throw e;
		}
		return dtoResponse;
	}

	@ApiDescription("新增办事指南;负责人：hongli")
	@RequestMapping("addJWContent")
	@ResponseBody
	public DtoPublicResponse addJWContent(@Valid DtoCreateJWContentRequest dtoCreateJWContentRequest) throws Exception{
		DtoPublicResponse dtoResponse = new DtoPublicResponse();
		try {
			JwContent jwContent = new JwContent();
			jwContent.setType(ContentInfoTypeEnum.BAN_SHI_ZHI_NAN.getCode());
			jwContent.setCreateId(dtoCreateJWContentRequest.getUid());
			jwContent.setUpdaterId(dtoCreateJWContentRequest.getUid());
			BeanUtils.copyProperties(dtoCreateJWContentRequest, jwContent);
			if ("1".equals(dtoCreateJWContentRequest.getDirectPublish())) {
				jwContent.setStatus(ContentStatusEnum.YI_FA_BU.getCode());// 3
			}
			jwContentService.add(jwContent, dtoCreateJWContentRequest.getUid());
		} catch (Exception e) {
			throw e;
//			dtoResponse.setCode(Constants.API_CODE_FAIL);
//			dtoResponse.setMsg("新增办事指南失败");
//			LOG.error(dtoResponse.getMsg() + " " + e.getMessage(), e);
		}
		return dtoResponse;
	}

	@ApiDescription("更新办事指南;负责人：hongli")
	@RequestMapping("updateJWContent")
	@ResponseBody
	public DtoPublicResponse updateJWContent(@Valid DtoUpdateJWContentRequest dtoUpdateJWContentRequest) throws Exception{
		DtoPublicResponse dtoResponse = new DtoPublicResponse();
		try {
			JwContent jwContent = new JwContent();
			jwContent.setUpdaterId(dtoUpdateJWContentRequest.getUid());
			BeanUtils.copyProperties(dtoUpdateJWContentRequest, jwContent);
			if ("1".equals(dtoUpdateJWContentRequest.getDirectPublish())) {
				jwContent.setStatus(ContentStatusEnum.YI_FA_BU.getCode());// 3
			}
			jwContent.setType(ContentInfoTypeEnum.BAN_SHI_ZHI_NAN.getCode());
			jwContentService.update(jwContent);
			dtoResponse.setCode(Constants.API_CODE_SUCCESS);
		} catch (Exception e) {
			throw e;
//			dtoResponse.setCode(Constants.API_CODE_FAIL);
//			dtoResponse.setMsg("更新办事指南失败");
//			LOG.error(dtoResponse.getMsg() + " " + e.getMessage(), e);
		}
		return dtoResponse;
	}

	@ApiDescription("发布办事指南;负责人：hongli")
	@RequestMapping(value = "publishJWContent")
	@ResponseBody
	public DtoPublicResponse publishJWContent(@Valid DtoJWContentRequest dtoRequest) throws Exception{
		DtoPublicResponse dtoResponse = new DtoPublicResponse();
		try {
			jwContentService.publish(dtoRequest.getId(), dtoRequest.getUid());
		} catch (Exception e) {
			throw e;
//			dtoResponse.setCode(Constants.API_CODE_FAIL);
//			dtoResponse.setMsg("发布办事指南失败");
//			LOG.error(dtoResponse.getMsg() + " " + e.getMessage(), e);
		}
		return dtoResponse;
	}

	@ApiDescription("撤销办事指南;负责人：hongli")
	@RequestMapping(value = "removeJWContent")
	@ResponseBody
	public DtoPublicResponse removeJWContent(@Valid DtoJWContentRequest dtoRequest) throws Exception{
		DtoPublicResponse dtoResponse = new DtoPublicResponse();
		try {
			jwContentService.remove(dtoRequest.getId(), dtoRequest.getUid());
		} catch (Exception e) {
			throw e;
//			dtoResponse.setCode(Constants.API_CODE_FAIL);
//			dtoResponse.setMsg("撤销办事指南失败");
//			LOG.error(dtoResponse.getMsg() + " " + e.getMessage(), e);
		}
		return dtoResponse;
	}

	@ApiDescription("删除办事指南;负责人：hongli")
	@RequestMapping(value = "deleteJWContent")
	@ResponseBody
	public DtoPublicResponse deleteJWContent(@Valid DtoJWContentRequest dtoRequest) throws Exception{
		DtoPublicResponse dtoResponse = new DtoPublicResponse();
		try {
			jwContentService.delete(dtoRequest.getId());
		} catch (Exception e) {
			throw e;
//			dtoResponse.setCode(Constants.API_CODE_FAIL);
//			dtoResponse.setMsg("删除办事指南失败");
//			LOG.error(dtoResponse.getMsg() + " " + e.getMessage(), e);
		}
		return dtoResponse;
	}

	@ApiDescription("查询某类信息列表;负责人：hongli")
	@RequestMapping("getJWContentList")
	@ResponseBody
	public DtoPublicResponsePager<DtoQueryJWContentExtResponse> getJWContentList(@Valid DtoQueryJWContentExtRequest dtoRequest) throws Exception{
		DtoPublicResponsePager<DtoQueryJWContentExtResponse> dtoResponse = new DtoPublicResponsePager<DtoQueryJWContentExtResponse>();
		try {
			Page page = ApiTool.convert(dtoRequest);
			List<DtoQueryJWContentExtResponse> dtoQueryJWContentResponseList = new ArrayList<DtoQueryJWContentExtResponse>();
			// "1警情通报 2协查通报 3社区动态 4办事指南 5防范小贴士 6消息通知" (实时热点 1,2,3,5)
			// 未实名认证通过（待审核和未认证）的用户不显示警情通报、协查通报、防范小贴士、实时热点、社区动态和消息通知内容
			String uid = dtoRequest.getUid();
			SysUser user = userSerivce.getUserById(uid);
			String infoType = dtoRequest.getInfoType();
			if (!"authed".equals(user.getAuth())) {
				dtoResponse.setCode(Constants.API_CODE_SUCCESS);
				dtoResponse.setData(dtoQueryJWContentResponseList);
				ApiTool.fillPagerData(page, dtoResponse);
				LOG.info("{}暂未通过认证，无法查看信息列表。", user.getUserName());
				return dtoResponse;
			}
			String orderby = StringUtils.isBlank(dtoRequest.getSortby()) ? " uptop_time desc, update_time desc " : dtoRequest.getSortby();
//			if(dtoRequest.getInfoType() != null && Integer.parseInt(dtoRequest.getInfoType()) == ContentInfoTypeEnum.ZHI_SHI_KU.getCode() ){
//				orderby = StringUtils.isBlank(dtoRequest.getSortby()) ? " uptop_time desc, CONVERT(a.title USING gbk ) " : dtoRequest.getSortby(); 
//			}
			List<JwContent> jwContents = new ArrayList<JwContent>();
			if (infoType.length() > 1) {// 实时热点(1警情通报 2协查通报 3社区动态 5防范小贴士 7热点新闻),每一类数据仅仅显示1条,且为已发布的消息
				jwContents = listShiShiReDian(dtoRequest, infoType, orderby);
				page.setTotalCount(jwContents.size());
			} else {
				if("8".equals(infoType)){//i学习
					jwContents = jwContentService.listZhengCheXueXi(dtoRequest.getSysSubjectId(), page, orderby, dtoRequest.getKeyword(),
							dtoRequest.getStatus(), dtoRequest.getInfoType(), dtoRequest.getUid());
				}else{
					jwContents = jwContentService.list(dtoRequest.getSysSubjectId(), page, orderby, dtoRequest.getKeyword(),
							dtoRequest.getStatus(), dtoRequest.getInfoType(), dtoRequest.getUid());
				}
			}
			for (JwContent jwContent : jwContents) {
				if(jwContent.getId().equals("c6c0efc99b244fcd803b8c8252b1d196")){
					System.out.println("aa");
				}
				DtoQueryJWContentExtResponse dtoQueryJWContentResponse = new DtoQueryJWContentExtResponse();
				BeanUtils.copyProperties(jwContent, dtoQueryJWContentResponse);
				dtoQueryJWContentResponse.setLink(contentPath + jwContent.getId());
				dtoQueryJWContentResponse.setInfoType(jwContent.getType());
				dtoQueryJWContentResponse.setInfoTypeName(ContentInfoTypeEnum.valueOf(jwContent.getType()).getDesc());
				if (jwContent.getUptopDays() != null && jwContent.getUptopDays().intValue() != 0) {// 计算置顶剩余天数
					int uptopDays = jwContent.getUptopDays();
					Date uptopTime = jwContent.getUptopTime();
					int remainderDays = uptopDays - DateTool.getDaysBetween(uptopTime, new Date());
					if (remainderDays < 0) {
						dtoQueryJWContentResponse.setUptopDays(0);// 剩余置顶天数=置顶天数-当前日期和置顶日期的间隔时间
					} else {
						dtoQueryJWContentResponse.setUptopDays(remainderDays);
					}
				}
				if (jwContent.getLearn() != null) {//已读列表
					dtoQueryJWContentResponse.setLearn(jwContent.getLearn());
				}
				dtoQueryJWContentResponseList.add(dtoQueryJWContentResponse);
			}
			ApiTool.fillPagerData(page, dtoResponse);
			dtoResponse.setData(dtoQueryJWContentResponseList);
		} catch (Exception e) {
			throw e;
//			dtoResponse.setCode(Constants.API_CODE_FAIL);
//			dtoResponse.setMsg("查询信息列表失败");
//			LOG.error(dtoResponse.getMsg() + " " + e.getMessage(), e);
		}
		return dtoResponse;
	}

	/**
	 * 实时热点
	 * @param dtoRequest
	 * @param infoType
	 * @param orderby
	 * @param jwContents
	 */
	private List<JwContent> listShiShiReDian(DtoQueryJWContentExtRequest dtoRequest, String infoType, String orderby) throws Exception {
		List<JwContent> jwContents = new ArrayList<JwContent>();
		String[] infoTypeArray = infoType.split(",");
		for (String type : infoTypeArray) {
			Page p = new Page(1, 1);
			dtoRequest.setStatus(ContentStatusEnum.YI_FA_BU.getCode().intValue());
			switch (type) {
				case "1":
					dtoRequest.setInfoType(ContentInfoTypeEnum.JING_QING_TONG_BAO.getCode().toString());
					List<JwContent> jingQingTongBao = jwContentService.list(null, p, orderby, null,
							dtoRequest.getStatus(), type, dtoRequest.getUid());
					jwContents.addAll(jingQingTongBao);
					break;
				case "2":
					dtoRequest.setInfoType(ContentInfoTypeEnum.XIE_CHA_TONG_BAO.getCode().toString());
					List<JwContent> xieChaTongBao = jwContentService.list(null, p, orderby, null,
							dtoRequest.getStatus(), type, dtoRequest.getUid());
					jwContents.addAll(xieChaTongBao);
					break;
				case "3":
					dtoRequest.setInfoType(ContentInfoTypeEnum.SHE_QU_DONG_TAI.getCode().toString());
					List<JwContent> sheQuDongTai = jwContentService.list(null, p, orderby, null,
							dtoRequest.getStatus(), type, dtoRequest.getUid());
					jwContents.addAll(sheQuDongTai);
					break;
				case "5":
					dtoRequest.setInfoType(ContentInfoTypeEnum.FANG_ZHA_PIAN.getCode().toString());
					List<JwContent> fangZhaPian = jwContentService.list(null, p, orderby, null,
							dtoRequest.getStatus(), type, dtoRequest.getUid());
					jwContents.addAll(fangZhaPian);
					break;
				case "7":
					dtoRequest.setInfoType(ContentInfoTypeEnum.ZHENG_CE_XUAN_CHUAN.getCode().toString());
					List<JwContent> zhengCeXuanChuan = jwContentService.list(null, p, orderby, null,
							dtoRequest.getStatus(), type, dtoRequest.getUid());
					jwContents.addAll(zhengCeXuanChuan);
					break;
				default:
					break;
			}
		}
		ContentComparator cc = new ContentComparator();
		Collections.sort(jwContents, cc);
		return jwContents;
	}

	@ApiDescription("重新发送消息通知;负责人：hongli")
	@RequestMapping("resentPushMsg")
	@ResponseBody
	public DtoPublicResponse resentPushMsg(@Valid DtoJWContentRequest dtoRequest) throws Exception{
		DtoPublicResponse dtoResponse = new DtoPublicResponse();
		try {
			jwContentService.sendPushMsg(dtoRequest.getId(), dtoRequest.getUid());
		} catch (Exception e) {
			throw e;
//			dtoResponse.setCode(Constants.API_CODE_FAIL);
//			dtoResponse.setMsg("重新发送消息通知失败");
//			LOG.error(dtoResponse.getMsg() + " " + e.getMessage(), e);
		}
		return dtoResponse;
	}

	@ApiDescription("更新信息内容;负责人：hongli")
	@RequestMapping("modifyJWContent")
	@ResponseBody
	public DtoPublicResponse modifyJWContent(@Valid DtoModifyJWContentRequest dtoRequest) throws Exception{
		DtoPublicResponse dtoResponse = new DtoPublicResponse();
		try {
			if (StringUtils.isBlank(dtoRequest.getId())) {// 新增
				if (StringUtils.isBlank(dtoRequest.getTitle())) {
					dtoResponse.setCode(Constants.API_CODE_FAIL);
					dtoResponse.setMsg("标题不能为空");
					return dtoResponse;
				}
				if (StringUtils.isBlank(dtoRequest.getContent())) {
					dtoResponse.setCode(Constants.API_CODE_FAIL);
					dtoResponse.setMsg("内容不能为空");
					return dtoResponse;
				}
				if (dtoRequest.getInfoType() == null || dtoRequest.getInfoType().intValue() == 0) {
					dtoResponse.setCode(Constants.API_CODE_FAIL);
					dtoResponse.setMsg("信息类型不能为空");
					return dtoResponse;
				}
				// 社区动态、消息通知、i学习必须要输入发布对象
				if (dtoRequest.getInfoType().intValue() == ContentInfoTypeEnum.SHE_QU_DONG_TAI.getCode().intValue()
						|| dtoRequest.getInfoType().intValue() == ContentInfoTypeEnum.XIAO_XI_TONG_ZHI.getCode().intValue()
						|| dtoRequest.getInfoType().intValue() == ContentInfoTypeEnum.ZHENG_CE_XUE_XI.getCode().intValue()) {
					if (StringUtils.isBlank(dtoRequest.getCommunityIds())) {
						dtoResponse.setCode(Constants.API_CODE_FAIL);
						dtoResponse.setMsg("发布对象不能为空");
						return dtoResponse;
					}
				}
				toAddContent(dtoRequest);
			} else {// 更新
				Date dd = new Date();
				JwContent jwContent = new JwContent();
				jwContent.setUpdaterId(dtoRequest.getUid());
				if (dtoRequest.getIsTop() == null) {// 置顶和取消置顶不改时间，其他操作修改updateTime
					jwContent.setUpdateTime(dd);
				}
				BeanUtils.copyProperties(dtoRequest, jwContent);

				if ("1".equals(dtoRequest.getDirectPublish())) {// 直接发布
					jwContent.setStatus(ContentStatusEnum.YI_FA_BU.getCode());// 3
				} else {
					//
					if (dtoRequest.getStatus() != null) {
						if (dtoRequest.getStatus().intValue() == ContentStatusEnum.YI_FA_BU.getCode()) {// 先新增后发布
							jwContentService.publish(dtoRequest.getId(), dtoRequest.getUid());
							dtoResponse.setCode(Constants.API_CODE_SUCCESS);
							return dtoResponse;
						} else if (dtoRequest.getStatus().intValue() == ContentStatusEnum.YI_CHE_XIAO.getCode()) {// 撤销
							jwContentService.remove(dtoRequest.getId(), dtoRequest.getUid());
							dtoResponse.setCode(Constants.API_CODE_SUCCESS);
							return dtoResponse;
						} else {
							jwContent.setStatus(dtoRequest.getStatus());
						}
					}
					jwContent.setMsgStatus(2);// 暂存
				}
				if (dtoRequest.getInfoType() != null && dtoRequest.getInfoType().intValue() != 0) {
					jwContent.setType(dtoRequest.getInfoType());// 信息类型
				}
				if (dtoRequest.getIsTop() != null && dtoRequest.getIsTop().intValue() == ContentTopEnum.TOP.getCode()) {
					// 判断数据库中当前类别下的置顶的条数
					if (!jwContentService.uptopCheck(3, jwContent.getType(), dtoRequest.getUid())) {
						dtoResponse.setCode(Constants.API_CODE_FAIL);
						dtoResponse.setMsg("最多允许置顶3条");
						return dtoResponse;
					}
					jwContent.setUptopDays(dtoRequest.getUptopDays());
					//如果是 type=9知识库，置顶时间无限
					if( jwContent.getType() == 9){
						jwContent.setUptopDays(365*20);
					}
					jwContent.setUptopId(dtoRequest.getUid());
					jwContent.setUptopTime(dd);
					String uptopEndtimeStr = DateTool.formatDate(dd) + " 23:59:59";
					Date uptopEndtime = DateTool.addDays(DateTool.parseDateTime(uptopEndtimeStr),
							jwContent.getUptopDays() - 1);
					jwContent.setUptopEndtime(uptopEndtime);
				}
				jwContentService.updateContentInfo(jwContent, dtoRequest.getCommunityIds(), dtoRequest.getIsTop());
			}
		} catch (Exception e) {
			throw e;
//			dtoResponse.setCode(Constants.API_CODE_FAIL);
//			dtoResponse.setMsg("更新信息内容失败");
//			LOG.error(dtoResponse.getMsg() + " " + e.getMessage(), e);
		}
		return dtoResponse;
	}

	private void toAddContent(DtoModifyJWContentRequest dtoRequest) throws Exception{
		JwContent jwContent = new JwContent();
		jwContent.setCreateId(dtoRequest.getUid());
		jwContent.setUpdaterId(dtoRequest.getUid());
		jwContent.setType(dtoRequest.getInfoType());// 信息类型
		BeanUtils.copyProperties(dtoRequest, jwContent);
		if (dtoRequest.getStatus() == null || dtoRequest.getStatus().intValue() == 0) {
			jwContent.setStatus(dtoRequest.getStatus());
		}
		if ("1".equals(dtoRequest.getDirectPublish())) {
			jwContent.setStatus(ContentStatusEnum.YI_FA_BU.getCode());// 3
		} else {
			jwContent.setMsgStatus(2);// 暂存
		}
		jwContentService.addContentInfo(jwContent, dtoRequest.getCommunityIds(), dtoRequest.getUid());
	}

	@ApiDescription("政策阅读接口;负责人：hongli")
	@RequestMapping("learn")
	@ResponseBody
	public DtoPublicResponse learn(@Valid DtoLearnRequest dtoRequest) throws Exception{
		DtoPublicResponse dtoResponse = new DtoPublicResponse();
		try {
			SysUser user = userSerivce.getUserById(dtoRequest.getUid());
			LOG.debug("用户{}已阅读{}", user.getUserName(), dtoRequest.getId());
			Date d = new Date();
			JwLearnRecord record = new JwLearnRecord();
			record.setContentId(dtoRequest.getId());
			record.setCreatetime(d);
			record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
			record.setName(user.getRealname());
			record.setTime(d);
			record.setUid(dtoRequest.getUid());
			jwLearnRecordService.insert(record);
		} catch (Exception e) {
			throw e;
//			dtoResponse.setCode(Constants.API_CODE_FAIL);
//			dtoResponse.setMsg("阅读出错");
//			LOG.error(dtoResponse.getMsg() + " " + e.getMessage(), e);
		}
		return dtoResponse;
	}

	@ApiDescription("查询网上办事事项列表;查询数据字典接口 code：businessMatters;负责人：hongli")
	@RequestMapping("getItemList")
	@ResponseBody
	public DtoPublicResponsePager<DtoQueryItemResponse> getItemList(@Valid DtoPublicRequestPager dtoRequest) throws Exception{
		DtoPublicResponsePager<DtoQueryItemResponse> dtoResponse = new DtoPublicResponsePager<DtoQueryItemResponse>();
		try {
			Page page = ApiTool.convert(dtoRequest);
			List<DtoQueryItemResponse> data = new ArrayList<>();
			for(String item:Constants.BUSINESS_MATTERS){
				DtoQueryItemResponse e = new DtoQueryItemResponse();
				e.setName(item);
				data.add(e);
			}
			page.setTotalCount(data.size());
			ApiTool.fillPagerData(page, dtoResponse);
			dtoResponse.setData(data);
		} catch (Exception e) {
			throw e;
//			dtoResponse.setCode(Constants.API_CODE_FAIL);
//			dtoResponse.setMsg("查询网上办事事项列表失败");
//			LOG.error(dtoResponse.getMsg() + " " + e.getMessage(), e);
		}
		return dtoResponse;
	}
	
	
	@ApiDescription("根据消息ID查询信息;负责人：luping")
	@RequestMapping("getJWContentByIds")
	@ResponseBody
	public DtoPublicResponseList<DtoQueryJWContentExtResponse> getJWContentByIds(@Valid DtoQueryJWContentByIdRequest dtoRequest) throws Exception {
		DtoPublicResponseList<DtoQueryJWContentExtResponse> dtoResponse = new DtoPublicResponseList<DtoQueryJWContentExtResponse>();
		try {
			List<DtoQueryJWContentExtResponse> dtoQueryJWContentResponseList = new ArrayList<DtoQueryJWContentExtResponse>();
			List<JwContent> jwContents = jwContentService.quneryByIds(dtoRequest.getIds());
			for (JwContent jwContent : jwContents) {
				DtoQueryJWContentExtResponse dtoQueryJWContentResponse = new DtoQueryJWContentExtResponse();
				BeanUtils.copyProperties(jwContent, dtoQueryJWContentResponse);
				dtoQueryJWContentResponse.setLink(contentPath + jwContent.getId());
				dtoQueryJWContentResponse.setInfoType(jwContent.getType());
				dtoQueryJWContentResponse.setInfoTypeName(ContentInfoTypeEnum.valueOf(jwContent.getType()).getDesc());
				if (jwContent.getUptopDays() != null && jwContent.getUptopDays().intValue() != 0) {// 计算置顶剩余天数
					int uptopDays = jwContent.getUptopDays();
					Date uptopTime = jwContent.getUptopTime();
					int remainderDays = uptopDays - DateTool.getDaysBetween(uptopTime, new Date());
					if (remainderDays < 0) {
						dtoQueryJWContentResponse.setUptopDays(0);// 剩余置顶天数=置顶天数-当前日期和置顶日期的间隔时间
					} else {
						dtoQueryJWContentResponse.setUptopDays(remainderDays);
					}
				}
				JwContentDeptExample example = new JwContentDeptExample();
				example.createCriteria().andContentIdEqualTo(jwContent.getId());
				List<JwContentDept> jwContentDepts = jwContentService.selectByExample(example);
				List<String> deptIds = new ArrayList<String>();
				for(JwContentDept jwContentDept:jwContentDepts){
					deptIds.add(jwContentDept.getDeptId());
				}
				List<SysDeptWithBLOBs> sysDepts = deptService.queryDeptByIds(deptIds);
				List<SysDeptExt> respDepts = new ArrayList<SysDeptExt>();
				respDepts = FuncTool.copyPropertiesList(sysDepts, SysDeptExt.class);
				dtoQueryJWContentResponse.setDept(respDepts);
				if(jwContent.getType()==8){
					//查询当前用户是否已阅读
					int read = jwLearnRecordService.selectReadByUidAndContentId(dtoRequest.getUid(), jwContent.getId());
					dtoQueryJWContentResponse.setCurrentUserRead(read);
					List<JwLearnRecordExt> learn = jwContentService.selectReadUserList(jwContent.getId());
					dtoQueryJWContentResponse.setLearn(learn);
					//根据部门ID查出总人数
					int usernum = userService.countByDeptIds(sysDepts);
					dtoQueryJWContentResponse.setTotal(usernum);
				}
				dtoQueryJWContentResponseList.add(dtoQueryJWContentResponse);
			}
			if(dtoQueryJWContentResponseList.size()>0){
				dtoResponse.setData(dtoQueryJWContentResponseList);
			}else{
				dtoResponse.setData(null);
			}
		} catch (Exception e) {
			throw e;
		}
		return dtoResponse;
	}
	
}
