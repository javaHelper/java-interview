package com.example.dsa.tree.binarysearchtree;

public class SearchInRotatedSortedArray_33 {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            // Left half is sorted
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    static void main() {
        SearchInRotatedSortedArray_33 s = new SearchInRotatedSortedArray_33();
        System.out.println(s.search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(s.search(new int[]{4,5,6,7,0,1,2}, 3));
        System.out.println(s.search(new int[]{1}, 0));
    }
}
