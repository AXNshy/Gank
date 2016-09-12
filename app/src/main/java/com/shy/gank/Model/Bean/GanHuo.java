package com.shy.gank.Model.Bean;

import java.io.Serializable;

/**
 * Created by axnshy on 16/8/28.
 */
public class GanHuo implements Serializable{
     String desc;
     String ganhuo_id;
     String publishedAt;
     String readability;
     String type;
     String url;
     String source;
     boolean used;
     String who;

    public GanHuo(String desc, String ganhuo_id, String publishedAt, String readability, String type, String url, String source, boolean used, String who) {
        this.desc = desc;
        this.ganhuo_id = ganhuo_id;
        this.publishedAt = publishedAt;
        this.readability = readability;
        this.type = type;
        this.url = url;
        this.source = source;
        this.used = used;
        this.who = who;
    }

    @Override
    public String toString() {
        return "GanHuo{" +
                "desc='" + desc + '\'' +
                ", ganhuo_id='" + ganhuo_id + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", readability='" + readability + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", source='" + source + '\'' +
                ", used=" + used +
                ", who='" + who + '\'' +
                '}';
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setGanhuo_id(String ganhuo_id) {
        this.ganhuo_id = ganhuo_id;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public void setReadability(String readability) {
        this.readability = readability;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public String getDesc() {
        return desc;
    }

    public String getGanhuo_id() {
        return ganhuo_id;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getReadability() {
        return readability;
    }

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    public String getSource() {
        return source;
    }

    public boolean isUsed() {
        return used;
    }

    public String getWho() {
        return who;
    }
}
