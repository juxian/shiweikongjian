package com.swkj.zebra.service;

import com.amaz.core.orm.CommonRepository;
import com.amaz.core.service.BaseService;
import com.swkj.zebra.dao.VpnDao;
import com.swkj.zebra.entity.Vpn;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author: xiewanpin
 * @since:  Dec 13, 2016 5:42:12 PM
 * The class VpnInfoService
 * Description:vpn 业务接口
 */

@Named
public class VpnInfoService extends BaseService<Vpn,Long> {
    @Inject
    private VpnDao vpnInfoDao;

    @Override
    protected CommonRepository<Vpn, Long> getEntityRepository() {
        return vpnInfoDao;
    }

    public Vpn getByVpnId(Integer vpnId) {
        return get("vpnId", vpnId);
    }

	public Vpn getByVpnId(Long mvpnId) {
		// TODO Auto-generated method stub
		return null;
	}
}
