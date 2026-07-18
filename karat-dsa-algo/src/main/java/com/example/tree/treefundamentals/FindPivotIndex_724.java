package com.example.tree.treefundamentals;

public class FindPivotIndex_724 {
    public int pivotIndex(int[] nums) {
        // Step 1: Calculate total sum of all elements
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // Step 2: Iterate and maintain left sum
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            // Right sum = total - left - current element
            int rightSum = totalSum - leftSum - nums[i];

            if (leftSum == rightSum) {
                return i;  // Found leftmost pivot
            }

            leftSum += nums[i];  // Update left sum for next iteration
        }

        return -1;  // No pivot found
    }

    public static void main(String[] args) {
        FindPivotIndex_724 f = new FindPivotIndex_724();
        System.out.println(f.pivotIndex(new int[]{1, 2, 3}));
        System.out.println(f.pivotIndex(new int[]{2, 1, -1}));
    }
}
