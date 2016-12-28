package com.swkj.zebra.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

/**
 * VPN信息
 */
@Entity
@Table(name = "lo_vpn")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Vpn  {
	private Long vpnId;
	private String vpnName;
	private String vpnUser;
	private String vpnPwd;
	private String vpnServer;
	private String lat;
	private String lon;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long getVpnId() {
		return vpnId;
	}

	public void setVpnId(Long vpnId) {
		this.vpnId = vpnId;
	}

	public String getVpnName() {
		return vpnName;
	}

	public void setVpnName(String vpnName) {
		this.vpnName = vpnName;
	}

	public String getVpnUser() {
		return vpnUser;
	}

	public void setVpnUser(String vpnUser) {
		this.vpnUser = vpnUser;
	}

	public String getVpnPwd() {
		return vpnPwd;
	}

	public void setVpnPwd(String vpnPwd) {
		this.vpnPwd = vpnPwd;
	}

	public String getVpnServer() {
		return vpnServer;
	}

	public void setVpnServer(String vpnServer) {
		this.vpnServer = vpnServer;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}
}
