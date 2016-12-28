package com.swkj.zebra.service;
import java.util.Collection;
import java.util.List;
import com.amaz.core.orm.CommonRepository;
import com.amaz.core.service.BaseService;
import com.swkj.zebra.dao.WechatContactDao;
import com.swkj.zebra.entity.WechatContact;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author: xiewanpin
 * @since:  Dec 13, 2016 5:48:47 PM
 * The class WechatContactService
 * Description: 联系人业务
 */
@Named
public class WechatContactService extends BaseService<WechatContact, Long> {

	@Inject
	private WechatContactDao wechatContactDao;

	@Override
	protected CommonRepository<WechatContact, Long> getEntityRepository() {
		return this.wechatContactDao;
	}

	
	public void saveByWxId(Integer wxId, Collection<WechatContact> wechatContacts) {
		this.wechatContactDao.updateByWxId(wxId);//默认初始化数据
		this.wechatContactDao.saveOnDuplicateByWxId(wxId, wechatContacts);

	}

	public void saveOnDuplicateValidate(List<WechatContact> wechatContacts) {
		if(wechatContacts.size()>0)
		this.	wechatContactDao.saveOnDuplicateValidate(wechatContacts);
	}
}
