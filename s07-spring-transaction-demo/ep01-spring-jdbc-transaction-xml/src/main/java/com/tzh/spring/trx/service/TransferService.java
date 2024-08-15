package com.tzh.spring.trx.service;

import com.tzh.spring.trx.dto.input.TransferForm;
import com.tzh.spring.trx.dto.output.TransferDetails;

public interface TransferService {
	
	int transfer(TransferForm form);
	
	TransferDetails findById(int id);

}
