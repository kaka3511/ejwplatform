package com.huaao.ejwplatform.api.dto.pub;

import com.huaao.ejwplatform.common.Constants;

public class DtoValidationError extends DtoPublicResponse{
 
	private Integer count = 0;
	public DtoValidationError(){
		this.setCode(Constants.API_CODE_PARAMS_INVALID);
	}
	public void addFieldError(String path, String message) {
		if(count > 0){
			this.addMsg(" , ");
        }
        this.addMsg("'"+path + "':'"+message+"'" );
        count++;
        
    }
	
	public void addFieldError(String message) {
		if(count > 0){
			this.addMsg(" , ");
        }
        this.addMsg(message);
        count++;
        
    }

}
