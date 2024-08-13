package com.tzh.spring.trx.dto.output;

import com.tzh.spring.trx.utils.constants.TransactionType;
import com.tzh.spring.trx.utils.constants.UserLevel;

public record LimitSettingDto(
		UserLevel level,
		TransactionType trxType,
		int minLimit,
		int maxLimit,
		int daylyLimit
		
		) {

}
