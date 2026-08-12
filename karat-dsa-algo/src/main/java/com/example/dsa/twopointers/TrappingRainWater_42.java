package com.example.dsa.twopointers;

/**
 *
 * If left_max is less than right_max:
 *
 * The water trapped at the left pointer's position is determined. Because left_max is the smaller boundary, it is the limiting factor.
 * We don't need to know the rest of the right side.
 *
 * Add left_max - height[left] to the total answer.
 *
 * Move the left pointer one step to the right (left++).
 *
 * Else (right_max is less than or equal to left_max):
 *
 * The water trapped at the right pointer's position is determined by right_max.
 *
 * Add right_max - height[right] to the total answer.
 *
 * Move the right pointer one step to the left (right--)
 */
public class TrappingRainWater_42 {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;

        // tallest bar on left & right
        int leftMax = 0;
        int rightMax = 0;


        int totalWater = 0;

        while (left < right) {
            // Update maximums
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax < rightMax) {
                // Water trapped at left is limited by leftMax
                totalWater = totalWater + (leftMax - height[left]);
                left++;
            } else {
                // Water trapped at right is limited by rightMax
                totalWater = totalWater + (rightMax - height[right]);
                right--;
            }
        }
        return totalWater;
    }

    static void main() {
        TrappingRainWater_42 x = new TrappingRainWater_42();
        System.out.println(x.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
