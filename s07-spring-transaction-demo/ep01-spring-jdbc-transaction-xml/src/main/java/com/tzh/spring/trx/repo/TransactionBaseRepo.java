package com.tzh.spring.trx.repo;

import java.time.LocalDate;
import java.util.List;

import com.tzh.spring.trx.dto.input.TransactionBaseForm;
import com.tzh.spring.trx.dto.input.TransactionSearch;
import com.tzh.spring.trx.dto.output.TransactionInfo;
import com.tzh.spring.trx.utils.constants.TransactionStatus;
import com.tzh.spring.trx.utils.constants.TransactionType;

public interface TransactionBaseRepo {
	
	int create(TransactionBaseForm form);
	
	void updateStatus(int trxId, TransactionStatus success);
	
	Long findTotalAmount(String userId, TransactionType type, LocalDate now);
	
	List<TransactionInfo> search(TransactionSearch search);

}
