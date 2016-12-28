package com.swkj.zebra.web.view;

/**
 * Created by sunbaoliang on 2016/12/13 0013.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 联系人上传接口，客户端参数接收类
 */
public class ContactsBody {
    private WechatAccountView wechatAccount;
    private UserInfoView userInfo;
    private List<WechatContactView> wechatContacts = new ArrayList<>();

    public WechatAccountView getWechatAccount() {
        return wechatAccount;
    }

    public void setWechatAccount(WechatAccountView wechatAccount) {
        this.wechatAccount = wechatAccount;
    }

    public UserInfoView getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoView userInfo) {
        this.userInfo = userInfo;
    }

    public List<WechatContactView> getWechatContacts() {
        return wechatContacts;
    }

    public void setWechatContacts(List<WechatContactView> wechatContacts) {
        this.wechatContacts = wechatContacts;
    }
}
