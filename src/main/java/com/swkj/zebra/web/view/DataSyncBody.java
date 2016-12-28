package com.swkj.zebra.web.view;

/**
 * Created by sunbaoliang on 2016/12/13 0013.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 数据同步接口，客户端参数接收类
 */
public class DataSyncBody {
    private MobilePhoneView mobilePhone;
    private List<JobLogView> jobLogs = new ArrayList<>();
    private List<FriendMessageView> friendMessages  = new ArrayList<>();
    private List<ChatroomInfoView> chatRoomInfos = new ArrayList<>();

    public MobilePhoneView getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(MobilePhoneView mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public List<JobLogView> getJobLogs() {
        return jobLogs;
    }

    public void setJobLogs(List<JobLogView> jobLogs) {
        this.jobLogs = jobLogs;
    }

    public List<FriendMessageView> getFriendMessages() {
        return friendMessages;
    }

    public void setFriendMessages(List<FriendMessageView> friendMessages) {
        this.friendMessages = friendMessages;
    }

    public List<ChatroomInfoView> getChatRoomInfos() {
        return chatRoomInfos;
    }

    public void setChatRoomInfos(List<ChatroomInfoView> chatRoomInfos) {
        this.chatRoomInfos = chatRoomInfos;
    }
}
