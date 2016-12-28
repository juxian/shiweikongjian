package com.swkj.zebra.entity;

import com.amaz.core.entity.IdEntity;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Created by Administrator on 2016/8/24 0024.
 */
@Entity
@Table(name = "j_job")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Job extends AuditableEntity {
	private static final long serialVersionUID = 1L;
	private Integer type; //手机ID
	private Integer wxId; //微信ID
	private String params; //微信联系人ID
	private Integer state;
	private Integer monitor = 0;//群组任务监控字段

	public Integer getType() {
		return type;
	}
	
	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getWxId() {
		return wxId;
	}

	public void setWxId(Integer wxId) {
		this.wxId = wxId;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getMonitor() {
		return monitor;
	}

	public void setMonitor(Integer monitor) {
		this.monitor = monitor;
	}
}
