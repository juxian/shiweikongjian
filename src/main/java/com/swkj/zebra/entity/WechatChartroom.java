package com.swkj.zebra.entity;

import com.amaz.core.entity.IdEntity;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 群信息
 */
@Entity
@Table(name = "wx_wechat_chartroom")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class WechatChartroom extends AuditableEntity {
    private Long wxId;//微信Id
    private String chartroomName;//群组名称
    private String chartroomMember;//群组成员

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
}
