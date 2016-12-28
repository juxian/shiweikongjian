package com.swkj.zebra.web.view;

/**
 * Created by Administrator on 2016/9/2 0002.
 */
public class WechatContactView {
    private String userName;//微信账号
    private Integer type;//联系人
    private String conRemark;//
    private String alias;//别名
    private String nickName;//昵称
    private Integer internal;//内部好友

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getConRemark() {
        return conRemark;
    }

    public void setConRemark(String conRemark) {
        this.conRemark = conRemark;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Integer getInternal() {
        return internal;
    }

    public void setInternal(Integer internal) {
        this.internal = internal;
    }
}
