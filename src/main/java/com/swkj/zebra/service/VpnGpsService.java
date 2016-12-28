package com.swkj.zebra.service;

import com.amaz.core.orm.CommonRepository;
import com.amaz.core.service.BaseService;
import com.swkj.zebra.dao.VpnGpsDao;
import com.swkj.zebra.entity.Vpn;
import com.swkj.zebra.entity.VpnGps;
import com.swkj.zebra.web.view.FakeLocationView;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by sunbaoliang on 2016/12/13 0013.
 */

@Named
public class VpnGpsService extends BaseService<VpnGps, Long> {
    @Inject
    private VpnGpsDao vpnGpsDao;

    @Override
    protected CommonRepository<VpnGps, Long> getEntityRepository() {
        return vpnGpsDao;
    }

	public FakeLocationView getParamsFakeLocation(Vpn vpn) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getRandomIdByVpnId(Long vpnId) {
		return null;
		    
	}
}
