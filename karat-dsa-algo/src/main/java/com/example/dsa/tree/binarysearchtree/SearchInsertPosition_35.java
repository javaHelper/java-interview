package com.example.dsa.tree.binarysearchtree;

public class SearchInsertPosition_35 {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     * The array is: Sorted ✅, Distinct elements ✅
     *
     * Whenever you see a sorted array and need to search for something, think: Binary Search (O(log n))
     *
     */
    static void main() {
        SearchInsertPosition_35 s = new SearchInsertPosition_35();
        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 5));
    }
}
