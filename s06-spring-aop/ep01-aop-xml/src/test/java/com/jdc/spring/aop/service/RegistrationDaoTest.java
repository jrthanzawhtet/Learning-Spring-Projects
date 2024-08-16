package com.jdc.spring.aop.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.spring.aop.model.RegistrationForm;

@TestMethodOrder(value = OrderAnnotation.class)
@SpringJUnitConfig(locations = "classpath:/application.xml")
public class RegistrationDaoTest {
	
	@Autowired
	private RegistrationDao dao;
	
	@Order(1)
	@ParameterizedTest
	@CsvFileSource(resources = "/create.txt", delimiter = '\t')
	void test_create(String course,int fees, String student, String phone, String email, int id) {
		var result = dao.create(new RegistrationForm(course, fees, student, phone, email));
		assertEquals(id, result);
	}
	
	@Order(2)
	@ParameterizedTest
	@CsvFileSource(resources = "/create.txt", delimiter = '\t')
	void test_find_by_id(String course, int fees, String student, String phone, String email, int id) {
		var result = dao.findById(id);
		assertNotNull(result);	
		assertEquals(course, result.course());
		assertEquals(fees, result.fees());
		assertEquals(student, result.student());
	}

}
