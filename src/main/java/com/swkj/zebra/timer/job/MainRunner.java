package com.swkj.zebra.timer.job;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.swkj.zebra.timer.job.second.ReceiveTaskGroupJob;

/**
 * @author: xiewanpin
 * @since:  Dec 27, 2016 6:28:01 PM
 * The class MainRunner
 * Description:
 */
public class MainRunner {

	private ThreadPoolTaskExecutor threadPoolTaskExecutor;

	private ReceiveTaskGroupJob receiveTaskGroupJob;

	public  void start() throws InterruptedException {
		for (int i = 0; i < 5; i++) {
			threadPoolTaskExecutor.execute(receiveTaskGroupJob);
		}
	}

	public ThreadPoolTaskExecutor getThreadPoolTaskExecutor() {
		return threadPoolTaskExecutor;
	}

	public void setThreadPoolTaskExecutor(ThreadPoolTaskExecutor threadPoolTaskExecutor) {
		this.threadPoolTaskExecutor = threadPoolTaskExecutor;
	}

	public ReceiveTaskGroupJob getReceiveTaskGroupJob() {
		return receiveTaskGroupJob;
	}

	public void setReceiveTaskGroupJob(ReceiveTaskGroupJob receiveTaskGroupJob) {
		this.receiveTaskGroupJob = receiveTaskGroupJob;
	}

}
