package com.swkj.zebra.web.view;

/**
 * @author: xiewanpin
 * @since:  Dec 13, 2016 6:14:45 PM
 * The class RequestParam
 * Description: 请求数据公共部分参数接受
 */
public class RequestParam {

	private String mn;//手机编号

	private String wi;//微信账号ID

	private String cv;//程序版本号

	private String vi;//VPN ID

	private String jv;//客户端Jar 版本

	private String kr;//是否ROOT

	private String hk;// 是否有钩子

	
	public String getMn() {
		return mn;
	}

	
	public void setMn(String mn) {
		this.mn = mn;
	}

	
	public String getWi() {
		return wi;
	}

	
	public void setWi(String wi) {
		this.wi = wi;
	}

	
	public String getCv() {
		return cv;
	}

	
	public void setCv(String cv) {
		this.cv = cv;
	}

	
	public String getVi() {
		return vi;
	}

	
	public void setVi(String vi) {
		this.vi = vi;
	}

	
	public String getJv() {
		return jv;
	}

	
	public void setJv(String jv) {
		this.jv = jv;
	}

	
	public String getKr() {
		return kr;
	}

	
	public void setKr(String kr) {
		this.kr = kr;
	}

	
	public String getHk() {
		return hk;
	}

	
	public void setHk(String hk) {
		this.hk = hk;
	}

}
