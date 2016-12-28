package com.swkj.zebra.entity;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;

/**
 * 机器人的微信账号
 */
@Entity
@Table(name = "ph_wechat_account")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WechatAccount extends AuditableEntity {
	private static final long serialVersionUID = 1L;
	private String wxAccount; //微信账号
    private Integer simNum;//手机卡编号
    private String wxPwd; //微信密码
    private Integer wxState;//微信状态
    private String wxPhone; //微信关联手机号
    private String wxMail; //微信邮箱账号信息
    private String wxuid; //微信内部账号
    private Integer gender; //性别，1 男， 0 女
    private String nickname; //微信昵称
    private String photourl; //头像图片地址
    private Integer logintype; //登录类型 0手机号登陆 1是QQ/email/微信号登陆
    private String lable;// 标签
    private String memo;//备注
    private Integer phoneId;//关联mobilePhone表Id
    private Date stateModifyTime;//状态更新时间
    private String qrCode;//二维码信息

    public String getWxAccount() {
        return wxAccount;
    }

    public void setWxAccount(String wxAccount) {
        this.wxAccount = wxAccount;
    }

    public Integer getSimNum() {
        return simNum;
    }

    public void setSimNum(Integer simNum) {
        this.simNum = simNum;
    }

    public String getWxPwd() {
        return wxPwd;
    }

    public void setWxPwd(String wxPwd) {
        this.wxPwd = wxPwd;
    }

    public Integer getWxState() {
        return wxState;
    }

    public void setWxState(Integer wxState) {
        this.wxState = wxState;
    }

    public String getWxPhone() {
        return wxPhone;
    }

    public void setWxPhone(String wxPhone) {
        this.wxPhone = wxPhone;
    }

    public String getWxMail() {
        return wxMail;
    }

    public void setWxMail(String wxMail) {
        this.wxMail = wxMail;
    }

    public String getWxuid() {
        return wxuid;
    }

    public void setWxuid(String wxuid) {
        this.wxuid = wxuid;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhotourl() {
        return photourl;
    }

    public void setPhotourl(String photourl) {
        this.photourl = photourl;
    }

    public Integer getLogintype() {
        return logintype;
    }

    public void setLogintype(Integer logintype) {
        this.logintype = logintype;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Integer getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Integer phoneId) {
        this.phoneId = phoneId;
    }

    public Date getStateModifyTime() {
        return stateModifyTime;
    }

    public void setStateModifyTime(Date stateModifyTime) {
        this.stateModifyTime = stateModifyTime;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }
}
