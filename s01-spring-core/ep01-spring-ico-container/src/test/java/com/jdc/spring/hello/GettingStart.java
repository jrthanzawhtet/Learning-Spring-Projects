package com.jdc.spring.hello;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class GettingStart {

	@Test
	void loadTest() {

		// Create IOC Container
		try (var context = new GenericXmlApplicationContext()) {
			// load Configuration File
			context.load("classpath:/application.xml");

			// Refresh IOC Container (Initialize Beans)
			context.refresh();

			var bean = context.getBean("helloBean");
			if (bean instanceof HelloBean helloBean) {
				var message = helloBean.sayHello();
				System.out.println(message);
			}
		}
	}

	@Test
	void loadTest2() {
		try (var context = new GenericXmlApplicationContext("classpath:/application.xml")) {
			var message = context.getBean("helloBean", HelloBean.class);
			System.out.println(message);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
