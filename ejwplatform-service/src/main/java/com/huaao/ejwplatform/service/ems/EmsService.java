package com.huaao.ejwplatform.service.ems;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.http.client.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huaao.ejwplatform.common.Constants;
import com.huaao.ejwplatform.common.ErrorInfo;
import com.huaao.ejwplatform.common.Page;
import com.huaao.ejwplatform.common.util.DateTool;
import com.huaao.ejwplatform.common.util.JSONUtil;
import com.huaao.ejwplatform.common.util.MD5;
import com.huaao.ejwplatform.common.web.EmsOrder;
import com.huaao.ejwplatform.common.web.EmsUtils;
import com.huaao.ejwplatform.dao.JwBusinessDept;
import com.huaao.ejwplatform.dao.JwBusinessDeptExample;
import com.huaao.ejwplatform.dao.JwCriminalRecord;
import com.huaao.ejwplatform.dao.JwEms;
import com.huaao.ejwplatform.dao.JwEmsArea;
import com.huaao.ejwplatform.dao.JwEmsAreaExample;
import com.huaao.ejwplatform.dao.JwEmsExample;
import com.huaao.ejwplatform.dao.JwEmsInfo;
import com.huaao.ejwplatform.dao.JwEmsPayResult;
import com.huaao.ejwplatform.dao.JwEmsPayResultExample;
import com.huaao.ejwplatform.dao.JwEmsStatus;
import com.huaao.ejwplatform.dao.JwEmsStatusExample;
import com.huaao.ejwplatform.dao.SysArea;
import com.huaao.ejwplatform.dao.SysAreaExample;
import com.huaao.ejwplatform.dao.SysAreaExt;
import com.huaao.ejwplatform.dao.SysDept;
import com.huaao.ejwplatform.dao.SysUser;
import com.huaao.ejwplatform.mapper.JwBusinessDeptMapper;
import com.huaao.ejwplatform.mapper.JwCriminalRecordMapper;
import com.huaao.ejwplatform.mapper.JwEmsAreaMapper;
import com.huaao.ejwplatform.mapper.JwEmsInfoMapper;
import com.huaao.ejwplatform.mapper.JwEmsMapper;
import com.huaao.ejwplatform.mapper.JwEmsPayResultMapper;
import com.huaao.ejwplatform.mapper.JwEmsStatusMapper;
import com.huaao.ejwplatform.mapper.SysDeptMapper;
import com.huaao.ejwplatform.mapper.SysUserMapper;
import com.huaao.ejwplatform.service.ApplyRecordService;
import com.huaao.ejwplatform.service.CriminalService;
import com.huaao.ejwplatform.service.PushService;
import com.huaao.ejwplatform.service.model.CriminalAuthStatusEnum;
import com.huaao.ejwplatform.service.system.AreaService;

@Service
public class EmsService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired
	private JwEmsMapper jwEmsMapper;
	
	@Autowired
	private JwEmsStatusMapper jwEmsStatusMapper;
	
	@Autowired
	private JwEmsAreaMapper jwEmsAreaMapper;
	
	@Autowired
	private JwCriminalRecordMapper recordMapper;
	
	@Autowired
	private SysDeptMapper deptMapper;
	
	@Autowired
	private AreaService areaService;
	
	@Autowired
	private JwEmsInfoMapper infoMapper;
	
	@Autowired
	private ApplyRecordService applyRecordService;
	
	@Autowired
	private PushService pushService;

	@Autowired
	private JwEmsPayResultMapper payMapper;
	
	@Autowired
	private JwEmsAreaMapper emsAreaMapper;
	
	@Autowired
	private JwBusinessDeptMapper jwBusinessDeptMapper;
	
	@Autowired
	private CriminalService criminalService;
	

	/**
	 * support ems interface
	 * @param recordId
	 * @return
	 */
	public EmsOrder createEmsOrderData(String recordId, String bidOrderNo){
		EmsOrder order = new EmsOrder();
        JwEmsInfo jwInfo = infoMapper.selectByPrimaryKey(recordId);
		if(jwInfo == null){
			return null;
		}
		JwCriminalRecord record = recordMapper.selectByPrimaryKey(recordId);
		String code = findEmsPoliceCode(record.getDeptId());
		order.setOrderGuid(bidOrderNo);
		order.setReceiveAddr(jwInfo.getAddress());
		order.setReceiveLinker(jwInfo.getUsername());
		order.setReceiveLinkMobile(jwInfo.getPhone());
		order.setReceiveDistCode(jwInfo.getAreaId());
		order.setPoliceCode(code);
		return order;
	}
	
	public String getEmsAreaCode(String areaName){
		JwEmsArea area = null;
		if(areaName != null){
			JwEmsAreaExample exam = new JwEmsAreaExample();
	        exam.createCriteria().andNameEqualTo(areaName);
	        area = jwEmsAreaMapper.selectByExample(exam).get(0);
	        return area.getId().toString();
		}
		return null;
	}
	
	public String findEmsPoliceCode(String deptId){
		JwBusinessDeptExample example = new JwBusinessDeptExample();
		example.createCriteria().andDeptIdEqualTo(deptId);
		List<JwBusinessDept> list = jwBusinessDeptMapper.selectByExample(example);
		String code = "WJWEMS";
		if(list!=null && list.size() > 0){
			code = list.get(0).getCode();
		}
		return code;
	}

	public String genEmsOrderNo(String recordId, String deptId){
		String code = findEmsPoliceCode(deptId);
		//orderNo length must less than 32
		String orderNo = code + MD5.encryptionMD5(recordId+DateTool.formatDateTime(new Date())).substring(8, 24);
		JwEmsPayResult payInfo = new JwEmsPayResult();
		payInfo.setBizOrderNo(orderNo);
		payInfo.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		payInfo.setCreateTime(new Date());
		payInfo.setRecordId(recordId);
		payInfo.setPayResult("01");
		payMapper.insert(payInfo);
		return orderNo;
	}
	
	public String getRecordIdByOrderNo(String orderNo){
		JwEmsPayResultExample example = new JwEmsPayResultExample();
		example.createCriteria().andBizOrderNoEqualTo(orderNo);
		List<JwEmsPayResult> list = payMapper.selectByExample(example);
		if(list == null || list.size() == 0){
			return null;
		}
		return list.get(0).getRecordId();
	}
	
	public ErrorInfo pushEmsOrder(String recordId, String bidOrderNo){
		JwCriminalRecord record = recordMapper.selectByPrimaryKey(recordId);
		if(record ==  null){
			return new ErrorInfo(Constants.API_CODE_EMS_NOTEXSITS, Constants.API_MSG_EMS_NOTEXSITS);
		}
		
//		SysUser senderUser = sysUserMapper.selectByPrimaryKey(record.getPoliceId());
//		if(senderUser == null || record.getAuthStatus() != 4){
//			return new ErrorInfo(Constants.API_CODE_EMS_STATE_ERROR, Constants.API_MSG_EMS_STATE_ERROR);
//		}
		
		Map<String, List<EmsOrder>> params = new HashMap<String, List<EmsOrder>>();
		EmsOrder info = createEmsOrderData(recordId, bidOrderNo);
		if(info == null){
			return new ErrorInfo(Constants.API_CODE_EMS_NO_ADDRESS, Constants.API_MSG_EMS_NO_ADDRESS);
		}
		log.info("order info "+JSONUtil.jsonEncode(info));
		List<EmsOrder> orders = new ArrayList<EmsOrder>();
		orders.add(info);
		params.put("data", orders);
		String result = EmsUtils.createNewOrder(JSONUtil.jsonEncode(params));
		log.info("ems order result "+result);
		Map<String, Object> map = JSONUtil.decodeJsonToMap(result);
		if(map.get("status").equals("0")){
			List<Map<String, Object>> data = (List<Map<String, Object>>) map.get("data");
			for(Map<String, Object> mail: data){
				JwEms ems = new JwEms();
				ems.setId(UUID.randomUUID().toString().replaceAll("-", ""));
				ems.setTxLogisticId((String) mail.get("orderGuid"));
				ems.setMailNum((String) mail.get("mailNo"));
				ems.setCreateTime(new Date());
				jwEmsMapper.insertSelective(ems);
			}
			return null;
		}else{
			return new ErrorInfo(Constants.API_CODE_SERVER_ERROR, Constants.API_MSG_EMS_API_ERROR + (String) map.get("message"));
		}
	}
	
	public ErrorInfo saveEmsMailNum(String txLogisticID, String status, String mailNum, String desc){
		if(StringUtils.isEmpty(mailNum) || StringUtils.isEmpty(txLogisticID)){
			return new ErrorInfo(Constants.API_CODE_EMS_INVALID_PARAMS, Constants.API_MSG_EMS_INVALID_PARAMS);
		}
		JwCriminalRecord record = new JwCriminalRecord();
		record.setId(txLogisticID);
		if(recordMapper.selectByPrimaryKey(txLogisticID) ==  null){
			return new ErrorInfo(Constants.API_CODE_EMS_NOTEXSITS, Constants.API_MSG_EMS_NOTEXSITS);
		}
		JwEmsExample exam = new JwEmsExample();
		com.huaao.ejwplatform.dao.JwEmsExample.Criteria c = exam.createCriteria();
		c.andMailNumEqualTo(mailNum);
		List<JwEms> emsList = jwEmsMapper.selectByExample(exam);
		if(emsList != null && emsList.size() > 0){
			return new ErrorInfo(Constants.API_CODE_EMS_DUPLICATE, Constants.API_MSG_EMS_DUPLICATE);
		}
		Date dt = Calendar.getInstance().getTime();
		JwEms ems = new JwEms();
		ems.setCreateTime(dt);
		ems.setDesc(desc);
		ems.setTxLogisticId(txLogisticID);
		ems.setMailNum(mailNum);
		ems.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		try{
			int state = Integer.parseInt(status);
			ems.setStatus(state);
			if(state == 1){
				applyRecordService.add(1, "", txLogisticID, 4, "已邮寄","", dt);
			}else{
				applyRecordService.add(1, "", txLogisticID, 4, "邮寄失败","邮寄失败,原因是:"+EmsUtils.getEmsMessage(status), dt);
			}
			//save record status
			record.setStatus(4);
			recordMapper.updateByPrimaryKeySelective(record);
			pushService.createApplyPushMessage(txLogisticID);
		}catch(Exception ex){
			log.error("Wrong status data "+ status);
		}
		jwEmsMapper.insert(ems);
		return null;
	}
	
	public String saveEmsMailStatus(List<Object> params){
		List<String> failmailnums = new ArrayList<String>();
		for(Object obj: params){
			Map<String, Object> map = (Map<String, Object>) obj;
			try{
				JwEmsStatus emsStatus = new JwEmsStatus();
				emsStatus.setId(UUID.randomUUID().toString().replaceAll("-", ""));
				String mailNum = (String) map.get("mailnum");
				emsStatus.setMailNum(mailNum);
				emsStatus.setSerialNumber((String) map.get("serialnumber"));
				emsStatus.setProcdate((String) map.get("procdate"));
				emsStatus.setProctime((String) map.get("proctime"));
				emsStatus.setOrgFullName((String) map.get("orgfullname"));
				emsStatus.setDescription((String) map.get("description"));
				try{
					emsStatus.setEffect(Integer.parseInt((String) map.get("effect")));
				}catch(Exception ex){
					log.error("Wrong effect value set default 0");
					emsStatus.setEffect(0);
				}
				emsStatus.setProperDelivery((String) map.get("properdelivery"));
				emsStatus.setNotProperDelivery((String) map.get("notProperDelivery"));
				String action = map.get("action").toString();
				emsStatus.setAction(action);
				if(action.equals("10")){
					JwEmsExample exam = new JwEmsExample();
					com.huaao.ejwplatform.dao.JwEmsExample.Criteria c = exam.createCriteria();
					c.andMailNumEqualTo(mailNum);
					List<JwEms> emsList = jwEmsMapper.selectByExample(exam);
					if(emsList != null && emsList.size() == 1){
						criminalService.confirmEmsRecord(getRecordIdByOrderNo(emsList.get(0).getTxLogisticId()));
					}else{
						log.error("Not exsits ems record!");
					}
				}
				jwEmsStatusMapper.insert(emsStatus);
			}catch(Exception ex){
				ex.printStackTrace();
				failmailnums.add((String) map.get("mailnum"));
			}
		}
		return org.apache.commons.lang.StringUtils.join(failmailnums.toArray(), ",");
	}
	
	/**
	 * 根据recordId查询物流订单
	 * @param recordId
	 * @return
	 */
	public JwEms selectByRecordId(String recordId){
		JwEmsPayResultExample exam = new JwEmsPayResultExample();
		exam.createCriteria().andRecordIdEqualTo(recordId).andPayResultEqualTo("02");
		exam.setOrderByClause("create_time desc");
		List<JwEmsPayResult> result = payMapper.selectByExample(exam );
		String emsOrderNo = null;
		if(result != null && result.size() > 0){
			emsOrderNo = result.get(0).getBizOrderNo();
		}else{
			return null;
		}
		JwEmsExample example = new JwEmsExample();
		example.createCriteria().andTxLogisticIdEqualTo(emsOrderNo);
		example.setOrderByClause("create_time desc");
		example.setLimit(1);
		List<JwEms> jwEmsList = jwEmsMapper.selectByExample(example);
		if(jwEmsList != null && jwEmsList.size() > 0){
			return jwEmsList.get(0);
		}
		return null;
	}
	
	/**
	 * 根据mailNum查询物流信息
	 * @param mailNum
	 * @return
	 */
	public List<JwEmsStatus> selectEmsStatusByMailNum(String mailNum){
		JwEmsStatusExample example = new JwEmsStatusExample();
		example.createCriteria().andMailNumEqualTo(mailNum);
		example.setOrderByClause(" procdate desc, proctime desc ");
		return jwEmsStatusMapper.selectByExample(example);
	}
	
	/**
	 * 根据recordId查物流订单信息(收件人)
	 * @param recordId
	 * @return
	 */
	public JwEmsInfo selectEmsInfoByRecordId(String recordId){
		return infoMapper.selectByPrimaryKey(recordId);
	}
	
	/**
	 * 查询物流信息
	 * @param mailNum 物流单订单号
	 * @param action  动作
	 * @return
	 */
	public JwEmsStatus selectByMainNumAndAction(String mailNum, String action){
		JwEmsStatusExample example = new JwEmsStatusExample();
		example.createCriteria().andMailNumEqualTo(mailNum).andActionEqualTo(action);
		example.setOrderByClause(" procdate desc, proctime desc ");
		example.setLimit(1);
		List<JwEmsStatus> emsStatusList = jwEmsStatusMapper.selectByExample(example);
		if(emsStatusList != null && emsStatusList.size() > 0){
			return emsStatusList.get(0);
		}else{
			return null;
		}
	}
	
	/**
	 * 获取EMS区域列表，如果没有parentId，获取根区域，否则根据parentid获取子列表
	 * @param parentId
	 * @return
	 */
	public List<JwEmsArea> selectAreaList(Page page, String sortby, String parentId) {
		JwEmsAreaExample areaExample = new JwEmsAreaExample();
		if(StringUtils.isEmpty(parentId)){
			areaExample.createCriteria().andLevelTypeEqualTo(1);
		}else{
			areaExample.createCriteria().andParentIdEqualTo(Integer.parseInt(parentId));
			
		}
		int total = emsAreaMapper.countByExample(areaExample);
		page.setTotalCount(total);
		areaExample.setOffset(page.getOffset());
		areaExample.setLimit(page.getPageSize());
		areaExample.setOrderByClause(sortby);
		return emsAreaMapper.selectByExample(areaExample);
	}
	
	/**
	 * 根据ID查询区域信息
	 * @param areaId
	 * @return
	 */
	public JwEmsArea getAreaInfo(String areaId){
		return emsAreaMapper.selectByPrimaryKey(Integer.parseInt(areaId));
	}
}
