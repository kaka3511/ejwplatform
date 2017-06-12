package com.huaao.ejwplatform.dao;

import java.io.Serializable;
import java.util.Date;

public class SysLogs implements Serializable {
    private String id;

    private String tClassname;

    private Date tCreatetime;

    private String tLevel;

    private String tMethodname;

    private String tMsg;

    private String tUsername;

    private String tRemoteaddr;

    private String tUri;

    private String tParams;

    private String tUserid;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String gettClassname() {
        return tClassname;
    }

    public void settClassname(String tClassname) {
        this.tClassname = tClassname == null ? null : tClassname.trim();
    }

    public Date gettCreatetime() {
        return tCreatetime;
    }

    public void settCreatetime(Date tCreatetime) {
        this.tCreatetime = tCreatetime;
    }

    public String gettLevel() {
        return tLevel;
    }

    public void settLevel(String tLevel) {
        this.tLevel = tLevel == null ? null : tLevel.trim();
    }

    public String gettMethodname() {
        return tMethodname;
    }

    public void settMethodname(String tMethodname) {
        this.tMethodname = tMethodname == null ? null : tMethodname.trim();
    }

    public String gettMsg() {
        return tMsg;
    }

    public void settMsg(String tMsg) {
        this.tMsg = tMsg == null ? null : tMsg.trim();
    }

    public String gettUsername() {
        return tUsername;
    }

    public void settUsername(String tUsername) {
        this.tUsername = tUsername == null ? null : tUsername.trim();
    }

    public String gettRemoteaddr() {
        return tRemoteaddr;
    }

    public void settRemoteaddr(String tRemoteaddr) {
        this.tRemoteaddr = tRemoteaddr == null ? null : tRemoteaddr.trim();
    }

    public String gettUri() {
        return tUri;
    }

    public void settUri(String tUri) {
        this.tUri = tUri == null ? null : tUri.trim();
    }

    public String gettParams() {
        return tParams;
    }

    public void settParams(String tParams) {
        this.tParams = tParams == null ? null : tParams.trim();
    }

    public String gettUserid() {
        return tUserid;
    }

    public void settUserid(String tUserid) {
        this.tUserid = tUserid == null ? null : tUserid.trim();
    }
}