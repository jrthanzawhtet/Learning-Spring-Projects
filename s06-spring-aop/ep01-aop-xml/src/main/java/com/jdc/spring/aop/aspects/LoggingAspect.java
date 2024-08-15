package com.jdc.spring.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;

import com.jdc.spring.aop.model.RegistrationForm;

public class LoggingAspect {

	public void beforeAdvice(RegistrationForm form) {
		try {
			System.out.println("Before Execution Method");
			System.out.println(form);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void afterReturningAdvice(Object result) {
		System.out.println("Checking Result");
		System.out.println(result);
	}

	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		try {
			System.out.printf("Find method with id: %s%n", joinPoint.getArgs()[0]);
			var result = joinPoint.proceed();

			return result;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return joinPoint;

	}

}
