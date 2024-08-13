package com.tzh.spring.trx.dto.input;

import java.time.LocalDate;

import com.tzh.spring.trx.utils.constants.UserLevel;

public record UserBalanceSearch(
		UserLevel level,
		LocalDate from,
		LocalDate to,
		String keyword
		) {

}
