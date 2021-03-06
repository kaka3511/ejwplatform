package com.huaao.ejwplatform.common.util;
import java.util.Date;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class JsonDateValueProcessor implements JsonValueProcessor {  
      
    public JsonDateValueProcessor() {  
        super();  
    }  
    @Override  
    public Object processArrayValue(Object paramObject,  
            JsonConfig paramJsonConfig) {  
        return process(paramObject);  
    }  
    @Override  
    public Object processObjectValue(String paramString, Object paramObject,  
            JsonConfig paramJsonConfig) {  
        return process(paramObject);  
    }  
    private Object process(Object value){  
        if(value!=null && value instanceof Date){    
             return ((Date)value).getTime();
        }    
        return value ;    
    }  
}  
