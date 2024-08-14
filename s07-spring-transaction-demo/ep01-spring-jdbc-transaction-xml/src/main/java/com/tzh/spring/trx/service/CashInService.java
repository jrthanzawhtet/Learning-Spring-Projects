package com.tzh.spring.trx.service;

import com.tzh.spring.trx.dto.input.CashInForm;
import com.tzh.spring.trx.dto.output.CashInDetails;

public interface CashInService {
	
	int cashIn(CashInForm form);
	
	CashInDetails findById(int id);

}
