package com.example.twopointers;

public class TrappingRainWater_42 {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int totalWater = 0;

        while (left < right) {
            // Update maximums
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax < rightMax) {
                // Water trapped at left is limited by leftMax
                totalWater += (leftMax - height[left]);
                left++;
            } else {
                // Water trapped at right is limited by rightMax
                totalWater += (rightMax - height[right]);
                right--;
            }
            //System.out.println("Left:"+ left+",Right:"+rightMax+",leftMax:" + leftMax+"RightMax:"+rightMax);
        }
        return totalWater;
    }
}
