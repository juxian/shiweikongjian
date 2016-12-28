package com.swkj.zebra.web.view;

/**
 * Created by Administrator on 2016/9/2 0002.
 */
public class MobilePhoneView {
    private String mac;//MAC地址
    private String localIp;//本地IP
    private Integer androidVersion;// 安卓系统版本
    private String iccId;//Sim卡的串号
    private String imei;// 手机串号
    private String imsi;//Sim卡中的移动用户识别码
    private Integer machineNumber;//手机编号
    private String phoneBrand;//手机厂商
    private String phoneModel;//手机型号
    private Integer versionNumber;//当前程序版本
    private String wechatVersion;//微信版本

    public Integer getAndroidVersion() {
        return androidVersion;
    }

    public void setAndroidVersion(Integer androidVersion) {
        this.androidVersion = androidVersion;
    }

    public String getIccId() {
        return iccId;
    }

    public void setIccId(String iccId) {
        this.iccId = iccId;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getLocalIp() {
        return localIp;
    }

    public void setLocalIp(String localIp) {
        this.localIp = localIp;
    }

    public Integer getMachineNumber() {
        return machineNumber;
    }

    public void setMachineNumber(Integer machineNumber) {
        this.machineNumber = machineNumber;
    }

    public String getPhoneBrand() {
        return phoneBrand;
    }

    public void setPhoneBrand(String phoneBrand) {
        this.phoneBrand = phoneBrand;
    }

    public String getPhoneModel() {
        return phoneModel;
    }

    public void setPhoneModel(String phoneModel) {
        this.phoneModel = phoneModel;
    }

    public Integer getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(Integer versionNumber) {
        this.versionNumber = versionNumber;
    }

    public String getWechatVersion() {
        return wechatVersion;
    }

    public void setWechatVersion(String wechatVersion) {
        this.wechatVersion = wechatVersion;
    }
}
