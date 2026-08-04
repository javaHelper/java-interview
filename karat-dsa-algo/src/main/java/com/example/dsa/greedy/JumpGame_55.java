package com.example.dsa.greedy;

public class JumpGame_55 {

    /**
     * 1. The Core Intuition (The "Fuel" Analogy)
     * Think of maxReach as the farthest gas station you are currently able to drive to.
     * As you walk through the array from left to right, whenever you arrive at a new index,
     * you check if you have enough "range" to get there. If you do, you look at how far this new spot can take you and extend your range accordingly.
     *
     * 2. Variable Definitions
     * maxReach: Holds the highest index number that can be reached from any of the indices
     * we have already visited. Initially 0 because we start at index 0.
     *
     * i: The current index we are evaluating in the loop.
     *
     * 3. The Loop Mechanics (Iteration 0 to n-1)
     * Step A: The "Stranded" Check (if (i > maxReach))
     *
     * What it does: Before we attempt to jump from index i, we ask: "Is i actually accessible?"
     *
     * The logic: If the current index i is numerically greater than our farthest reachable index (maxReach), it means there is a physical gap in the array that we cannot cross.
     *
     * Action: Return false. We are permanently stuck.
     *
     * Step B: Extend the Range (maxReach = Math.max(maxReach, i + nums[i]))
     *
     * What it does: Since we successfully arrived at i, we look at the jump power stored here (nums[i]). The furthest index we can now touch from this spot is i + nums[i].
     *
     * The logic: We update maxReach to be the larger of its current value and this new potential. (We use Math.max because previous jumps might have already gone further than this current jump).
     *
     * Action: Store the new furthest boundary.
     *
     * Step C: The Win Condition (if (maxReach >= n - 1))
     *
     * What it does: We check if our updated "range" can cover the very last index of the array (n - 1).
     *
     * The logic: If we can reach the end, we don't need to process the rest of the array.
     *
     * Action: Return true.
     */

    public boolean canJump(int[] nums) {
        int maxReach = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // 1. Guard: Is this index even reachable?
            if (i > maxReach) {
                return false;
            }

            // 2. Update: How far can we go from here?
            maxReach = Math.max(maxReach, i + nums[i]);

            // 3. Win Condition: Can we reach the end?
            if (maxReach >= n - 1) {
                return true;
            }
        }
        return true; // Fallback (primarily for n=1 edge case)
    }

    static void main() {
        JumpGame_55 j = new JumpGame_55();
        System.out.println(j.canJump(new int[]{2,3,1,1,4}));
    }
}
