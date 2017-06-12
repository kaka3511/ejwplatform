package com.huaao.ejwplatform.service.model;

public enum MeetingRoomType {
	Internal(1), Mediate(2), Interact(3);

	public Integer value;

	MeetingRoomType(Integer val) {
		this.value = (Integer) val;
	}

	public static final MeetingRoomType of(Integer type) {
		for (MeetingRoomType at : MeetingRoomType.values()) {
			if (at.value == type) {
				return at;
			}
		}
		return null;
	}
}
