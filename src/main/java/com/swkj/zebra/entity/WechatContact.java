package com.swkj.zebra.entity;

import com.amaz.core.entity.IdEntity;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

/**
 * 微信联系人
 */
@Entity
@Table(name = "ph_wechat_contact")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class WechatContact extends IdEntity {
	private static final long serialVersionUID = 1L;
	private Integer wxId; //机器人微信Id
    private String wxuid;//主微信账号 //TODO 无效
    private String wxContactUid;//微信联系人uid 微信唯一ID
    private String nickname;//好友昵称
    private String alias;//别名
    private Integer gender;//性别
    private String area;//地区
    private String conremark;//备注
    private Integer type;//联系人类型() 1.暂时代表账号本身 2.公众号 3:好友，4:群成员 7好友是群里的
    private String signature;//签名
    private String snsTimeline;//是否能看朋友圈
    private Integer lhMark;//拉黑标志1拉黑0未拉黑
    private String addTime;//添加时间
    private String zkm;//转客码
    private String shifuZkm;//师傅转客码
    private Integer internal;//标记此好友是否内部号(0:外部 1:内部)
    private Integer status;//状态 0：不可用   1：可用
    private String updateTime;//最后更新时间
    private String verifyContent;//内部人员打招呼暗号
    private Integer isPull;//是否已拉过好友进群
    private Date onlineTime;//最近会话时间
    private Date messageTime;//发消息时间

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        WechatContact that = (WechatContact) object;

        if (!wxId.equals(that.wxId)) return false;
        if (!wxContactUid.equals(that.wxContactUid)) return false;
        return type.equals(that.type);

    }

    @Override
    public int hashCode() {
        int result = wxId.hashCode();
        result = 31 * result + wxContactUid.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }

    //非表中字段
    private Integer totalNum;//好友数据量
    private WechatAccount wechatAccount;//微信对象

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getInternal() {
        return internal;
    }

    public void setInternal(Integer internal) {
        this.internal = internal;
    }

    public String getWxuid() {
        return wxuid;
    }

    public void setWxuid(String wxuid) {
        this.wxuid = wxuid;
    }

    public String getWxContactUid() {
        return wxContactUid;
    }

    public void setWxContactUid(String wxContactUid) {
        this.wxContactUid = wxContactUid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getConremark() {
        return conremark;
    }

    public void setConremark(String conremark) {
        this.conremark = conremark;
    }

    public Integer getLhMark() {
        return lhMark;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getSnsTimeline() {
        return snsTimeline;
    }

    public void setSnsTimeline(String snsTimeline) {
        this.snsTimeline = snsTimeline;
    }

    public void setLhMark(Integer lhMark) {
        this.lhMark = lhMark;
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

    public String getZkm() {
        return zkm;
    }

    public void setZkm(String zkm) {
        this.zkm = zkm;
    }

    public String getShifuZkm() {
        return shifuZkm;
    }

    public void setShifuZkm(String shifuZkm) {
        this.shifuZkm = shifuZkm;
    }

    public Integer getWxId() {
        return wxId;
    }

    public void setWxId(Integer wxId) {
        this.wxId = wxId;
    }

    public String getVerifyContent() {
        return verifyContent;
    }

    public void setVerifyContent(String verifyContent) {
        this.verifyContent = verifyContent;
    }

    public Integer getIsPull() {
        return isPull;
    }

    public void setIsPull(Integer isPull) {
        this.isPull = isPull;
    }

    public Date getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(Date onlineTime) {
        this.onlineTime = onlineTime;
    }

    public Date getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Date messageTime) {
        this.messageTime = messageTime;
    }

    @Transient
    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    @Transient
    public WechatAccount getWechatAccount() {
        return wechatAccount;
    }

    public void setWechatAccount(WechatAccount wechatAccount) {
        this.wechatAccount = wechatAccount;
    }

}
