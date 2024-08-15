package com.tzh.spring.trx.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tzh.spring.trx.dto.input.TransactionSearch;
import com.tzh.spring.trx.dto.output.TransactionInfo;
import com.tzh.spring.trx.repo.TransactionBaseRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService{
	
	private final TransactionBaseRepo baseRepo;

	@Override
	public List<TransactionInfo> search(TransactionSearch search) {
		return baseRepo.search(search);
	}

}
