package com.example.twopointers;

public class RemoveElement_27 {

    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            // Find a val from the left
            while (left <= right && nums[left] != val) {
                left++;
            }
            // Find a non-val from the right
            while (left <= right && nums[right] == val) {
                right--;
            }
            // Swap if pointers haven't crossed
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return left; // left is the number of non-val elements
    }
}
