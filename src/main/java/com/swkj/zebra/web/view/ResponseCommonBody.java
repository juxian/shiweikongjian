package com.swkj.zebra.web.view;

import java.util.List;

public class ResponseCommonBody{

    private ConfigView config;
    private WechatAccountView wechatAccount;
    private PhoneEnvView phoneEnv;
    private VpnInfoView vpnInfo;
    private FakeLocationView fakeLocation;
    private List<JobView> jobs;

    public ConfigView getConfig() {
        return config;
    }

    public void setConfig(ConfigView config) {
        this.config = config;
    }

    public WechatAccountView getWechatAccount() {
        return wechatAccount;
    }

    public void setWechatAccount(WechatAccountView wechatAccount) {
        this.wechatAccount = wechatAccount;
    }

    public PhoneEnvView getPhoneEnv() {
        return phoneEnv;
    }

    public void setPhoneEnv(PhoneEnvView phoneEnv) {
        this.phoneEnv = phoneEnv;
    }

    public VpnInfoView getVpnInfo() {
        return vpnInfo;
    }

    public void setVpnInfo(VpnInfoView vpnInfo) {
        this.vpnInfo = vpnInfo;
    }

    public FakeLocationView getFakeLocation() {
        return fakeLocation;
    }

    public void setFakeLocation(FakeLocationView fakeLocation) {
        this.fakeLocation = fakeLocation;
    }

    public List<JobView> getJobs() {
        return jobs;
    }

    public void setJobs(List<JobView> jobs) {
        this.jobs = jobs;
    }

}
