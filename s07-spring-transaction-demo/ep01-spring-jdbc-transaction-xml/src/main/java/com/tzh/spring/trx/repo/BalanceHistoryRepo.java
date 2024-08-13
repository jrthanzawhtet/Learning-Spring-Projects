package com.tzh.spring.trx.repo;

import java.util.List;

import com.tzh.spring.trx.dto.input.BalanceHistoryForm;
import com.tzh.spring.trx.dto.input.UserBalanceSearch;
import com.tzh.spring.trx.dto.output.UserBalanceInfo;

public interface BalanceHistoryRepo {
	
	
	void create(BalanceHistoryForm form);
	
	List<UserBalanceInfo> search(UserBalanceSearch search);
}
