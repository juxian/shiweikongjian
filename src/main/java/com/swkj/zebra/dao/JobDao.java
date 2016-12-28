package com.swkj.zebra.dao;

import java.util.HashMap;
import java.util.Map;

import com.amaz.core.common.DateUtils;
import com.amaz.core.orm.hibernate.HibernateTemplate;
import com.swkj.zebra.entity.Job;

import javax.inject.Named;

/**
 * Created by sunbaoliang on 2016/12/13 0013.
 */

@Named
public class JobDao extends HibernateTemplate<Job, Long> {

	public void updateJog(Long jobId, Integer jobState) {
		String hql = "update Job j set j.state=?0,j.endTime=?1 where j.id =?2";
        Map<String, Object> map = new HashMap<>();
        map.put("0", jobState);
        map.put("1", DateUtils.getTime());
        map.put("2", jobId);
        this. batchExecute(hql, map);
	}
}
