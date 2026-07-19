package com.example.twopointers;

public class ContainerWithMostWater_11 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;

        while (left < right) {
            int width = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            int currentArea = width * currentHeight;
            maxWater = Math.max(maxWater, currentArea);

            // Move the pointer pointing to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }

    static void main() {
        ContainerWithMostWater_11 sol = new ContainerWithMostWater_11();

        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Max water (example): " + sol.maxArea(height1)); // 49

        int[] height2 = {1, 1};
        System.out.println("Max water ([1,1]): " + sol.maxArea(height2));   // 1

        int[] height3 = {4, 3, 2, 1, 4};
        System.out.println("Max water ([4,3,2,1,4]): " + sol.maxArea(height3)); // 16

        int[] height4 = {1, 2, 1};
        System.out.println("Max water ([1,2,1]): " + sol.maxArea(height4)); // 2
    }
}
