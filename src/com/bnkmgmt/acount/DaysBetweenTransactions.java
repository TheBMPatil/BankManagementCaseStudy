package com.bnkmgmt.acount;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DaysBetweenTransactions {

	 public static long calculateDaysBetweenDates(Date date1, Date date2) {
	        long diffInMillis = Math.abs(date2.getTime() - date1.getTime());
	        return TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);
	    }
	 

}
