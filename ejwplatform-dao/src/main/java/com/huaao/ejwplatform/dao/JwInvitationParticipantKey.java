package com.huaao.ejwplatform.dao;

import java.io.Serializable;

public class JwInvitationParticipantKey implements Serializable {
    private String uid;

    private String invitationid;

    private static final long serialVersionUID = 1L;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getInvitationid() {
        return invitationid;
    }

    public void setInvitationid(String invitationid) {
        this.invitationid = invitationid == null ? null : invitationid.trim();
    }
}