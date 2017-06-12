package com.huaao.ejwplatform.service.model;

import org.apache.commons.lang.ArrayUtils;


public enum UserType {

	//1居民 2民警 3群干 4网格员 5医生 6社区医生
	Citizen(1), Police(2),  Cadre(3), GridAdmin(4), Doctor(5),CDoctor(6),Guard(7);

	private static final UserType[] ADMIN_TYPES = {Police, Cadre, GridAdmin, Doctor};
	public int value;


	UserType(int val) {
		this.value = (int)val;
	}
	
	public static final UserType of(int val) {
		for(UserType ut : UserType.values()) {
			if(ut.value == val) {
				return ut;
			}
		}
		return null;
	}

	public static boolean canUsePoliceApp(UserType ut) {
		if(ut == null) {
			return false;
		}
		return ArrayUtils.contains(ADMIN_TYPES, ut);
	}
}
