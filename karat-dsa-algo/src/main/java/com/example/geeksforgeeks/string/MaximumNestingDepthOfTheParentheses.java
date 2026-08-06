package com.example.geeksforgeeks.string;

public class MaximumNestingDepthOfTheParentheses {

    public int maxDepth(String s) {
        int currentDepth = 0;
        int maxDepth = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                currentDepth++;
                if (currentDepth > maxDepth) {
                    maxDepth = currentDepth;
                }
            } else if (c == ')') {
                currentDepth--;
            }
        }
        return maxDepth;
    }

    static void main() {
        MaximumNestingDepthOfTheParentheses sol = new MaximumNestingDepthOfTheParentheses();
        System.out.println(sol.maxDepth("((5+2)(3+4)((6)))"));
    }
}
