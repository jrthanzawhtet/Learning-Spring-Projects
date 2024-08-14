package com.tzh.spring.trx.repo;

import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import com.tzh.spring.trx.dto.output.LimitSettingDto;
import com.tzh.spring.trx.utils.constants.TransactionType;
import com.tzh.spring.trx.utils.constants.UserLevel;

@Repository
public class LimitSettingRepoImpl implements LimitSettingRepo{
	
	private final JdbcClient jdbcClient;
	private final RowMapper<LimitSettingDto> rowMapper;
	
	
	public LimitSettingRepoImpl(DataSource dataSource) {
		jdbcClient = JdbcClient.create(dataSource);
		rowMapper = new DataClassRowMapper<>(LimitSettingDto.class);
	}

	@Override
	public Optional<LimitSettingDto> findById(UserLevel level, TransactionType type) {
		return jdbcClient.sql("select * from LIMIT_SETTING where user_level = ? and trx_type = ?")
				.param(level)
				.param(type)
				.query(rowMapper)
				.optional();



	}

}
