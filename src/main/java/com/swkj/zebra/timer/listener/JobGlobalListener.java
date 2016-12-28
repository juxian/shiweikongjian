package com.swkj.zebra.timer.listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.springframework.stereotype.Service;

/**
 * @author: xiewanpin
 * @since:  Dec 19, 2016 4:37:14 PM
 * The class JobGlobalListener
 * Description: 
 */
@Service
public class JobGlobalListener implements JobListener {

	Log logger = LogFactory.getLog(JobGlobalListener.class);

	public void jobToBeExecuted(JobExecutionContext context) {
		logger.info(context.getJobInstance().getClass().getSimpleName() + " is about to be executed");
	}

	public void jobExecutionVetoed(JobExecutionContext context) {
		logger.info(context.getJobInstance().getClass().getSimpleName() + " was vetoed and not executed()");
	}

	public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
		logger.info(context.getJobInstance().getClass().getSimpleName() + " was executed");

	}

	@Override
	public String getName() {
		return getClass().getName();
	}
}
