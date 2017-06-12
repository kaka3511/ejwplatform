package com.huaao.ejwplatform.api.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huaao.ejwplatform.api.dto.bean.JWNoticeInfo;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequestPager;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponsePager;
import com.huaao.ejwplatform.api.util.ApiTool;
import com.huaao.ejwplatform.common.util.FuncTool;
import com.huaao.ejwplatform.common.web.ApiDescription;
import com.huaao.ejwplatform.dao.JwNotice;
import com.huaao.ejwplatform.service.NoticeService;

import net.sf.json.JSONObject;

@ApiDescription("其他")
@Controller
@RequestMapping("api/notice")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@ApiDescription("查询通知列表接口;负责人：lihao")
	@RequestMapping(value="getJWNoticeList")
	@ResponseBody
	public DtoPublicResponsePager<JWNoticeInfo> getJWNoticeList(DtoPublicRequestPager dtoRequest)  throws Exception {
		DtoPublicResponsePager<JWNoticeInfo> dtoResponse = new DtoPublicResponsePager<>();
		List<JwNotice> list = noticeService.queryNotice(ApiTool.convert(dtoRequest),dtoRequest.getUid());
		dtoResponse.setData(FuncTool.copyPropertiesList(list, JWNoticeInfo.class));
		return dtoResponse;
	}
}
