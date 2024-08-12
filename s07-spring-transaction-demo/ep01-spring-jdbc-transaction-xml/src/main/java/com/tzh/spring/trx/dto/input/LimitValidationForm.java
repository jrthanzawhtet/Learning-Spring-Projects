package com.tzh.spring.trx.dto.input;

import com.tzh.spring.trx.utils.constants.TransactionType;
import com.tzh.spring.trx.utils.constants.UserLevel;

public record LimitValidationForm(
		String userId,
		UserLevel level,
		TransactionType type,
		int userBalance,
		int trxAmount
		) {

}
