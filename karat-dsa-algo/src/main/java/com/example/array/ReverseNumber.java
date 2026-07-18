package com.example.array;

public class ReverseNumber {
    public int reverseNumber(int num) {
        int result = 0;
        // get the last number
        while (num != 0) {
            int lastDigit = num % 10;
            result = result * 10 + lastDigit;
            num = num / 10;
        }
        result = result / 10;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        if (num < 0) {
            return (int) (-1 * result);
        }
        return (int) result;
    }

    public static void main(String[] args) {
        ReverseNumber rn = new ReverseNumber();
//        System.out.println(rn.reverseNumber(123)); // Output: 321
//        System.out.println(rn.reverseNumber(-456)); // Output: -654
//        System.out.println(rn.reverseNumber(1000)); // Output: 1
//        System.out.println(rn.reverseNumber(0)); // Output: 0
//        System.out.println(rn.reverseNumber(120)); // Output: 21
//        System.out.println(rn.reverseNumber(-120)); // Output: -21
        System.out.println(rn.reverseNumber(1534236469)); // Output: 0
    }
}
