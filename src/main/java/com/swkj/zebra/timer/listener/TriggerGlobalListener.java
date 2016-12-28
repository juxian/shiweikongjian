package com.swkj.zebra.timer.listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.Trigger.CompletedExecutionInstruction;
import org.quartz.TriggerListener;

/**
 * @author: xiewanpin
 * @since:  Dec 20, 2016 10:04:10 AM
 * The class TriggerGlobalListener
 * Description:
 */
public class TriggerGlobalListener implements TriggerListener {

	Log logger = LogFactory.getLog(JobGlobalListener.class);

	@Override
	public String getName() {
		return getClass().getName();

	}

	@Override
	public void triggerFired(Trigger trigger, JobExecutionContext context) {
		logger.error(trigger.getClass().getName() + " was fired");
	}

	@Override
	public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {
		return false;

	}

	@Override
	public void triggerMisfired(Trigger trigger) {
		logger.error(trigger.getClass().getName() + "  was not vetoed");

	}

	@Override
	public void triggerComplete(Trigger trigger, JobExecutionContext context, CompletedExecutionInstruction triggerInstructionCode) {
		logger.error(trigger.getClass().getName() + " was complete");

	}
}
