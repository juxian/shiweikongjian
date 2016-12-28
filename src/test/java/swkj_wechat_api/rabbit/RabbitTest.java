package swkj_wechat_api.rabbit;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONPObject;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonAnyFormatVisitor;
import com.swkj.zebra.BootApplication;
import com.swkj.zebra.web.view.TaskGroupView;

/**
 * @author: xiewanpin
 * @since:  Dec 26, 2016 6:51:58 PM
 * The class RabbitTest
 * Description: rabbit  资源测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BootApplication.class)
public class RabbitTest {

	@Autowired
	private AmqpTemplate amqpTemplate;
	@Autowired
	private ThreadPoolTaskExecutor threadPoolTaskExecutor;

	private static TaskGroupView vo = new TaskGroupView();

	static {
		vo.setCreateTime(new Date().toString());
		vo.setId("2");
		vo.setNameString("新建群任务");
	}

	@Test
	public void cheked() {
		try {
//		while(true){
//			String jString = JSON.toJSONString(vo);
//			this.amqpTemplate.convertAndSend(jString);
//			System.out.println("结束");
//		}
			
			
			Object vo1 = amqpTemplate.receiveAndConvert("queue_one");
			TaskGroupView taskGroupView=JSON.parseObject( vo1.toString(), TaskGroupView.class);
			System.out.println("Received: " + vo1.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("jieshu");
	}

	/*@Before*/
	public void chekedVo() {
		try {
			while (true) {
				this.amqpTemplate.convertAndSend(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("jieshu");
	}

}
