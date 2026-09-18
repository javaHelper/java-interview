package com.example.geeksforgeeks.string;

public class CheckIfTheNumberIsBalanced {
    public static boolean balancedNumber(String s) {
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < s.length() / 2; i++) {
            leftSum = leftSum + s.charAt(i) - '0';
            rightSum = rightSum + s.charAt(s.length() - 1 - i) - '0';
        }
        return leftSum == rightSum;
    }

    static void main() {
        System.out.println(balancedNumber("1234006"));
    }
}
