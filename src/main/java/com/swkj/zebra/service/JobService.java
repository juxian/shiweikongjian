package com.swkj.zebra.service;

import com.amaz.core.orm.CommonRepository;
import com.amaz.core.service.BaseService;
import com.swkj.zebra.dao.JobDao;
import com.swkj.zebra.entity.Job;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by sunbaoliang on 2016/12/13 0013.
 */

@Named
public class JobService extends BaseService<Job, Long> {
    @Inject
    private JobDao jobDao;

    @Override
    protected CommonRepository<Job, Long> getEntityRepository() {
        return jobDao;
    }

	public void updateJogLog(Long jobLogId, Integer jobState, String errorMsg, String memo) {
		// TODO Auto-generated method stub
		
	}

	public List<Job> findByJoblogAfterDate(Integer phoneId, Integer wxId, String before150mm, String nowTime) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> getParamsMap(Job job) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateJog(Long jobId, Integer jobState) {
	this.	jobDao.updateJog(jobId, jobState);
		    
	}
}
