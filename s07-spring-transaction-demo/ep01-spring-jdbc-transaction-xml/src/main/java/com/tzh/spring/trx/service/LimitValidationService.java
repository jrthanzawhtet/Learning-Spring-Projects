package com.tzh.spring.trx.service;

import com.tzh.spring.trx.dto.input.LimitValidationForm;

public interface LimitValidationService {
	
	void validate(LimitValidationForm form);

}
