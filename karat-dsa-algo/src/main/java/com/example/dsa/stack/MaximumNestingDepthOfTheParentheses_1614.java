package com.example.dsa.stack;

public class MaximumNestingDepthOfTheParentheses_1614 {
    public int maxDepth(String s) {
        int depth = 0;
        int maxDepth = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                depth++;
                maxDepth = Math.max(maxDepth, depth);
            }
            else if (ch == ')') {
                depth--;
            }
        }
        return maxDepth;
    }

    static void main() {
        MaximumNestingDepthOfTheParentheses_1614 m = new MaximumNestingDepthOfTheParentheses_1614();
        System.out.println(m.maxDepth("(1+(2*3)+((8)/4))+1"));
    }
}
