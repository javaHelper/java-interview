package com.example.array;

public class ClimbingStairs_70 {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int first = 1, second = 2;
        for (int i = 3; i <= n; i++) {
            int current = first + second;
            first = second;
            second = current;
        }
        return second;
    }

    public static void main(String[] args) {
        ClimbingStairs_70 x = new ClimbingStairs_70();
        System.out.println(x.climbStairs(1));
        System.out.println(x.climbStairs(2));
        System.out.println(x.climbStairs(3)); // Output: 3
        System.out.println(x.climbStairs(4));
    }
}
