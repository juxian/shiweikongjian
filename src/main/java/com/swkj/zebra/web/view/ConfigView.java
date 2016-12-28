package com.swkj.zebra.web.view;

/**
 * Created by Administrator on 2016/9/2 0002.
 */
public class ConfigView {
    private Integer version;
    private Integer timerDuration;
    private Integer contactReqDuration;
    private String jarurl;
    private String jarmd5;
    private String jarversion;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getTimerDuration() {
        return timerDuration;
    }

    public void setTimerDuration(Integer timerDuration) {
        this.timerDuration = timerDuration;
    }

    public Integer getContactReqDuration() {
        return contactReqDuration;
    }

    public void setContactReqDuration(Integer contactReqDuration) {
        this.contactReqDuration = contactReqDuration;
    }

    public String getJarurl() {
        return jarurl;
    }

    public void setJarurl(String jarurl) {
        this.jarurl = jarurl;
    }

    public String getJarmd5() {
        return jarmd5;
    }

    public void setJarmd5(String jarmd5) {
        this.jarmd5 = jarmd5;
    }

    public String getJarversion() {
        return jarversion;
    }

    public void setJarversion(String jarversion) {
        this.jarversion = jarversion;
    }
}
