package com.tzh.spring.trx.service;

import java.util.List;

import com.tzh.spring.trx.dto.input.UserBalanceSearch;
import com.tzh.spring.trx.dto.output.UserBalanceInfo;

public interface UserBalanceService {
	
	List<UserBalanceInfo> search(UserBalanceSearch search);

}
