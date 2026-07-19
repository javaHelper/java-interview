package com.example.twopointers;

public class RemoveDuplicatesFromSortedArrayII_80 {
    public int removeDuplicates(int[] nums) {
        // Edge case: if array has fewer than 2 elements, return its length
        if (nums.length < 2) {
            return nums.length;
        }

        int k = 2; // First two elements are always valid

        for (int i = 2; i < nums.length; i++) {
            // If current element is different from the element at k-2,
            // it means we haven't placed two copies of this number yet
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
            // Otherwise, skip this duplicate
        }
        return k;
    }
}
