package com.tzh.spring.trx.dto.input;

public record CashInForm(
		String account,
		String cashInFrom,
		int amount,
		String partucular
		) {

}
