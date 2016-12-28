package com.swkj.zebra.web.view;

import java.util.HashMap;

/**
 * @author: xiewanpin
 * @since:  Dec 9, 2016 6:24:37 PM
 * The class CofView
 * Description: 发朋友圈
 */
public class CofView {

	private String photoUrl;

	private String message;

	private HashMap<String, Object> params = new HashMap<String, Object>(); // 任务相关参数

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HashMap<String, Object> getParams() {
		return params;
	}

	public void setParams(HashMap<String, Object> params) {
		this.params = params;
	}

}
