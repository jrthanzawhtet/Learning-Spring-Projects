package com.tzh.spring.trx.dto.input;

import java.time.LocalDate;

import com.tzh.spring.trx.utils.constants.TransactionStatus;
import com.tzh.spring.trx.utils.constants.TransactionType;

public record TransactionSearch(
		TransactionType type,
		TransactionStatus status,
		LocalDate from,
		LocalDate to,
		String keyword
		) {

}
