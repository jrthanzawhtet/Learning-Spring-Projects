package com.tzh.spring.trx.repo;

import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import com.tzh.spring.trx.dto.input.CashInForm;
import com.tzh.spring.trx.dto.output.CashInDetails;

@Repository
public class TransactionBaseCashInRepoImpl implements TransactionBaseCashInRepo{
	
	private final JdbcClient jdbcClient;
	private final RowMapper<CashInDetails> rowMapper;
	
	public TransactionBaseCashInRepoImpl(DataSource dataSource) {
		jdbcClient = JdbcClient.create(dataSource);
		rowMapper = new DataClassRowMapper<>(CashInDetails.class);
	}

	@Override
	public Optional<CashInDetails> findById(int id) {
		return jdbcClient.sql("""
				select c.id , b.trx_type ,b.issue_at , b.status , b.ledger,
				b.account_id , a.name , a.level,b.before_usb, b.amount,
				p.particular,c.cash_in_from
				from TRX_CASH_IN c join TRX_BASE b on c.id = b.id 
				join ACCOUNT 	a on b.account_id = a.login_id where c.id = ? 
				""")
				.param(id)
				.query(rowMapper)
				.optional();
	}

	@Override
	public void create(int trxId, CashInForm from) {
		jdbcClient.sql("insert into TRX_CASH_IN values (?,?")
		.param(trxId)
		.param(from)
		.update();
		
	}

}
