package com.swkj.zebra.service;

import java.util.List;

import com.amaz.core.orm.CommonRepository;
import com.amaz.core.service.BaseService;
import com.swkj.zebra.dao.WifiInfoDao;
import com.swkj.zebra.entity.WifiInfo;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by sunbaoliang on 2016/12/13 0013.
 * wifi 业务
 */

@Named
public class WifiInfoService extends BaseService<WifiInfo,Long>{
    @Inject
    private WifiInfoDao wifiInfoDao;

    @Override
    protected CommonRepository<WifiInfo, Long> getEntityRepository() {
        return wifiInfoDao;
    }

    public List<WifiInfo> findByGpsId(Integer gpsId) {
        return find("gpsId", gpsId);
    }
}
