package com.jdc.spring.aop.service;

import java.time.LocalDate;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import com.jdc.spring.aop.model.RegistrationDto;
import com.jdc.spring.aop.model.RegistrationForm;

@Repository
public class RegistrationDaoImpl implements RegistrationDao {
	
	private JdbcClient jdbcClient;
	private RowMapper<RegistrationDto> rowMapper;
	
	
	public RegistrationDaoImpl(DataSource dataSource) {
		this.jdbcClient = JdbcClient.create(dataSource);
		this.rowMapper = new DataClassRowMapper<>(RegistrationDto.class);
	}


	@Override
	public int create(RegistrationForm form) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public RegistrationDto findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<RegistrationDto> search(String keyword, LocalDate from, LocalDate to) {
		// TODO Auto-generated method stub
		return null;
	}

}
