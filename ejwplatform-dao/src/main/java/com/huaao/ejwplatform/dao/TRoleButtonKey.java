package com.huaao.ejwplatform.dao;

import java.io.Serializable;

public class TRoleButtonKey implements Serializable {
    private String tRoleId;

    private String tButtonId;

    private static final long serialVersionUID = 1L;

    public String gettRoleId() {
        return tRoleId;
    }

    public void settRoleId(String tRoleId) {
        this.tRoleId = tRoleId == null ? null : tRoleId.trim();
    }

    public String gettButtonId() {
        return tButtonId;
    }

    public void settButtonId(String tButtonId) {
        this.tButtonId = tButtonId == null ? null : tButtonId.trim();
    }
}