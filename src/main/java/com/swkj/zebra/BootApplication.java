package com.swkj.zebra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import com.swkj.zebra.timer.job.MainRunner;

/**
 * @author: xiewanpin
 * @since:  Dec 27, 2016 4:29:34 PM
 * The class BootApplication
 * Description: 
 */
@SpringBootApplication
@ImportResource(locations = { "classpath*:applicationContext-core.xml" })
public class BootApplication {
	public static void main(String[] args) throws Exception {
			SpringApplication.run(BootApplication.class, args);
	}
		


}