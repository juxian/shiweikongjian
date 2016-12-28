/*
 * Copyright (C) 2011-2015 ShenZhen iBOXPAY Information Technology Co.,Ltd.
 *
 * All right reserved.
 *
 * This software is the confidential and proprietary
 * information of iBoxPay Company of China.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with iBoxpay inc.
 *
 */
package com.swkj.zebra.timer.job;

import java.io.Serializable;

import org.springframework.scheduling.quartz.QuartzJobBean;
/**
 * @author: xiewanpin
 * @since:  Dec 26, 2016 1:14:02 PM
 * The class BaseJob
 * Description: base class
 */
public abstract class BaseJob extends QuartzJobBean implements Serializable {
	    
	private static final long serialVersionUID = 1L;
	private String jobName;
	private String jobCode;
	// 是否正在运行
	protected boolean running = false;

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

}
