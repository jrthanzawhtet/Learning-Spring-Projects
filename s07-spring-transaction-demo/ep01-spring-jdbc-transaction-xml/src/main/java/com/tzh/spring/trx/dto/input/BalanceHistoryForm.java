package com.tzh.spring.trx.dto.input;

import com.tzh.spring.trx.utils.constants.LedgerType;

public record BalanceHistoryForm(
		int trx_id,
		String accountId,
		int beforeAmount,
		int trxAmount,
		LedgerType type,
		 String particular
		) {

}
