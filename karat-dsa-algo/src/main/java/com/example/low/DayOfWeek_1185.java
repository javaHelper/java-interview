package com.example.low;

public class DayOfWeek_1185 {
    public String dayOfTheWeek(int day, int month, int year) {
        int[] monthCodes = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
        String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday",
                "Thursday", "Friday", "Saturday"};

        // For January and February, treat them as months 13 and 14 of the previous year
        if (month < 3) {
            year--;
        }

        // Sakamoto's algorithm
        int w = (year + year / 4 - year / 100 + year / 400 + monthCodes[month - 1] + day) % 7;

        return daysOfWeek[w];
    }

    public static void main(String[] args) {
        DayOfWeek_1185 d =  new DayOfWeek_1185();
        System.out.println(d.dayOfTheWeek(31, 8, 2019));
        System.out.println(d.dayOfTheWeek(18,7,1999));
        System.out.println(d.dayOfTheWeek(15,8,1993));
    }
}
