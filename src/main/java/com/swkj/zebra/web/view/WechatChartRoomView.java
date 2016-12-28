package com.swkj.zebra.web.view;

public class WechatChartRoomView {

	private Long wxId;//微信Id
	private String chartroomName;//群组名称
	private String chartroomMember;//群组成员
	private String addTime;//添加时间
	private String updateTime;//更新时间
	private Integer state;//状态

	public Long getWxId() {
		return wxId;
	}

	public void setWxId(Long wxId) {
		this.wxId = wxId;
	}

	public String getChartroomName() {
		return chartroomName;
	}

	public void setChartroomName(String chartroomName) {
		this.chartroomName = chartroomName;
	}

	public String getChartroomMember() {
		return chartroomMember;
	}

	public void setChartroomMember(String chartroomMember) {
		this.chartroomMember = chartroomMember;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}
