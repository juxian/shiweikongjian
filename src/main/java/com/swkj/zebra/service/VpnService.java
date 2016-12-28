package com.swkj.zebra.service;

import com.amaz.core.orm.CommonRepository;
import com.amaz.core.service.BaseService;
import com.swkj.zebra.dao.VpnDao;
import com.swkj.zebra.entity.Vpn;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by sunbaoliang on 2016/12/13 0013.
 */

@Named
public class VpnService extends BaseService<Vpn, Long> {
    @Inject
    private VpnDao vpnDao;

    @Override
    protected CommonRepository<Vpn, Long> getEntityRepository() {
        return vpnDao;
    }
}
