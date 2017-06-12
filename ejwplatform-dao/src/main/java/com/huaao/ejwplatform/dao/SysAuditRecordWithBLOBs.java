package com.huaao.ejwplatform.dao;

import java.io.Serializable;

public class SysAuditRecordWithBLOBs extends SysAuditRecord implements Serializable {
    private String resultImgs;

    private String resultVoices;

    private String resultVideos;

    private static final long serialVersionUID = 1L;

    public String getResultImgs() {
        return resultImgs;
    }

    public void setResultImgs(String resultImgs) {
        this.resultImgs = resultImgs == null ? null : resultImgs.trim();
    }

    public String getResultVoices() {
        return resultVoices;
    }

    public void setResultVoices(String resultVoices) {
        this.resultVoices = resultVoices == null ? null : resultVoices.trim();
    }

    public String getResultVideos() {
        return resultVideos;
    }

    public void setResultVideos(String resultVideos) {
        this.resultVideos = resultVideos == null ? null : resultVideos.trim();
    }
}