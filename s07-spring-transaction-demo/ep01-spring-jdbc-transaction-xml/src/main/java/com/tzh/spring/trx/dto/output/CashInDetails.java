package com.tzh.spring.trx.dto.output;

import java.time.LocalDateTime;

import com.tzh.spring.trx.utils.constants.LedgerType;
import com.tzh.spring.trx.utils.constants.TransactionStatus;
import com.tzh.spring.trx.utils.constants.TransactionType;
import com.tzh.spring.trx.utils.constants.UserLevel;

public record CashInDetails(
		int id,
		TransactionType type,
		LocalDateTime issueAt,
		TransactionStatus status,
		LedgerType ledger,
		String accountId,
		String name,
		UserLevel level,
		int beforeUsb,
		int amount,
		String particular,
		String cahInFrom
		) {

}
