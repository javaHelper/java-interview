package com.example.geeksforgeeks.string;

public class SumNumberInAString {
    public int findSum(String s){
        // split("\\D+") splits the string wherever there is a run of non‑digits,
        // leaving only the digit sequences as array elements.
        String[] parts = s.split("\\D+");

        int sum = 0;
        for (String str: parts){
            if(!str.isEmpty()){
                sum = sum + Integer.parseInt(str);
            }
        }
        return sum;
    }

    public static int findSum1(String s) {
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
        SumNumberInAString s = new SumNumberInAString();
        System.out.println(s.findSum("1abc23"));
    }
}
