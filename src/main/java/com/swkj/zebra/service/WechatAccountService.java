package com.swkj.zebra.service;
import com.amaz.core.orm.CommonRepository;
import com.amaz.core.service.BaseService;
import com.swkj.zebra.dao.WechatAccountDao;
import com.swkj.zebra.entity.WechatAccount;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author: xiewanpin
 * @since:  Dec 13, 2016 5:43:11 PM
 * The class WechatAccountService
 * Description:微信账号业务类
 */

@Named
public class WechatAccountService extends BaseService<WechatAccount, Long> {

    @Inject
    private WechatAccountDao wechatAccountDao;

	@Override
	protected CommonRepository<WechatAccount, Long> getEntityRepository() {
		return this. wechatAccountDao;
		    
	}

	public void updateWechatAccountByWxId(Long wxId, Integer wxState, String memo) {
		 this.wechatAccountDao.updateWechatAccountByWxId(wxId, wxState, memo);
		
	}

    
}
