package com.huaao.ejwplatform.dao;

import java.io.Serializable;

public class TRoleMenuKey implements Serializable {
    private String tRoleId;

    private String tMenuId;

    private static final long serialVersionUID = 1L;

    public String gettRoleId() {
        return tRoleId;
    }

    public void settRoleId(String tRoleId) {
        this.tRoleId = tRoleId == null ? null : tRoleId.trim();
    }

    public String gettMenuId() {
        return tMenuId;
    }

    public void settMenuId(String tMenuId) {
        this.tMenuId = tMenuId == null ? null : tMenuId.trim();
    }
}