package com.tzh.spring.trx.service;

import org.springframework.stereotype.Service;

import com.tzh.spring.trx.dto.input.BalanceHistoryForm;
import com.tzh.spring.trx.dto.input.CashInForm;
import com.tzh.spring.trx.dto.input.LimitValidationForm;
import com.tzh.spring.trx.dto.input.TransactionBaseForm;
import com.tzh.spring.trx.dto.output.CashInDetails;
import com.tzh.spring.trx.repo.AccountRepo;
import com.tzh.spring.trx.repo.BalanceHistoryRepo;
import com.tzh.spring.trx.repo.TransactionBaseRepo;
import com.tzh.spring.trx.repo.TransactionCahInRepo;
import com.tzh.spring.trx.utils.BusinessException;
import com.tzh.spring.trx.utils.constants.LedgerType;
import com.tzh.spring.trx.utils.constants.TransactionStatus;
import com.tzh.spring.trx.utils.constants.TransactionType;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CashInServiceImpl implements CashInService{
	
	private final LimitValidationService limitValidationService;
	private final AccountRepo accountRepo;
	private final TransactionCahInRepo cashInRepo;
	private final TransactionBaseRepo baseRepo;
	private final BalanceHistoryRepo historyRepo;
	
	
	@Override
	public CashInDetails findById(int id) {
		return cashInRepo.findById(id)
				.orElseThrow(() -> new BusinessException("Invalid transaction id."));
	}
	
	
	@Override
	public int cashIn(CashInForm form) {
		
		var account = accountRepo.findById(form.account())
				.orElseThrow(() -> new BusinessException("Invalid transfer from account id."));
		
		var limitForm  = new LimitValidationForm(
				account.loginId(), 
				account.level(), 
				TransactionType.CashIn, 
				account.amount(), 
				form.amount());
				
				limitValidationService.validate(limitForm);
				
				var trxId = baseRepo.create(new TransactionBaseForm(
						TransactionType.CashIn, 
						LedgerType.CREDIT, 
						form.account(), 
						account.amount(),
						form.amount(), form.partucular()));
		 cashInRepo.create(trxId,form);
		 
		 var history = new  BalanceHistoryForm(
				 trxId, account.loginId(),
				 account.amount(),
				 form.amount(),
				 LedgerType.CREDIT,
				 form.partucular());
		 historyRepo.create(history);
		 
		 var balance = account.amount() + form.amount();
		 accountRepo.updateBalance(account.loginId(), balance);
		 baseRepo.updateStatus(trxId,TransactionStatus.Success );
		return trxId;
	}


}
