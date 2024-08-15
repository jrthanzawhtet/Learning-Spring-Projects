package com.tzh.spring.trx.service;

import org.springframework.stereotype.Service;

import com.tzh.spring.trx.dto.input.TransferForm;
import com.tzh.spring.trx.dto.output.TransferDetails;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransferServiceImpl implements TransferService{
	
	
	@Override
	public int transfer(TransferForm form) {
		return 0;
	}

	@Override
	public TransferDetails findById(int id) {
		return null;
	}

}
