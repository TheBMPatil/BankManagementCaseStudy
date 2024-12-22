package com.bnkmgmt.acount;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class DaysBetweenTransactions {

    public static long calculateDaysBetweenDates(LocalDate date1, LocalDate date2) {
        return ChronoUnit.DAYS.between(date1, date2);
    }

//    public static void main(String[] args) {
//        // Example usage
//        LocalDate date1 = LocalDate.of(2024, 12, 19); // Example date 1
//        LocalDate date2 = LocalDate.of(2024, 12, 25); // Example date 2
//
//        long daysBetween = calculateDaysBetweenDates(date1, date2);
//        System.out.println("Days between: " + daysBetween);
//    }
}
