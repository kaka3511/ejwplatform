package com.huaao.ejwplatform.dao;

import java.io.Serializable;

public class JwMeetingParticipant extends JwMeetingParticipantKey implements Serializable {
    private Long beginTime;

    private static final long serialVersionUID = 1L;

    public Long getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Long beginTime) {
        this.beginTime = beginTime;
    }
}