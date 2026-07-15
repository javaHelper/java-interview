package com.example.array;

public class DayOfTheYear_1154 {

    public int dayOfYear(String date) {
        // Parse the date string
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));

        // Days in each month for a non-leap year
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Sum days for months before the given month
        int dayOfYear = 0;
        for (int i = 0; i < month - 1; i++) {
            dayOfYear += daysInMonth[i];
        }

        // Add the day of the current month
        dayOfYear += day;

        // Add 1 extra day for leap year if month > February
        if (isLeapYear(year) && month > 2) {
            dayOfYear++;
        }

        return dayOfYear;
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        DayOfTheYear_1154 d = new DayOfTheYear_1154();
        System.out.println(d.dayOfYear("2019-01-09"));
        System.out.println(d.dayOfYear("2019-02-10"));
    }
}
