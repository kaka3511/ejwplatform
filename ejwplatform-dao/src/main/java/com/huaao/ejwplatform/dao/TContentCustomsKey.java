package com.huaao.ejwplatform.dao;

import java.io.Serializable;

public class TContentCustomsKey implements Serializable {
    private String contentId;

    private String tKey;

    private static final long serialVersionUID = 1L;

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId == null ? null : contentId.trim();
    }

    public String gettKey() {
        return tKey;
    }

    public void settKey(String tKey) {
        this.tKey = tKey == null ? null : tKey.trim();
    }
}