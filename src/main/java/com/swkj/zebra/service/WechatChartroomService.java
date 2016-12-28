package com.swkj.zebra.service;

import java.util.List;

import com.amaz.core.orm.CommonRepository;
import com.amaz.core.service.BaseService;
import com.swkj.zebra.dao.WechatChartroomDao;
import com.swkj.zebra.entity.WechatChartroom;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author: xiewanpin
 * @since:  Dec 13, 2016 5:48:21 PM
 * The class WechatChartroomService
 * Description:聊天室业务
 */

@Named
public class WechatChartroomService extends BaseService<WechatChartroom, Long> {

	@Inject
	private WechatChartroomDao wechatChartroomDao;

	@Override
	protected CommonRepository<WechatChartroom, Long> getEntityRepository() {
		return wechatChartroomDao;
	}

	public void saveOnDuplicate(Long wxId, String chartroomName, List<WechatChartroom> wechatChartrooms) {
	this.	wechatChartroomDao.saveOnDuplicate(wxId, chartroomName, wechatChartrooms);
	}

}
