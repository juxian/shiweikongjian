package com.swkj.zebra.web.view;

/**
 * Created by Administrator on 2016/11/26.
 */

public class ChatroomInfoView {
    private String chatRoomName;
    private String memberList;
    private String roomOwner;

    public String getChatRoomName() {
        return chatRoomName;
    }

    public void setChatRoomName(String chatRoomName) {
        this.chatRoomName = chatRoomName;
    }

    public String getMemberList() {
        return memberList;
    }

    public void setMemberList(String memberList) {
        this.memberList = memberList;
    }

    public String getRoomOwner() {
        return roomOwner;
    }

    public void setRoomOwner(String roomOwner) {
        this.roomOwner = roomOwner;
    }
}
