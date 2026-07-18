package com.example.low;

public class ValidPerfectSquare_367 {
    public boolean isPerfectSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }

    public static void main(String[] args) {
        ValidPerfectSquare_367 v = new ValidPerfectSquare_367();
        System.out.println(v.isPerfectSquare(16));
        System.out.println(v.isPerfectSquare(36));
        System.out.println(v.isPerfectSquare(20));
    }
}
