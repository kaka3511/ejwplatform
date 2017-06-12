package com.huaao.ejwplatform.api.control;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.huaao.ejwplatform.api.dto.html.DtoGetContentRequest;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponse;
import com.huaao.ejwplatform.common.Constants;
import com.huaao.ejwplatform.common.web.ApiDescription;
import com.huaao.ejwplatform.dao.JwContent;
import com.huaao.ejwplatform.service.JwContentService;

@Controller
@RequestMapping("api/html")
public class HtmlController {
	private static final Logger LOG = LoggerFactory.getLogger(HtmlController.class);

	@Autowired
	private JwContentService jwContentService;
	
	@ApiDescription("查看信息内容接口")
	@RequestMapping("getContent")
	public ModelAndView getContent(@Valid DtoGetContentRequest dtoGetContentRequest) {
		DtoPublicResponse dtoResponse = new DtoPublicResponse();
		JwContent jwContent = null;
		try {
			jwContent = jwContentService.selectByPrimaryKey(dtoGetContentRequest.getId());
		} catch (Exception e) {
			dtoResponse.setCode(Constants.API_CODE_FAIL);
			dtoResponse.setMsg("查看信息内容失败");
			LOG.error(dtoResponse.getMsg() + " " + e.getMessage(), e);
		}
		return new ModelAndView("/WEB-INF/jsp/news.jsp","content",jwContent);
	}
}
