package com.huaao.ejwplatform.api.control;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huaao.ejwplatform.api.dto.bean.DictBean;
import com.huaao.ejwplatform.api.dto.dict.DtoDictFindRequest;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponseList;
import com.huaao.ejwplatform.common.util.FuncTool;
import com.huaao.ejwplatform.common.web.ApiDescription;
import com.huaao.ejwplatform.common.web.SystemException;
import com.huaao.ejwplatform.dao.SysDict;
import com.huaao.ejwplatform.service.system.DictService;

@ApiDescription("其他")
@Controller
@RequestMapping("api/dict")
public class DictController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DictService dictService;
	
	@ApiDescription("数据字典查询;根据父级ID，查找子节点")
	@RequestMapping("findByParent")
	@ResponseBody
	public DtoPublicResponseList<DictBean> findByParent(@Valid DtoDictFindRequest dtoRequest) throws Exception{
		DtoPublicResponseList list = new DtoPublicResponseList<>();
		SysDict sd = dictService.findByCode(dtoRequest.getCode());
		if(sd == null){
			throw  SystemException.init("code: "+dtoRequest.getCode()+"; 不存在");
		}
		List<DictBean> dicts = FuncTool.copyPropertiesList(dictService.findByParent(sd.getId()), DictBean.class);
		list.setData(dicts);
		return list;
	}
}
