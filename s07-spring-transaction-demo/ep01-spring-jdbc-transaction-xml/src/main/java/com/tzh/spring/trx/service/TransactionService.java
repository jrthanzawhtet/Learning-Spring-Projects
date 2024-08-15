package com.tzh.spring.trx.service;

import java.util.List;

import com.tzh.spring.trx.dto.input.TransactionSearch;
import com.tzh.spring.trx.dto.output.TransactionInfo;

public interface TransactionService {
	
	List<TransactionInfo> search(TransactionSearch search);

}
