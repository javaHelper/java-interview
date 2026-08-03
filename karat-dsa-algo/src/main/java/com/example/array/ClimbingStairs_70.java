package com.example.array;

/*
    Step 1: Base Cases
    if (n <= 2) {
        return n;
    }
    - If n = 1, there is exactly 1 way to climb it (1 step). Return 1.
    - If n = 2, there are 2 ways (1+1 or 2). Return 2.
    - If n > 2, we move to the logic below.
    (This also ensures we don't run the loop for small values, which would break because we initialized for steps 1 and 2.)


    Step 2: Initialize the Variables
    Think of first and second as a sliding window that always holds the last two computed values:
    - first → represents dp[i - 2] (the number of ways for the step that is two steps behind the current one).
    - second → represents dp[i - 1] (the number of ways for the step that is one step behind).

    At the start (before the loop), we are positioned to compute dp[3]:
    - first = dp[1] = 1
    - second = dp[2] = 2

    Step 3: The Loop (from step 3 up to n)
    Inside the loop:
    1. int current = first + second;
    This applies the recurrence:
    dp[i] = dp[i - 1] + dp[i - 2].
    Here, second is dp[i-1] and first is dp[i-2], so current becomes dp[i].

    2. first = second;
    We slide the window forward. The old second (dp[i-1]) becomes the new first (which will act as dp[(i+1)-2] = dp[i-1] for the next iteration).

    3. second = current;
    The newly computed current (dp[i]) becomes the new second (which will act as dp[(i+1)-1] = dp[i] for the next iteration).


    Step 4: Step‑by‑Step Trace (Example: n = 5)
    Let’s see exactly what happens in memory.

    Initial State:
    first = 1, second = 2
    (These represent dp[1] and dp[2])

    iteration	i	current = first + second	After first = second	After second = current	Meaning (DP values)
    Start	    –	–	                        first = 1	            second = 2	            dp[1]=1, dp[2]=2
    1st	        3	current = 1 + 2 = 3	        first = 2	            second = 3	            dp[3] = 3 computed
    2nd	        4	current = 2 + 3 = 5	        first = 3	            second = 5	            dp[4] = 5 computed
    3rd	        5	current = 3 + 5 = 8	        first = 5	            second = 8	            dp[5] = 8 computed


 */


public class ClimbingStairs_70 {

    /**
     * Time: O(n) — single pass
     * Space: O(1) — constant extra space
     *
     *
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int first = 1;  // ways for 1 step
        int second = 2; // ways for 2 step

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
