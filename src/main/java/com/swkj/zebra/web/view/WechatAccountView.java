package com.swkj.zebra.web.view;

/**
 * Created by Administrator on 2016/9/2 0002.
 */
public class WechatAccountView {
    private long wxId;
    private Integer id;// 顺序号
    private String accountName;//微信账号
    private Integer loginType;//登录类型, 0手机号登录， 1账号登录
    private String password;//微信密码
    private String phone;//微信号绑定的手机号

    public long getWxId() {
        return wxId;
    }

    public void setWxId(long wxId) {
        this.wxId = wxId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLoginType() {
        return loginType;
    }

    public void setLoginType(Integer loginType) {
        this.loginType = loginType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
