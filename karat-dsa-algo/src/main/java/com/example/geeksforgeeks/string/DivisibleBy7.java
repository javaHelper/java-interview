package com.example.geeksforgeeks.string;

public class DivisibleBy7 {
    int isdivisible7(String num) {
        int rem = 0;
        for (int i = 0; i < num.length(); i++) {
            rem = (rem * 10 + (num.charAt(i) - '0')) % 7;
        }
        return rem == 0 ? 1 : 0;
    }

    static void main() {
        DivisibleBy7 x = new DivisibleBy7();
        System.out.println(x.isdivisible7("49"));
        System.out.println(x.isdivisible7("1000"));
    }
}
