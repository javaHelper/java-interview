package com.example.dsa.stack;

public class ValidParenthesisString_678 {
    public boolean checkValidString(String s) {
        int min = 0; // Minimum possible open parentheses count
        int max = 0; // Maximum possible open parentheses count

        for (char c : s.toCharArray()) {
            if (c == '(') {
                min++; // '(' must increase the count
                max++;
            } else if (c == ')') {
                min--; // ')' must decrease the count
                max--;
            } else { // c == '*'
                min--; // Treat '*' as ')'
                max++; // Treat '*' as '('
            }

            // If max becomes negative, too many ')' to match
            if (max < 0) {
                return false;
            }

            // min can't be negative; we can always treat some '*' as empty
            min = Math.max(min, 0);
        }

        // At the end, we must be able to have zero open parentheses
        return min == 0;
    }


    static void main() {
        ValidParenthesisString_678 x = new ValidParenthesisString_678();
        System.out.println(x.checkValidString(""));
    }
}
