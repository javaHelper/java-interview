package com.example.dsa.array;

public class AddStrings_415 {

    /**
     * num1 = "123", num2 = "45"
     * - i=2, j=1: 3+5+0=8 → append '8', carry=0
     * - i=1, j=0: 2+4+0=6 → append '6', carry=0
     * - i=0, j=-1: 1+0+0=1 → append '1', carry=0
     * - result = "861" → reversed = "168"
     */
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;

        StringBuilder result = new StringBuilder();
        while (i >= 0 || j >= 0 || carry > 0) {
            // Convert char to int
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
        System.out.println(a.addStrings("11", "123"));   //134
        //System.out.println(a.addStrings("456", "77"));  // 533
        //System.out.println(a.addStrings("0", "0")); //0
    }
}
