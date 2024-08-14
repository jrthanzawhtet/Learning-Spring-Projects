package com.tzh.spring.trx.repo;

import java.util.Optional;

import com.tzh.spring.trx.dto.input.CashInForm;
import com.tzh.spring.trx.dto.output.CashInDetails;

public interface TransactionBaseCashInRepo {
	
	Optional<CashInDetails> findById(int id);
	
	void create(int trxId, CashInForm from);

}
