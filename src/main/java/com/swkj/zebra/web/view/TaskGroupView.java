package com.swkj.zebra.web.view;

import java.io.Serializable;

/**
 * @author: xiewanpin
 * @since:  Dec 27, 2016 11:40:13 AM
 * The class TaskGroupView
 * Description: vo 
 */
public class TaskGroupView implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String nameString;

	private Integer styleInteger;

	private String startTime;

	private String CreateTime;

	private String statusString;

	private String sendTime;

	private String taskString;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNameString() {
		return nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	public Integer getStyleInteger() {
		return styleInteger;
	}

	public void setStyleInteger(Integer styleInteger) {
		this.styleInteger = styleInteger;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}

	public String getStatusString() {
		return statusString;
	}

	public void setStatusString(String statusString) {
		this.statusString = statusString;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getTaskString() {
		return taskString;
	}

	public void setTaskString(String taskString) {
		this.taskString = taskString;
	}

}
