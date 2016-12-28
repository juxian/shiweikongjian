package com.swkj.zebra.service;

import com.amaz.core.orm.CommonRepository;
import com.amaz.core.service.BaseService;
import com.swkj.zebra.dao.MobilePhoneDao;
import com.swkj.zebra.entity.MobilePhone;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by sunbaoliang on 2016/12/13 0013.
 */

@Named
public class MobilePhoneService extends BaseService<MobilePhone, Long> {
    @Inject
    private MobilePhoneDao mobilePhoneDao;

    @Override
    protected CommonRepository<MobilePhone, Long> getEntityRepository() {
        return mobilePhoneDao;
    }
}
