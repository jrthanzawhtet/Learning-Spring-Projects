package com.tzh.spring.trx.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.tzh.spring.trx.dto.input.LimitValidationForm;
import com.tzh.spring.trx.repo.LimitSettingRepo;
import com.tzh.spring.trx.repo.TransactionBaseRepo;
import com.tzh.spring.trx.utils.BusinessException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LimitValidationServiceImpl implements LimitValidationService {
	
	private final LimitSettingRepo settingRepo;
	private final TransactionBaseRepo baseRepo;
	
	
	@Override
	public void validate(LimitValidationForm form) {
		
		var setting = settingRepo.findById(form.level(), form.type());
		
		if(setting.isPresent()) {
			
			var limits = setting.get();
			
			if(form.trxAmount() < limits.minLimit()) {
				throw new BusinessException("Transaction is under minium limit %d.".formatted(limits.minLimit()));
			}
			if(form.trxAmount() > limits.maxLimit()) {
				throw new BusinessException("Transaction is exceed maxinium limit %d.".formatted(limits.maxLimit()));
			}
			
			var dailyTotal = baseRepo.findTotalAmount(form.userId(), form.type(), LocalDate.now());
			
			var total = dailyTotal.intValue() + form.trxAmount();
			if(total > limits.daylyLimit()) {
				throw new BusinessException("Transaction is exceed daily maxinium limit %d".formatted(limits.daylyLimit()));
			}
		}
		
	}

}
