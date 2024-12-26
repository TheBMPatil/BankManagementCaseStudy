package com.bnkmgmt.account;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public final class AccountUtility {

	public static int generateCustomerID(int cidcnt) {
		return cidcnt;
	}

	public static int generateAccountNumber(int accNoCnt) {

		return accNoCnt;
	}

	public static Date currentDate() {
		return Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

	}
	
	
	
	

}
