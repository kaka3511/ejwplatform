package com.huaao.ejwplatform.api.dto.systemtool;

import java.util.List;

import com.huaao.ejwplatform.api.dto.pub.DtoPublicRequest;
import com.huaao.ejwplatform.api.dto.pub.DtoPublicResponse;

public class DtoQueryAllApiResponse extends DtoPublicResponse{

	private List<String> data;

	public List<String> getData() {
		return data;
	}

	public void setData(List<String> data) {
		this.data = data;
	}
	
	
	
}
