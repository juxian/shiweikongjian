package com.swkj.zebra.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.swkj.zebra.manager.DataSyncManager;
import com.swkj.zebra.util.FileUtil;
import com.swkj.zebra.web.view.DataSyncBody;
import com.swkj.zebra.web.view.RequestParam;

/**
 * @author: xiewanpin
 * @since:  Dec 14, 2016 4:32:37 PM
 * The class DataSyncApi
 * Description:数据同步接口
 */
@RestController
@RequestMapping("/wxapi_datasync")
public class DataSyncApi {

	@Autowired
	private ContactsManager contactsManager;
	@Autowired
	private DataSyncManager dataSyncManager;

	@RequestMapping(method = RequestMethod.POST)
	private @ResponseBody String datasync(RequestParam requestParam, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String resMes = StaticParamConstants.State.SUCCESS;
		/**接受请求数据**/
		DataSyncBody dataSyncBody = JSON.parseObject(FileUtil.getJson(request.getInputStream()), DataSyncBody.class);
		if (null == dataSyncBody) {
			return StaticParamConstants.State.EXCEPTION;
		} else {
			/** 编号验证**/
			if (StringUtils.isEmpty(requestParam.getMn())) {
				return StaticParamConstants.State.EXCEPTION;
			} else {
				/** 手机验证**/
				MobilePhone mobilePhone = this.contactsManager.getContactsMobilePhoneByMn(requestParam.getMn());
				if (null == mobilePhone) {
					return StaticParamConstants.State.EXCEPTION;
				} else {
					/** 业务处理**/
					try {
						resMes =this.dataSyncManager.handleDataSync(dataSyncBody, request,requestParam, mobilePhone,"datasync");//数据同步
					} catch (Exception e) {
						resMes = StaticParamConstants.State.EXCEPTION;
						e.printStackTrace();
					}
				}
			}
		}
		return resMes;
	}

}
