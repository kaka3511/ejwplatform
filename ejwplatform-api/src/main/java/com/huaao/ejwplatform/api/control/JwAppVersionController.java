package com.huaao.ejwplatform.api.control;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponseObj;
import com.huaao.ejwplatform.api.dto.version.DtoJwAppVersionRequest;
import com.huaao.ejwplatform.common.Constants;
import com.huaao.ejwplatform.common.web.ApiDescription;
import com.huaao.ejwplatform.dao.JwAppVersion;
import com.huaao.ejwplatform.service.JwAppVersionService;

@ApiDescription("其他")
@Controller
@RequestMapping("api/jwAppVersion")
public class JwAppVersionController {
	private static final Logger LOG = LoggerFactory.getLogger(JwAppVersionController.class);
	
	@Autowired
	private JwAppVersionService jwAppVersionService;

	@ApiDescription("查询app最新的版本号接口;负责人：hongli")
	@RequestMapping("queryLatestVersoin")
	@ResponseBody
	public DtoPublicResponseObj<JwAppVersion> queryLatestVersoin(@Valid DtoJwAppVersionRequest dtoRequest) {
		DtoPublicResponseObj<JwAppVersion> dtoResponse = new DtoPublicResponseObj<JwAppVersion>();
		try {
			JwAppVersion jwAppVersion = jwAppVersionService.queryLatestVersoin();
			dtoResponse.setData(jwAppVersion);
		} catch (Exception e) {
			e.printStackTrace();
			dtoResponse.setCode(Constants.API_CODE_FAIL);
			dtoResponse.setMsg("查询app最新的版本号接口失败");
			LOG.error(dtoResponse.getMsg() + " " + e.getMessage(), e);
		}
		return dtoResponse;
	}
}

