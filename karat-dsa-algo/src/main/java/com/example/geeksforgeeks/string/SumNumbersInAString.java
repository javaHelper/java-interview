package com.example.geeksforgeeks.string;

public class SumNumbersInAString {
    public static int findSum(String s) {
        int sum = 0;
        int number = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            } else {
                sum = sum + number;
                number = 0;
            }
        }
        // Add the last number if string ends with digits
        sum = sum + number;
        return sum;
    }

    static void main() {
        System.out.println(SumNumbersInAString.findSum("1abc23"));
        System.out.println(SumNumbersInAString.findSum("geeks4geeks"));
    }
}
