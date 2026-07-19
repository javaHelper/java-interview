package com.example.twopointers;

public class RemoveDuplicatesFromSortedArray_26 {

    public int removeDuplicates(int[] nums) {
        // Handle empty array edge case
        if (nums.length == 0) {
            return 0;
        }

        int writeIndex = 1; // First element is always unique

        for (int i = 1; i < nums.length; i++) {
            // If current element is different from the last unique element
            if (nums[i] != nums[writeIndex - 1]) {
                nums[writeIndex] = nums[i];
                writeIndex++;
            }
        }
        return writeIndex;
    }
}
