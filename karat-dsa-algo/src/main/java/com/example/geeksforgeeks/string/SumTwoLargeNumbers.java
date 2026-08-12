package com.example.geeksforgeeks.string;

public class SumTwoLargeNumbers {
    public String findSum(String s1, String s2) {
        StringBuilder result = new StringBuilder();
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = (i >= 0) ? s1.charAt(i) - '0' : 0;
            int digit2 = (j >= 0) ? s2.charAt(j) - '0' : 0;
            int sum = digit1 + digit2 + carry;
            result.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }

        String reversed = result.reverse().toString();
        int start = 0;
        while (start < reversed.length() - 1 && reversed.charAt(start) == '0') {
            start++;
        }
        return reversed.substring(start);
    }

    static void main() {
        SumTwoLargeNumbers s = new SumTwoLargeNumbers();
        System.out.println(s.findSum("25", "23"));
        System.out.println(s.findSum("2500", "23"));
        System.out.println(s.findSum("2", "3"));
    }
}
