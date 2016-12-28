package com.swkj.zebra.service;

import java.util.List;

import com.amaz.core.orm.CommonRepository;
import com.amaz.core.service.BaseService;
import com.swkj.zebra.dao.CellInfoDao;
import com.swkj.zebra.entity.CellInfo;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by sunbaoliang on 2016/12/13 0013.
 */

@Named
public class CellInfoService extends BaseService<CellInfo, Long> {
    @Inject
    private CellInfoDao cellInfoDao;

    @Override
    protected CommonRepository<CellInfo, Long> getEntityRepository() {
        return cellInfoDao;
    }

    public List<CellInfo> findByGpsId(Integer gpsId) {
        return find("gpsId", gpsId);
    }
}
