package com.swkj.zebra.service;

import com.amaz.core.orm.CommonRepository;
import com.amaz.core.service.BaseService;
import com.swkj.zebra.dao.PhoneEnvDao;
import com.swkj.zebra.entity.PhoneEnv;
import com.swkj.zebra.web.view.PhoneEnvView;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by sunbaoliang on 2016/12/13 0013.
 */

@Named
public class PhoneEnvService extends BaseService<PhoneEnv,Long>{
    @Inject
    private PhoneEnvDao phoneEnvDao;

    @Override
    protected CommonRepository<PhoneEnv, Long> getEntityRepository() {
        return phoneEnvDao;
    }

	public PhoneEnvView getByWxId(long longValue) {
		// TODO Auto-generated method stub
		return null;
	}
}
