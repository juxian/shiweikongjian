package com.swkj.zebra.entity;

import com.amaz.core.entity.IdEntity;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 基站
 */
@Entity
@Table(name = "lo_cell")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class CellInfo extends IdEntity {
	private static final long serialVersionUID = 1L;
    private Long gpsId;//gps表关联Id
    private Integer mnc;
    private Integer lac;
    private Integer ci;
    private Integer acc;

    public Long getGpsId() {
        return gpsId;
    }

    public void setGpsId(Long gpsId) {
        this.gpsId = gpsId;
    }

    public Integer getMnc() {
        return mnc;
    }

    public void setMnc(Integer mnc) {
        this.mnc = mnc;
    }

    public Integer getLac() {
        return lac;
    }

    public void setLac(Integer lac) {
        this.lac = lac;
    }

    public Integer getCi() {
        return ci;
    }

    public void setCi(Integer ci) {
        this.ci = ci;
    }

    public Integer getAcc() {
        return acc;
    }

    public void setAcc(Integer acc) {
        this.acc = acc;
    }
}
