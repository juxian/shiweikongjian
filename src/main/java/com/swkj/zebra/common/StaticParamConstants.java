package com.swkj.zebra.common;

/**
 * @author: xiewanpin
 * @since:  Dec 13, 2016 7:42:15 PM
 * The class StaticParamConstants
 * Description:静态字段
 */
public class StaticParamConstants {

	/**响应码**/
	public static class State {

		public static final String SUCCESS = "200";// 成功

		public static final String FAIL = "500";// 服务器异常

		public static final String EXCEPTION = "400";//请求失败
	}

	/***job状态**/
	public static class JobStateDic {

		public static final Integer ZERO = 0; //新建未下放

		public static final Integer SUCCESS = 1; //成功

		public static final Integer TWO = 2; //失败

		public static final Integer THREE = 3; //新建已下放
	}

	/**账号状态**/
	public static class WechatStateDic {

		public static final Integer ONE = 1; //空闲账号

		public static final Integer TWO = 2; //账号正常

		public static final Integer THREE = 3; //登录环境异常
	}

	/**Job类型**/
	public static class JobType {

		public static final Integer LOGIN = 1;//登陆

		public static final Integer RED_PACKET = 2;//发红包

		public static final Integer SEND_MESSAGE = 3;//发送文字消息

		public static final Integer ACCEPT_REQUEST = 4;//接受好友请求

		public static final Integer NEW_VPN = 5;//新建VPN

		public static final Integer LINE_VPN = 6;//连接VPN

		public static final Integer REG_WECHAT = 7;//注册微信账号

		public static final Integer START_WECHAT = 8;//启动微信

		public static final Integer NICKNAME = 9;//昵称

		public static final Integer AVATAR = 10;//头像

		public static final Integer FRIENDS = 11;//朋友圈

		public static final Integer ABOUT = 17;//个性签名

		public static final Integer ADD_FRIENDS = 18;//查找并添加好友

		public static final Integer REQ_TALK = 19;//发起群聊

		public static final Integer PULL_RIENDS = 20;//拉好友进群聊

		public static final Integer CHARTROOM_NAME = 21;//修改群聊名称

		public static final Integer SEND_VOICE = 25;//发送语音信息

		public static final Integer DEL_NOTIFY = 26;//删除打招呼信息

		public static final Integer GENDER = 27;//性别

		public static final Integer BACKGROUND = 28;//背景图片

		public static final Integer ADD_MEMBER = 32;//添加群成员为好友

		public static final Integer DEL_MEMBER = 36;//踢出群聊

		public static final Integer QR_CODE = 45;//二维码
	}

	/***判断错误类型**/
	public static class WechatStateParams {

		public static Integer getWeixinErrId(String extra) {

			Integer weixinerrId = 0;

			if (extra.contains("未注册")) {
				weixinerrId = 1;
			} else if (extra.contains("环境异常")) {
				weixinerrId = 3;
			} else if (extra.contains("帐号或密码错误")) {
				weixinerrId = 4;
			} else if (extra.contains("永久封号") || extra.contains("永久被封")) {
				weixinerrId = 5;
			} else if (extra.contains("非法软件注册")) {
				weixinerrId = 6;
			} else if (extra.contains("操作频率过快")) {
				weixinerrId = 8;
			} else if (extra.contains("需要好友验证")) {
				weixinerrId = 9;
			} else if (extra.contains("手机号或验证码错误")) {
				weixinerrId = 10;
			} else if (extra.contains("无法识别当前界面")) {
				weixinerrId = 11;
			} else if (extra.contains("账号密码输入界面出错")) {
				weixinerrId = 12;
			} else if (extra.contains("被多人投诉并确认有违规行为")) {
				weixinerrId = 13;
			} else if (extra.contains("尝试在新手机登录账号")) {
				weixinerrId = 25;
			} else if (extra.contains("非法客户端或者第三方解封被执行封号")) {
				weixinerrId = 26;
			} else if (extra.contains("界面流程错误")) {
				weixinerrId = 27;
			}
			return weixinerrId;
		}
	}
}
