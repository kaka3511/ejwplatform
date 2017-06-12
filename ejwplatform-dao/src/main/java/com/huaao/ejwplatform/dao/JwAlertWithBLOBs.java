package com.huaao.ejwplatform.dao;

import java.io.Serializable;

public class JwAlertWithBLOBs extends JwAlert implements Serializable {
    private String imgs;

    private String voices;

    private String videos;

    private static final long serialVersionUID = 1L;

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs == null ? null : imgs.trim();
    }

    public String getVoices() {
        return voices;
    }

    public void setVoices(String voices) {
        this.voices = voices == null ? null : voices.trim();
    }

    public String getVideos() {
        return videos;
    }

    public void setVideos(String videos) {
        this.videos = videos == null ? null : videos.trim();
    }
}