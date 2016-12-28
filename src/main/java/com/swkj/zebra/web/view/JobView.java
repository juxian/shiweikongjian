package com.swkj.zebra.web.view;

import java.util.Map;

/**
 * @author: xiewanpin
 * @since:  Dec 15, 2016 2:56:47 PM
 * The class JobView
 * Description:
 */
public class JobView {
	private long id; // 任务ID
	private String type; // 任务类型
	private String wxId;
	private Map<String, Object> params; // 任务相关参数
	private String state;
	private String monitor;//群组任务监控字段
	protected String createTime;
	protected String lastModifyTime;
	private String logTime;//任务时间//TODO
	  private String extra;//备注//TODO

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getWxId() {
		return wxId;
	}

	public void setWxId(String wxId) {
		this.wxId = wxId;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMonitor() {
		return monitor;
	}

	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(String lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	
	public String getLogTime() {
		return logTime;
	}

	
	public void setLogTime(String logTime) {
		this.logTime = logTime;
	}

	
	public String getExtra() {
		return extra;
	}

	
	public void setExtra(String extra) {
		this.extra = extra;
	}

}
