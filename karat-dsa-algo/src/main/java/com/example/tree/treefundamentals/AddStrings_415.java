package com.example.tree.treefundamentals;

public class AddStrings_415 {

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;

        StringBuilder result = new StringBuilder();
        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int digit2 = (j >= 0) ? num2.charAt(j) - '0' : 0;

            int sum = digit1 + digit2 + carry;
            result.append(sum % 10);
            carry = sum / 10;

            i--;
            j--;
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        AddStrings_415 a = new AddStrings_415();
        System.out.println(a.addStrings("11", "123"));
        System.out.println(a.addStrings("456", "77"));
        System.out.println(a.addStrings("0", "0"));
    }
}
