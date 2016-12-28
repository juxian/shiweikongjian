package com.swkj.zebra.dao;

import java.util.HashMap;
import java.util.Map;

import com.amaz.core.common.DateUtils;
import com.amaz.core.orm.hibernate.HibernateTemplate;
import com.swkj.zebra.entity.WechatAccount;

import javax.inject.Named;

/**
 * Created by sunbaoliang on 2016/12/13 0013.
 */

@Named
public class WechatAccountDao extends HibernateTemplate<WechatAccount,Long>{

	public void updateWechatAccountByWxId(Long wxId, Integer wxState, String memo) {
		 String hql = "update WechatAccount w set w.wxState=?0,w.updateTime=?1,w.memo=?2 where w.wxId =?3";
	        Map<String, Object> map = new HashMap<>();
	        map.put("0", wxState);
	        map.put("1", DateUtils.getTime());
	        map.put("2", memo);
	        map.put("3", wxId);
	        batchExecute(hql, map);
	}
}
