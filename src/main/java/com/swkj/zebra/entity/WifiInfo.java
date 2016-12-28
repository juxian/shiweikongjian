package com.swkj.zebra.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * WIFI信息
 */
@Entity
@Table(name = "lo_wifi")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class WifiInfo extends AuditableEntity {
	private static final long serialVersionUID = 1L;

    private Long gpsId;
    private String mac;//MAC
    private Integer acc;//

    public void setGpsId(Long gpsId) {
        this.gpsId = gpsId;
    }

    public Long getGpsId() {
        return gpsId;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public Integer getAcc() {
        return acc;
    }

    public void setAcc(Integer acc) {
        this.acc = acc;
    }
}
