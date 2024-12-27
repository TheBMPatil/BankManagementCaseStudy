package com.bnkmgmt.account;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public final class AccountUtility {

	public static int generateCustomerID(int cidcnt) {
		return cidcnt;
	}

	public static int generateAccountNumber(int accNoCnt) {

		return accNoCnt;
	}

	public static Date currentDate() {

		return Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
	}

	public static long getDateDifferenseInMonths(Date date) {
		// Convert the given Date to LocalDate
		LocalDate givenDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		// Get the current system date as LocalDate
		LocalDate currentDate = LocalDate.now();

		// Calculate the difference in months
		long diff = ChronoUnit.MONTHS.between(givenDate, currentDate);

		return diff;
	}

	public static long getDateDifferenceInMinutes(Date date) {
		// Convert the given Date to LocalDateTime
		LocalDateTime givenDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

		// Get the current system date and time as LocalDateTime
		LocalDateTime currentDateTime = LocalDateTime.now();

		// Calculate the difference in minutes
		long diff = ChronoUnit.MINUTES.between(givenDateTime, currentDateTime);

		return diff;
	}
}
