package com.tzh.spring.trx.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tzh.spring.trx.dto.input.UserBalanceSearch;
import com.tzh.spring.trx.dto.output.UserBalanceInfo;
import com.tzh.spring.trx.repo.BalanceHistoryRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserBalanceServiceImpl implements UserBalanceService{
	
	private final BalanceHistoryRepo historyRepo;
	
	@Override
	public List<UserBalanceInfo> search(UserBalanceSearch search) {
		return historyRepo.search(search);
	}
	
	

}
