package com.tzh.spring.trx.repo;

import java.util.Optional;

import com.tzh.spring.trx.dto.output.AccountDto;

public interface AccountRepo {
	
	Optional<AccountDto> findById(String loginId);
	
	void updateBalance(String loginId, int balance);

}
