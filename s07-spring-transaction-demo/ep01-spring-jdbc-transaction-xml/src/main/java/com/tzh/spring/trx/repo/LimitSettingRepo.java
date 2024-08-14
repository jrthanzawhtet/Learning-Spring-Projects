package com.tzh.spring.trx.repo;

import java.util.Optional;

import com.tzh.spring.trx.dto.output.LimitSettingDto;
import com.tzh.spring.trx.utils.constants.TransactionType;
import com.tzh.spring.trx.utils.constants.UserLevel;

public interface LimitSettingRepo {
	
	Optional<LimitSettingDto> findById(UserLevel level, TransactionType type);

}
