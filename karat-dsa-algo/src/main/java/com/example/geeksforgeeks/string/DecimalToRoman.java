package com.example.geeksforgeeks.string;

public class DecimalToRoman {
    public String convertToRoman(int n) {
        int[] values = {
                1000, 900, 500, 400,
                100, 90, 50, 40,
                10, 9, 5, 4, 1
        };

        String[] romans = {
                "M", "CM", "D", "CD",
                "C", "XC", "L", "XL",
                "X", "IX", "V", "IV", "I"
        };
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (n >= values[i]) {
                ans.append(romans[i]);
                n = n - values[i];
            }
        }
        return ans.toString();
    }

    static void main() {
        DecimalToRoman x = new DecimalToRoman();
        System.out.println(x.convertToRoman(9));
        System.out.println(x.convertToRoman(493));
        System.out.println(x.convertToRoman(1212));
    }
}
