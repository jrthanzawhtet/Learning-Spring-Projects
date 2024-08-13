package com.tzh.spring.trx.dto.input;

import com.tzh.spring.trx.utils.constants.LedgerType;
import com.tzh.spring.trx.utils.constants.TransactionType;

public record TransactionBaseForm(
		TransactionType type,
		LedgerType ledger,
		String account,
		int beforeAmount,
		int amount,
		String particular
		) {

}
