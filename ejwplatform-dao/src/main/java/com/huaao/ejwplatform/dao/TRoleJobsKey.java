package com.huaao.ejwplatform.dao;

import java.io.Serializable;

public class TRoleJobsKey implements Serializable {
    private String tRoleId;

    private String tJobsId;

    private static final long serialVersionUID = 1L;

    public String gettRoleId() {
        return tRoleId;
    }

    public void settRoleId(String tRoleId) {
        this.tRoleId = tRoleId == null ? null : tRoleId.trim();
    }

    public String gettJobsId() {
        return tJobsId;
    }

    public void settJobsId(String tJobsId) {
        this.tJobsId = tJobsId == null ? null : tJobsId.trim();
    }
}