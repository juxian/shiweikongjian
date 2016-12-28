package com.swkj.zebra.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.swkj.zebra.web.view.ContactsBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.amaz.core.common.StringUtils;
import com.swkj.zebra.common.StaticParamConstants;
import com.swkj.zebra.entity.MobilePhone;
import com.swkj.zebra.manager.ContactsManager;
import com.swkj.zebra.util.FileUtil;
import com.swkj.zebra.web.view.RequestParam;

/**
 * @author: xiewanpin
 * @since:  Dec 13, 2016 5:02:46 PM
 * The class ContactsApi
 * Description: 更新联系人接口
 */
@RestController
@RequestMapping("/wxapi_contacts")
public class ContactsApi {

	@Autowired
	private ContactsManager contactsManager;

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody String index(RequestParam requestParam, HttpServletRequest request, HttpServletResponse response) throws IOException {
		/**反序列化接受请求数据**/
		ContactsBody contactsBody = JSON.parseObject(FileUtil.getJson(request.getInputStream()), ContactsBody.class);
		if (null == contactsBody) {//请求数据为null
			return StaticParamConstants.State.FAIL;
		} else {
			/**请求数据正常,进行内容校验**/
			if (StringUtils.isEmpty(requestParam.getMn()) || StringUtils.isEmpty(requestParam.getWi())) {//公共部分MN 手机编号，WI微信编号校验
				return StaticParamConstants.State.FAIL;
			} else {
				/**公共部分完整*联系人手机校验**/
				MobilePhone mobilePhone = this.contactsManager.getContactsMobilePhoneByMn(requestParam.getMn());
				if (null == mobilePhone || null == mobilePhone.getWxId()) {
					return StaticParamConstants.State.FAIL;
				}
				/**联系人数据更新**/
				this.contactsManager.handleContactsData(contactsBody, requestParam);
			}
		}
		return StaticParamConstants.State.SUCCESS;
	}
}
