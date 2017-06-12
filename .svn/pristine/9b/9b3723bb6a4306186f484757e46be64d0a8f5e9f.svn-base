package com.huaao.ejwplatform.api.control;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huaao.ejwplatform.api.dto.banner.DtoGetBannerListRequest;
import com.huaao.ejwplatform.api.dto.bean.BannerInfo;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponsePager;
import com.huaao.ejwplatform.common.Constants;
import com.huaao.ejwplatform.common.util.FuncTool;
import com.huaao.ejwplatform.common.web.ApiDescription;
import com.huaao.ejwplatform.dao.JwDeptBanner;
import com.huaao.ejwplatform.dao.SysDeptWithBLOBs;
import com.huaao.ejwplatform.dao.SysUser;
import com.huaao.ejwplatform.service.BannerService;
import com.huaao.ejwplatform.service.UserService;
import com.huaao.ejwplatform.service.system.DeptService;

import net.sf.json.JSONObject;

@ApiDescription("其他")
@Controller
@RequestMapping("api/banner")
public class BannerController {
	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private BannerService bannerService; 
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DeptService deptService;
	
	@ApiDescription("APP banner列表接口;负责人：lihao;"
			+ "未实名认证时显示默认banner，实名认证后按社区获取后台配置的banner;"
			+ "按添加的时间顺序显示；每3s自动轮播一张，为循环轮播,最多支持5张轮播图;"
			+ "接口按当前用户所在派出所去查询对应的轮播图")
	@RequestMapping(value="getBannerList")
	@ResponseBody
	public DtoPublicResponsePager<BannerInfo> getBannerList(@Valid DtoGetBannerListRequest dtoRequest){
		DtoPublicResponsePager<BannerInfo> dtoResponse = new DtoPublicResponsePager<>();
		try {
			SysUser user = userService.getUserById(dtoRequest.getUid());
			if(!"authed".equals(user.getAuth())){
				dtoResponse.setCode(Constants.API_CODE_FAIL);
				dtoResponse.setMsg("用户未实名认证");
				return dtoResponse;
			}
			if(StringUtils.isEmpty(user.getDeptId())){
				dtoResponse.setCode(Constants.API_CODE_FAIL);
				dtoResponse.setMsg("用户所属部门不能为空");
				return dtoResponse;
			}
			SysDeptWithBLOBs dept = deptService.getDeptById(user.getDeptId());
			String code = dept.getCode();//按照用户所属派出所获取轮播图
			code = (code != null && code.length() >= 15) ? code.substring(0, 15):code;
			SysDeptWithBLOBs dept2 = deptService.getDeptByCode(code);
			List<JwDeptBanner> list = bannerService.queryDeptBanner(dept2.getId(), 1,dtoRequest.getSortby(), dtoRequest.getType());
//			List<JwDeptBanner> list = bannerService.queryBanner(1, dtoRequest.getSortby());
			dtoResponse.setData(FuncTool.copyPropertiesList(list, BannerInfo.class));
			return dtoResponse;
		} catch (Exception e) {
			dtoResponse.setCode(Constants.API_CODE_FAIL);
			dtoResponse.setMsg("查询banner图失败");
			log.error(dtoResponse.getMsg() + " " + e.getMessage(), e);
		}
		return dtoResponse;
	}
}
