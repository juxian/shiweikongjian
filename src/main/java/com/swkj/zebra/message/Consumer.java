package com.swkj.zebra.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Service;

/**
 * @author: xiewanpin
 * @since:  Dec 26, 2016 3:25:20 PM
 * The class MessageConsumer
 * Description:测试用
 */
@Service
public class Consumer implements MessageListener {

	private Logger logger = LoggerFactory.getLogger(Consumer.class);

	@Override
	public void onMessage(Message message) {
		logger.info("receive message:{}", message);
	}

}