package com.swkj.zebra.manager;

import java.util.ArrayList;
import java.util.List;

import com.amaz.core.common.DateUtils;
import com.amaz.core.common.StringUtils;
import com.swkj.zebra.entity.MobilePhone;
import com.swkj.zebra.entity.WechatAccount;
import com.swkj.zebra.entity.WechatContact;
import com.swkj.zebra.service.MobilePhoneService;
import com.swkj.zebra.service.WechatAccountService;
import com.swkj.zebra.service.WechatContactService;
import com.swkj.zebra.util.CharacterFilter;
import com.swkj.zebra.web.view.ContactsBody;
import com.swkj.zebra.web.view.RequestParam;
import com.swkj.zebra.web.view.UserInfoView;
import com.swkj.zebra.web.view.WechatContactView;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author: xiewanpin
 * @since:  Dec 13, 2016 5:03:09 PM
 * The class ContactsManager
 * Description: 更新联系人接口
 */
@Named
public class ContactsManager {

	@Inject
	private WechatContactService wechatContactService;

	@Inject
	private WechatAccountService wechatAccountService;

	@Inject
	private MobilePhoneService mobilePhoneService;

	/**
	 * 名称：handleContactsData ;描述：更新联系人入口方法
	 */
	public void handleContactsData(ContactsBody contactsBody, RequestParam requestParam) {
		/**联系人处理**/
		this.saveWechatContacts(contactsBody, requestParam);
		/**账号处理**/
		this.updateWechatAccount(contactsBody, requestParam);

	}

	/**
	 * 名称：getContactsMobilePhoneByMn ;描述：根据手机编号查找手机信息参数（mn 与phoneNo对应）
	 */
	public MobilePhone getContactsMobilePhoneByMn(String mn) {
		MobilePhone mPhone=null;
		try {
			mPhone= this.mobilePhoneService.get("phoneNo", mn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mPhone;
	}

	
	private final void saveWechatContacts(ContactsBody contactsBody, RequestParam requestParam) {
		/**获取联系人信息**/
		List<WechatContactView> wechatContactViews = contactsBody.getWechatContacts();
		Integer wxId = Integer.parseInt(requestParam.getWi());//账号标识由微信编号生成
		List<WechatContact> wechatContacts = new ArrayList<WechatContact>();
		/**联系人数据组装**/
		for (WechatContactView wechatContactView : wechatContactViews) {
			WechatContact wechatContact = new WechatContact();
			String userName = wechatContactView.getUserName();
			Integer type = wechatContactView.getType();//联系人标识
			if (StringUtils.isEmpty(userName) || type == null) {
				continue;
			}
			String nickName = CharacterFilter.filterEmoji(wechatContactView.getNickName());
			String conRemark = wechatContactView.getConRemark();
			String alias = wechatContactView.getAlias();
			wechatContact.setWxId(wxId);
			wechatContact.setWxContactUid(userName);
			wechatContact.setAddTime(DateUtils.getTime());
			wechatContact.setInternal(0); //外部好友
			wechatContact.setStatus(1); //状态可用
			wechatContact.setAlias(alias);
			wechatContact.setNickname(nickName);
			wechatContact.setType(type);
			wechatContact.setUpdateTime(DateUtils.getTime());
			wechatContact.setConremark(conRemark);
			wechatContacts.add(wechatContact);
		}
		/**保存联系人信息 **/
		if (wechatContacts.size() > 0) this.wechatContactService.saveByWxId(wxId, wechatContacts);

	}

	private final void updateWechatAccount(ContactsBody contactsBody, RequestParam requestParam) {
		/**获取微信账号的基础数据**/
		UserInfoView userInfoView = contactsBody.getUserInfo();
		/** 微信账号信息组装**/
		if (null != userInfoView) {
			WechatAccount wechatAccount = this.wechatAccountService.get(Long.valueOf(requestParam.getWi()));
			if (null != wechatAccount) {
				String nickname = userInfoView.getNickName();//微信昵称
				String wxUid = userInfoView.getUserName();//微信uid标识
				wechatAccount.setNickname(null != nickname ? nickname : "");
				wechatAccount.setWxuid(null != wxUid ? wxUid : "");
				this.wechatAccountService.save(wechatAccount);
			}
		}
	}

}
