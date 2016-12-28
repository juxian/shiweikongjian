package com.swkj.zebra.timer.job.second;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerContext;
import org.quartz.SchedulerException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.swkj.zebra.timer.job.BaseJob;

/**
 * @author: xiewanpin
 * @since:  Dec 27, 2016 6:28:16 PM
 * The class SendTaskGroupJob
 * Description:
 */
public class SendTaskGroupJob extends BaseJob {

	private static final long serialVersionUID = 1L;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		try {
			SchedulerContext scheCtx = context.getScheduler().getContext();
			AmqpTemplate	amqpTemplate =(AmqpTemplate) scheCtx.get("amqpTemplate"); 
			
			/***取出 最上的一条数据数据**/
//		this.taskGroupService.get(new ArrayList<Object>());
			/***放入队列**/
//		this.amqpTemplate.convertAndSend(new  TaskGroupView());
		} catch (SchedulerException e) {
			    
		}     
	}

}
