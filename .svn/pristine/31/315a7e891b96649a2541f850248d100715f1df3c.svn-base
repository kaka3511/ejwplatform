package com.huaao.ejwplatform.api.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

public class ResponseGenerator {

	/**
	 * auto set resp value for same fields
	 * @param resp
	 * @param model
	 */
	public static void createRespByModel(Object resp, Object model){
		if(resp == null || model == null){
			return;
		}
		
		Class<?> respClz = resp.getClass();
		Class<?> modelClz = model.getClass();
		
		Field[] respFields = respClz.getDeclaredFields();

		for(Field field: respFields){
			String ftype = field.getGenericType().toString();
			String fname =  field.getName();
			Field mField;
			try {
				mField = modelClz.getDeclaredField(fname);
				if(mField != null){
					String mtype = mField.getGenericType().toString();
					if(ftype.equals(mtype)){
						Method getValue = modelClz.getMethod("get"+getMethodName(fname));
						Object value = getValue.invoke(model);
						field.set(resp, value);
					}else if(mtype.equals("class java.util.Date")){
						Method getValue = modelClz.getMethod("get"+getMethodName(fname));
						Date d = (Date) getValue.invoke(model);
						field.set(resp, d.getTime());
					}
				}
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	private static String getMethodName(String fildeName) throws Exception{
		byte[] items = fildeName.getBytes();
		items[0] = (byte) ((char) items[0] - 'a' + 'A');
		return new String(items);
	}
	
}
