package com.huaao.ejwplatform.api.control.sdk;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponse;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponseObj;
import com.huaao.ejwplatform.api.dto.sdk.DtoCriminalRecordRequest;
import com.huaao.ejwplatform.api.dto.sdk.DtoCriminalRecordResponse;
import com.huaao.ejwplatform.api.util.ResponseGenerator;
import com.huaao.ejwplatform.common.Constants;
import com.huaao.ejwplatform.common.util.DateTool;
import com.huaao.ejwplatform.common.util.JSONUtil;
import com.huaao.ejwplatform.common.web.ApiDescription;
import com.huaao.ejwplatform.dao.JwCriminalRecord;
import com.huaao.ejwplatform.dao.JwCriminalRecordExample;
import com.huaao.ejwplatform.dao.JwCriminalRecordExample.Criteria;
import com.huaao.ejwplatform.mapper.JwCriminalRecordMapper;
import com.huaao.ejwplatform.service.CriminalService;
import com.huaao.ejwplatform.service.PushService;
import com.huaao.ejwplatform.service.model.CriminalAuthStatusEnum;

@ApiDescription("第三方接口")
@Controller
@RequestMapping("/api/sdk")
public class CriminalRecordController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private JwCriminalRecordMapper recordMapper;
	
	@Autowired
	private PushService pushService;
	
	@Autowired
	private CriminalService criminalService;

	/**
	 * 查询无犯罪记录证明数据
	 * @param dtoRequest
	 * @return
	 */
	@ApiDescription("查询无犯罪记录证明数据;负责人：jinsu")
	@RequestMapping("queryUserRecord")
	@ResponseBody
	public DtoPublicResponseObj<JwCriminalRecord> queryUserList(@Valid DtoCriminalRecordRequest dtoRequest, @RequestHeader HttpHeaders headers){
		DtoPublicResponseObj<JwCriminalRecord> resp = new DtoPublicResponseObj<JwCriminalRecord>();
		String recordId = dtoRequest.getRecordId();
		String reply = dtoRequest.getReply();
		if(StringUtils.isEmpty(recordId)){
			resp.setCode(Constants.API_CODE_SDK_INVALID_PARAMS);//500
			resp.setMsg(Constants.API_MSG_SDK_INVALID_PARAMS);
			return resp;
		}
		String deviceInfo = headers.getFirst("deviceInfo");
		if(StringUtils.isEmpty(deviceInfo)){
			log.error("Invalid headers "+JSONUtil.jsonEncode(headers));
			resp.setCode(Constants.API_CODE_PERMISSION_DENIED);//500
			resp.setMsg(Constants.API_MSG_PARAMS_INVALID);
			return resp;
		}
		JwCriminalRecord record = recordMapper.selectByPrimaryKey(recordId);
		if(record == null){
			resp.setCode(Constants.API_CODE_SDK_NO_RECORDS);//500
			resp.setMsg(Constants.API_MSG_SDK_NO_RECORDS);
			return resp;
		}
		
		int authStatus = record.getAuthStatus();
		if(authStatus == 7){
			if(StringUtils.isEmpty(reply) || !reply.equals("1")){
				resp.setCode(Constants.API_CODE_SDK_RE_PRINT);
				String printTime = DateTool.dateToString(record.getPrintTime(), "yyyy-MM-dd HH:mm:ss");
				resp.setMsg(Constants.API_MSG_SDK_RE_PRINT + printTime);
			}else{
				resp.setData(record);
			}
		}else if(authStatus != 3){
			if(authStatus < 3){
				resp.setCode(Constants.API_CODE_SDK_WAIT_AUTH);
				resp.setMsg(Constants.API_MSG_SDK_WAIT_AUTH);
			}else if(authStatus == 8){
				resp.setCode(Constants.API_CODE_SDK_EXPIRDED);
				resp.setMsg(Constants.API_MSG_SDK_EXPIRDED);
			}else if(authStatus == 5){
				resp.setCode(Constants.API_CODE_SDK_AUTH_FAILED);
				resp.setMsg(Constants.API_MSG_SDK_AUTH_FAILED);
			}else{
				resp.setCode(Constants.API_CODE_SDK_USE_EMS);
				resp.setMsg(Constants.API_MSG_SDK_USE_EMS);
			}
		}else{
			resp.setData(record);
		}
		return resp;
	}
	
	/**
	 * 更新无犯罪记录证明打印日志
	 * @param dtoRequest
	 * @return
	 */
	@ApiDescription("更新无犯罪记录证明打印状态;负责人：jinsu")
	@RequestMapping("updateStatus")
	@ResponseBody
	public DtoPublicResponse updatePrintStatus(@Valid DtoCriminalRecordRequest dtoRequest, @RequestHeader HttpHeaders headers){
		log.error("updatePrintStatus request params "+JSONUtil.jsonEncode(dtoRequest));
		DtoPublicResponse resp = new DtoPublicResponse();
		String recordId = dtoRequest.getRecordId();
		String number = dtoRequest.getIdCardNo();
		String status = dtoRequest.getStatus();
		if(StringUtils.isEmpty(number) || StringUtils.isEmpty(recordId) || StringUtils.isEmpty(status)){
			resp.setCode(Constants.API_CODE_SDK_INVALID_PARAMS);//500
			resp.setMsg(Constants.API_MSG_SDK_INVALID_PARAMS);
			return resp;
		}
		
		String deviceInfo = headers.getFirst("deviceInfo");
		if(StringUtils.isEmpty(deviceInfo)){
			resp.setCode(Constants.API_CODE_PERMISSION_DENIED);//500
			resp.setMsg(Constants.API_MSG_PARAMS_INVALID);
			return resp;
		}
		
		JwCriminalRecord jwRecord = recordMapper.selectByPrimaryKey(recordId);
		if(jwRecord == null){
			resp.setCode(Constants.API_CODE_SDK_NO_RECORDS);//500
			resp.setMsg(Constants.API_MSG_SDK_NO_RECORDS);
			return resp;
		}
		
		int authStatus = jwRecord.getAuthStatus();
		if(authStatus != 3 && authStatus != 7){
			if(authStatus < 3){
				resp.setCode(Constants.API_CODE_SDK_WAIT_AUTH);
				resp.setMsg(Constants.API_MSG_SDK_WAIT_AUTH);
			}else if(authStatus == 8){
				resp.setCode(Constants.API_CODE_SDK_EXPIRDED);
				resp.setMsg(Constants.API_MSG_SDK_EXPIRDED);
			}else if(authStatus == 5){
				resp.setCode(Constants.API_CODE_SDK_AUTH_FAILED);
				resp.setMsg(Constants.API_MSG_SDK_AUTH_FAILED);
			}else{
				resp.setCode(Constants.API_CODE_SDK_USE_EMS);
				resp.setMsg(Constants.API_MSG_SDK_USE_EMS);
			}
			return resp;
		}
		
		JwCriminalRecord record = new JwCriminalRecord();
		record.setId(recordId);
		record.setPrintIdcrad(number);
		record.setReceiverName(dtoRequest.getName());
		try{
			int printStatus = Integer.parseInt(status);
			record.setStatus(printStatus);
			if(printStatus == 1){
				record.setPrintTime(new Date());
				record.setAuthStatus(7);
				record.setUpdateTime(new Date());
				criminalService.logApply("", recordId, CriminalAuthStatusEnum.YI_LING_QU, null, new Date());
			}
			recordMapper.updateByPrimaryKeySelective(record);
			if(printStatus == 1){
				pushService.createApplyPushMessage(recordId);
			}
		}catch(Exception ex){
			log.error("Wrong status value can't parse Int "+ status);
		}
		
		return resp;
		
	}
}
