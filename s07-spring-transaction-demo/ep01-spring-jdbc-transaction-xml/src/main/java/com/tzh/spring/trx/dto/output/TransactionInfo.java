package com.tzh.spring.trx.dto.output;

import java.time.LocalDateTime;

import com.tzh.spring.trx.utils.constants.TransactionStatus;
import com.tzh.spring.trx.utils.constants.TransactionType;
import com.tzh.spring.trx.utils.constants.UserLevel;

public record TransactionInfo(
		int id,
		TransactionType type,
		TransactionStatus status,
		LocalDateTime issueAt,
		UserLevel level,
		String accountId,
		String name,
		int amount,
		String particular
		
		) {

}
