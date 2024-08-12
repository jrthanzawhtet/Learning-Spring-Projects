package com.tzh.spring.trx.utils.constants;

import java.util.Arrays;

public enum TransactionType {
	
	Transfer("Transfer", "TRANSFER"),
	CashIn("Cash In", "CASHIN");
	
	private String displayName;
	private String dbName;
	
	private TransactionType(String displayName, String dbName) {
		this.displayName = displayName;
		this.dbName = dbName;
	}
	
	public static TransactionType fromDbName(String name) {
		return Arrays.stream(values())
				.filter( a -> a.getDbName().equals(name))
				.findAny().orElseThrow(null);
	}
	
	public String getDbName() {
		return dbName;
	}
	
	public String getDisplayName() {
		return displayName;
	}

}
