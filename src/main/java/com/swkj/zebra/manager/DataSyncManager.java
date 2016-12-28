package com.swkj.zebra.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.amaz.core.common.DateUtils;
import com.amaz.core.common.StringUtils;
import com.swkj.zebra.common.Constants;
import com.swkj.zebra.common.StaticParamConstants.JobStateDic;
import com.swkj.zebra.common.StaticParamConstants.WechatStateDic;
import com.swkj.zebra.common.StaticParamConstants.WechatStateParams;
import com.swkj.zebra.entity.CellInfo;
import com.swkj.zebra.entity.Config;
import com.swkj.zebra.entity.Job;
import com.swkj.zebra.entity.MobilePhone;
import com.swkj.zebra.entity.Vpn;
import com.swkj.zebra.entity.WechatAccount;
import com.swkj.zebra.entity.WechatChartroom;
import com.swkj.zebra.entity.WechatContact;
import com.swkj.zebra.entity.WifiInfo;
import com.swkj.zebra.service.CellInfoService;
import com.swkj.zebra.service.ConfigService;
import com.swkj.zebra.service.JobService;
import com.swkj.zebra.service.MobilePhoneService;
import com.swkj.zebra.service.PhoneEnvService;
import com.swkj.zebra.service.VpnGpsService;
import com.swkj.zebra.service.VpnInfoService;
import com.swkj.zebra.service.WechatAccountService;
import com.swkj.zebra.service.WechatChartroomService;
import com.swkj.zebra.service.WechatContactService;
import com.swkj.zebra.service.WifiInfoService;
import com.swkj.zebra.util.CharacterFilter;
import com.swkj.zebra.util.IpUtils;
import com.swkj.zebra.web.view.ChatroomInfoView;
import com.swkj.zebra.web.view.ConfigView;
import com.swkj.zebra.web.view.DataSyncBody;
import com.swkj.zebra.web.view.FakeLocationView;
import com.swkj.zebra.web.view.FriendMessageView;
import com.swkj.zebra.web.view.JobLogView;
import com.swkj.zebra.web.view.JobView;
import com.swkj.zebra.web.view.MobilePhoneView;
import com.swkj.zebra.web.view.PhoneEnvView;
import com.swkj.zebra.web.view.RequestParam;
import com.swkj.zebra.web.view.ResponseCommonBody;
import com.swkj.zebra.web.view.VpnInfoView;
import com.swkj.zebra.web.view.WechatAccountView;

/**
 * @author: xiewanpin
 * @since:  Dec 13, 2016 5:03:37 PM
 * The class DataSyncManager
 * Description: 数据同步Manager
 */
@Named
public class DataSyncManager {

	@Inject
	private MobilePhoneService mobilePhoneService;
	@Inject
	private ConfigService configService;
	@Inject
	private PhoneEnvService phoneEnvService;
	@Inject
	private JobService jobService;
	@Inject
	private WechatAccountService wechatAccountService;
	@Inject
	private VpnInfoService vpnInfoService;
	@Inject
	private WechatChartroomService wechatChartroomService;
	@Inject
	private WechatContactService wechatContactsService;
	@Inject
	private VpnGpsService vpnGpsService;
	@Inject
	private CellInfoService cellInfoService;
	@Inject
	private WifiInfoService wifiInfoService;

	/**
	 * 名称：handleDataSync ;描述：数据同步业务入口
	 */
	public String handleDataSync(DataSyncBody dataSyncBody, HttpServletRequest request, RequestParam requestParam, MobilePhone mobilePhone, String tag) {
		/**核心数据处理**/
		this.handleCore(dataSyncBody, requestParam, mobilePhone, tag);
		/**保存手机信息**/
		this.saveMobilePhone(dataSyncBody, request, mobilePhone, requestParam);
		/** 响应处理**/
		return this.getResponseCommon(requestParam, mobilePhone, tag);
	}

	private final void handleCore(DataSyncBody dataSyncBody, RequestParam requestParam, MobilePhone mobilePhone, String tag) {
		/**以JobLogView接受，不涉及具体业务类型**/
		if (dataSyncBody != null) {
			/**好友验证处理**/
			this.verifyFriendMessages(dataSyncBody, requestParam);
			/**获取客户端job处理信息**/
			List<JobLogView> jobLogs = dataSyncBody.getJobLogs();
			for (JobLogView jobLog : jobLogs) {
				if (jobLog.getJobType().intValue() == Constants.LINEVPN.intValue()) {//过滤掉链接vpn错误
					continue;
				}

				if (jobLog.getJobType() != null && jobLog.getState() != null) {
					/**联系人好友处理**/
					this.saveContacts(jobLog, requestParam.getWi());//Wi微信账号ID
					/**登录账号处理**/
					this.verifyLogin(jobLog);
					/**job更新**/
					this.updateJog(jobLog, requestParam.getWi());
				}
			}
			/**群处理**/
			this.saveWechatChartroom(dataSyncBody, requestParam);
		}

	}

	/**
	 * 名称：saveWechatChartroom ;描述：建群
	 */
	private void saveWechatChartroom(DataSyncBody dataSyncBody, RequestParam requestParam) {
		List<ChatroomInfoView> paramsChatRoomInfos = dataSyncBody.getChatRoomInfos();//客户端发来信息
		if (requestParam.getWi() == null) {
			return;
		}

		Long wxId = Long.valueOf(requestParam.getWi());//机器人账号id
		for (ChatroomInfoView paramsChatRoomInfo : paramsChatRoomInfos) {
			String chartroomName = paramsChatRoomInfo.getChatRoomName();
			if (StringUtils.isEmpty(chartroomName) || requestParam.getWi() == null) {
				continue;
			}
			List<WechatChartroom> wechatChartrooms = new ArrayList<WechatChartroom>();
			//分割群成员
			String[] memberList = paramsChatRoomInfo.getMemberList().split(";");
			for (int i = 0; i < memberList.length; i++) {
				String chartroomMember = memberList[i];
				WechatChartroom wechatChartroom = new WechatChartroom();
				wechatChartroom.setWxId(wxId);
				wechatChartroom.setChartroomName(chartroomName);
				wechatChartroom.setChartroomMember(chartroomMember);
				wechatChartroom.setCreateTime(new Date());
				wechatChartroom.setLastModifyTime(new Date());
				wechatChartrooms.add(wechatChartroom);
			}
			this.wechatChartroomService.saveOnDuplicate(wxId, chartroomName, wechatChartrooms);
		}

	}
	
/**
 * 名称：verifyFriendMessages ;描述：好友验证
 */
	private void verifyFriendMessages(DataSyncBody dataSyncBody, RequestParam requestParam) {
		List<FriendMessageView> friendMessages = dataSyncBody.getFriendMessages();//获取客户端好友信息
		if (friendMessages == null || StringUtils.isEmpty(requestParam.getWi())) {
			return;
		}
		/**根据客户端请求数据进行好友验证处理**/
		List<WechatContact> wechatContactses = new ArrayList<WechatContact>();
		Integer wxId = Integer.parseInt(requestParam.getWi());
		for (FriendMessageView paramsFriendMessage : friendMessages) {
			WechatContact wechatContact = new WechatContact();
			/**由客户端好友请求数据中获得获得对应的好友数据（联系人数据）**/
			String contentFromUsername = paramsFriendMessage.getContentFromUsername();//获取微信账号uid身份标识
			String verifyContent = paramsFriendMessage.getContentVerifyContent();
			wechatContact.setWxId(wxId);//机器人id
			wechatContact.setType(3);
			wechatContact.setWxContactUid(contentFromUsername);//好友即联系人的uid
			wechatContact.setVerifyContent(CharacterFilter.filterEmoji(verifyContent));
			wechatContact.setAddTime(DateUtils.getTime());
			wechatContact.setUpdateTime(DateUtils.getTime());
			wechatContact.setStatus(1);
			wechatContact.setInternal(0);
			wechatContactses.add(wechatContact);
		}
		/**入库**/
		this.wechatContactsService.saveOnDuplicateValidate(wechatContactses);
	}

	private final void saveContacts(JobLogView JobLog, String wxId) {
		String wxContactUid = JobLog.getExtra();
		if (StringUtils.isEmpty(wxId) || wxContactUid == null) {
			return;
		}
		/**接受好友处理**/
		if (JobLog.getJobType() == Constants.ACCEPTREQUEST && JobLog.getState() == JobStateDic.SUCCESS) {
			List<WechatContact> wechatContactses = new ArrayList<WechatContact>();
			WechatContact wechatContact = new WechatContact();
			wechatContact.setWxId(Integer.parseInt(wxId));
			wechatContact.setAddTime(DateUtils.getTime());
			wechatContact.setUpdateTime(DateUtils.getTime());
			wechatContact.setWxContactUid(wxContactUid);
			wechatContact.setNickname("新的朋友"); //默认昵称
			wechatContact.setType(3); //默认联系人类型(普通好友)
			wechatContact.setInternal(0); //默认外部好友
			wechatContact.setStatus(1); //默认状态，可用
			wechatContactses.add(wechatContact);
			/**入库**/
			wechatContactsService.saveOnDuplicateValidate(wechatContactses);
		}

	}

	private final void verifyLogin(JobLogView JobLog) {
		String memo = JobLog.getExtra();//备注
		Long wxId = Long.valueOf(JobLog.getJobId());//登陆操作jobId为wxId
		Integer wxState = -1;
		/**备注验证**/
		if (memo != null) {
			/**状态判断**/
			if (JobLog.getJobType() != Constants.LOGIN) { //未登录
				return;
			}
			if (JobLog.getState() == JobStateDic.SUCCESS) { //登陆成功
				wxState = WechatStateDic.TWO;
			} else if (JobLog.getState() == JobStateDic.TWO) {//登陆失败
				Integer errorState = WechatStateParams.getWeixinErrId(JobLog.getExtra());
				if (errorState == 0) {
					errorState = WechatStateDic.TWO;
				}
				wxState = errorState;
			}
			if (wxState != -1) {
				/**入库**/
				this.wechatAccountService.updateWechatAccountByWxId(wxId, wxState, memo);
			}
		}

	}

	private final void updateJog(JobLogView JobLog, String wi) {
		/**数据组装**/
		Long jobId = Long.valueOf(JobLog.getJobId());//获取要处理的任务主键
		Integer jobState = JobLog.getState();//取得任务执行的状态
		/**入库**/
		this.jobService.updateJog(jobId, jobState);
	}

	private final void saveMobilePhone(DataSyncBody dataSyncBody, HttpServletRequest request, MobilePhone mobilePhone, RequestParam requestParam) {//所有数据同步客户端信息都是向库插入数据
		/**公共请求参数：root、钩子、客户端ip和vpn_ip是否一致信息**/
		String ip = IpUtils.getIpAddr(request);
		mobilePhone.setClientIp(ip);
		mobilePhone.setLastTime(DateUtils.getTime());
		mobilePhone.setIsRoot(requestParam.getKr() == null ? 0 : 1);
		mobilePhone.setIsHook(requestParam.getHk() == null ? 0 : 1);
		@SuppressWarnings("unused")
		Vpn vpnInfo = vpnInfoService.getByVpnId(mobilePhone.getVpnId());//获取手机的vpn信息
		/***获取手机配置信息***/
		MobilePhoneView paramsMobilePhone = dataSyncBody.getMobilePhone();
		/** 组装手机数据**/
		if (paramsMobilePhone != null) {
			mobilePhone.setMac(paramsMobilePhone.getMac());
			mobilePhone.setLocalIp(paramsMobilePhone.getLocalIp());
			mobilePhone.setImei(paramsMobilePhone.getImei());
			mobilePhone.setImsi(paramsMobilePhone.getImsi());
			mobilePhone.setPhoneBrand(paramsMobilePhone.getPhoneBrand());
			mobilePhone.setPhoneModel(paramsMobilePhone.getPhoneModel());
			mobilePhone.setAndroidVer(paramsMobilePhone.getAndroidVersion().toString());
			mobilePhone.setPhoneStatus(1);//手机默认状态
		}
		/**入库**/
		this.mobilePhoneService.save(mobilePhone);

	}

	/**
	 * 名称：getResponseCommon ;描述：组装返回数据
	 */
	private final String getResponseCommon(RequestParam param, MobilePhone mobilePhone, String tag) {
		ResponseCommonBody responseCommonBody = new ResponseCommonBody();
		PhoneEnvView phoneEnv = null;// 手机环境信息
		FakeLocationView fakeLocationView = null;//基站信息
		VpnInfoView vpnInfoView = null;//vpn 信息
		/**获取微信账号信息   **/
		WechatAccountView wechatAccount = getParamsWechatAccount(param.getWi(), mobilePhone);
		/**获取手机环境信息   **/
		phoneEnv = phoneEnvService.getByWxId(mobilePhone.getWxId().longValue());
		/**获取手机vpn信息   **/
		Vpn vpn = vpnInfoService.getByVpnId(mobilePhone.getVpnId());
		/**获取基站信息**/
		if (wechatAccount != null && mobilePhone.getWxId() != null) {
			if (vpn != null) fakeLocationView = this.getParamsFakeLocation(vpn);
		}
		if (param.getVi() != null && vpn != null) {
			vpnInfoView = getParamsVpnInfo(vpn);
		}
		/**获取配置信息**/
		ConfigView configView = getConfig(param.getCv(), param.getJv());
		/**获取指定時間的job任務**/
		List<JobView> Jobs = getJobs(mobilePhone);
		/**数据组装***/
		if (configView != null) {
			responseCommonBody.setConfig(configView);
		}
		if (wechatAccount != null) {
			responseCommonBody.setWechatAccount(wechatAccount);
		}
		if (Jobs.size() > 0 && !tag.equals("contacts")) {
			responseCommonBody.setJobs(Jobs);
		}
		if (phoneEnv != null) {
			responseCommonBody.setPhoneEnv(phoneEnv);
		}
		if (fakeLocationView != null) {
			responseCommonBody.setFakeLocation(fakeLocationView);
		}
		if (vpnInfoView != null) {
			responseCommonBody.setVpnInfo(vpnInfoView);
		}
		return JSON.toJSONString(responseCommonBody);

	}

	private FakeLocationView getParamsFakeLocation(Vpn vpn) {
		FakeLocationView ParamsFakeLocation = null;
		Integer gpsId = vpnGpsService.getRandomIdByVpnId(vpn.getVpnId());
		if (gpsId != null) {
			List<CellInfo> cellInfoList = entitiesToParamsCellInfo(cellInfoService.findByGpsId(gpsId));
			List<WifiInfo> wifiInfoList = entitiesToParamsWifiInfo(wifiInfoService.findByGpsId(gpsId));
			ParamsFakeLocation = new FakeLocationView();
			ParamsFakeLocation.setLat(Double.valueOf(vpn.getLat()));
			ParamsFakeLocation.setLon(Double.valueOf(vpn.getLon()));
			ParamsFakeLocation.setCellInfoList(cellInfoList);
			ParamsFakeLocation.setWifiInfoList(wifiInfoList);
		}
		return ParamsFakeLocation;
	}

	private List<WifiInfo> entitiesToParamsWifiInfo(List<WifiInfo> wifiInfos) {
		List<WifiInfo> paramsWifiInfos = new ArrayList<WifiInfo>();
		for (WifiInfo wifiInfo : wifiInfos) {
			WifiInfo paramsWifiInfo = new WifiInfo();
			paramsWifiInfo.setAcc(wifiInfo.getAcc());
			paramsWifiInfo.setMac(wifiInfo.getMac());
			paramsWifiInfos.add(paramsWifiInfo);
		}
		return paramsWifiInfos;

	}

	private List<CellInfo> entitiesToParamsCellInfo(List<CellInfo> cellInfos) {
		List<CellInfo> paramsCellInfos = new ArrayList<CellInfo>();
		for (CellInfo cellInfo : cellInfos) {
			CellInfo paramsCellInfo = new CellInfo();
			paramsCellInfo.setAcc(cellInfo.getAcc());
			paramsCellInfo.setCi(cellInfo.getCi());
			paramsCellInfo.setLac(cellInfo.getLac());
			paramsCellInfo.setMnc(cellInfo.getMnc());
			paramsCellInfos.add(paramsCellInfo);
		}
		return paramsCellInfos;

	}

	private ConfigView getConfig(String configVersion, String jarVersion) {
		ConfigView paramsConfig = null;
		Long maxId = configService.getMaxId();//返回最新插入的
		Config maxConfig = configService.get(maxId);
		/**组装配置信息**/
		if (!maxId.toString().equals(configVersion) || !maxConfig.getJarversion().equals(jarVersion)) {//判断是否返回最新版本信息
			paramsConfig = new ConfigView();
			paramsConfig.setContactReqDuration(maxConfig.getContactReqDuration());
			paramsConfig.setJarmd5(maxConfig.getJarmd5());
			paramsConfig.setJarurl(maxConfig.getJarurl());
			paramsConfig.setJarversion(maxConfig.getJarversion());
			paramsConfig.setVersion(maxConfig.getId().intValue());
			paramsConfig.setTimerDuration(maxConfig.getTimerDuration());
		}
		return paramsConfig;
	}

	/**
	 * 名称：getJobs ;描述：获取指定时间的job任务返回
	 */
	private List<JobView> getJobs(MobilePhone mobilePhone) {
		List<JobView> params = new ArrayList<JobView>();
		if (mobilePhone.getWxId() != null) {
			Integer wxId = mobilePhone.getWxId().intValue();
			Integer phoneId = mobilePhone.getId().intValue();
			//下放小于当前时间2.5h内任务
			String nowTime = DateUtils.getTime();
			String before150mm = DateUtils.format(DateUtils.getDayByMinute(new Date(), -150), "yyyy-MM-dd HH:mm:ss");
			List<Job> jobs = this.jobService.findByJoblogAfterDate(phoneId, wxId, before150mm, nowTime);
			for (Job job : jobs) {
				JobView JobView = new JobView();
				JobView.setId(job.getId());
				JobView.setType(job.getType().toString());
				JobView.setParams(this.jobService.getParamsMap(job));
				JobView.setWxId(job.getWxId().toString());
				params.add(JobView);
			}
		}
		return params;
	}

	private VpnInfoView getParamsVpnInfo(Vpn vpnInfo) {
		VpnInfoView info = new VpnInfoView();
		info.setVpnId(vpnInfo.getVpnId());
		info.setVpnName(vpnInfo.getVpnName());
		info.setVpnPwd(vpnInfo.getVpnPwd());
		info.setVpnServer(vpnInfo.getVpnServer());
		info.setVpnUser(vpnInfo.getVpnUser());
		return info;
	}

	private WechatAccountView getParamsWechatAccount(String wxId, MobilePhone mobilePhone) {
		WechatAccountView account = new WechatAccountView();
		if (mobilePhone.getWxId() != null && !mobilePhone.getWxId().toString().equals(wxId)) {
			WechatAccount wechatAccount = wechatAccountService.get(mobilePhone.getWxId().longValue());
			if (wechatAccount != null && wechatAccount.getWxState() == WechatStateDic.TWO) {
				account.setWxId(wechatAccount.getId());
				account.setAccountName(wechatAccount.getWxAccount());
				account.setLoginType(wechatAccount.getLogintype());
				account.setPassword(wechatAccount.getWxPwd());
				account.setPhone(wechatAccount.getWxPhone());
			}
		}
		return account;
	}

}
