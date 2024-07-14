package com.jdc.spring;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jdc.spring.hello.BeanConfiguration;
import com.jdc.spring.hello.HelloBean;

public class GettingStart {
	
	@Test
	void loadTest() {
		try(var context = new AnnotationConfigApplicationContext(BeanConfiguration.class)) {
			var bean = context.getBean(HelloBean.class);
			System.out.println(bean.sayHello());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
