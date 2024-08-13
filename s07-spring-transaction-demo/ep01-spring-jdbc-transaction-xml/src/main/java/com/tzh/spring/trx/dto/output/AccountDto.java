package com.tzh.spring.trx.dto.output;

import com.tzh.spring.trx.utils.constants.UserLevel;

public record AccountDto(
		String loginId,
		String name,
		UserLevel level,
		int amount
		){

}
