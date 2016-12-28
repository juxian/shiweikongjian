package com.swkj.zebra.timer.job.second;

import org.springframework.amqp.core.AmqpTemplate;
/**
 * @author: xiewanpin
 * @since:  Dec 27, 2016 6:11:18 PM
 * The class ReceiveTaskGroupJob
 * Description:
 */

public class ReceiveTaskGroupJob implements Runnable {

	private AmqpTemplate amqpTemplate;

	@Override
	public void run() {
		while (true) {
			Object jsonString = this.amqpTemplate.receiveAndConvert("queue_job");
			if (null == jsonString) continue;
			/**业务处理添加**/
		}

	}

	public AmqpTemplate getAmqpTemplate() {
		return amqpTemplate;
	}

	public void setAmqpTemplate(AmqpTemplate amqpTemplate) {
		this.amqpTemplate = amqpTemplate;
	}

}
