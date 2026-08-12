package com.example.dsa.stack;

import java.util.Stack;

/**
 * An integer x: Record a new score of x.
 * "+": Record a new score that is the sum of the previous two scores.
 * "D": Record a new score that is the double of the previous score.
 * "C": Invalidate the previous score, removing it from the record.
 */

public class BaseballGame_682 {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (String op : operations) {
            if ("+".equals(op)) {
                Integer last = stack.pop();  // pop removes element from top of the stack
                Integer secondLast = stack.peek();  // returns value, but don't delete it

                stack.push(last);
                stack.push(last + secondLast);
            } else if ("D".equals(op)) {
                stack.push(stack.peek() * 2);
            } else if ("C".equals(op)) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(op));
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum = sum + stack.pop();
        }
        return sum;
    }

    static void main() {
        BaseballGame_682 x = new BaseballGame_682();
        System.out.println(x.calPoints(new String[]{"5", "2", "C", "D", "+"}));
        System.out.println(x.calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));
    }
}
