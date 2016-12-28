package com.swkj.zebra.service;

import com.amaz.core.orm.CommonRepository;
import com.amaz.core.service.BaseService;
import com.swkj.zebra.dao.ConfigDao;
import com.swkj.zebra.entity.Config;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by sunbaoliang on 2016/12/13 0013.
 */

@Named
public class ConfigService extends BaseService<Config,Long>{
    @Inject
    private ConfigDao configDao;

    @Override
    protected CommonRepository<Config, Long> getEntityRepository() {
        return configDao;
    }

	public Long getMaxId() {
		// TODO Auto-generated method stub
		return null;
	}
}
