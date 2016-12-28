package com.swkj.zebra.entity;

import com.amaz.core.entity.IdEntity;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator on 2016/10/26 0026.
 */
@Entity
@Table(name = "lo_vpn_gps")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class VpnGps extends IdEntity {
	private static final long serialVersionUID = 1L;
	private Long vpnId;
    private Integer hasWifi;
    private Integer hasBase;

    public Long getVpnId() {
        return vpnId;
    }

    public void setVpnId(Long vpnId) {
        this.vpnId = vpnId;
    }

    public Integer getHasWifi() {
        return hasWifi;
    }

    public void setHasWifi(Integer hasWifi) {
        this.hasWifi = hasWifi;
    }

    public Integer getHasBase() {
        return hasBase;
    }

    public void setHasBase(Integer hasBase) {
        this.hasBase = hasBase;
    }
}
