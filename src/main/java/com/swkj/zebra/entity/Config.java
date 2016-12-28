package com.swkj.zebra.entity;

import com.amaz.core.entity.IdEntity;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 客户端配置信息
 * 如果version&jarversion 一致 数据一致
 */
@Entity
@Table(name = "ph_config")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Config extends IdEntity  {
	private static final long serialVersionUID = 1L;
    private Integer version;//数据版本号
    private Integer timerDuration;//数据同步间隔
    private Integer contactReqDuration;//联系人同步间隔
    private String jarurl;//jar包下载地址
    private String jarmd5;//jar包MD5
    private String jarversion;//jar包版本号



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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Config config = (Config) o;

        if (!version.equals(config.version)) return false;
        return jarversion.equals(config.jarversion);

    }

    @Override
    public int hashCode() {
        int result = version.hashCode();
        result = 31 * result + jarversion.hashCode();
        return result;
    }
}

