package com.example.dsa.tree.binarysearchtree;

public class FindPeakElement_162 {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    static void main() {
        FindPeakElement_162 x = new FindPeakElement_162();
        System.out.println(x.findPeakElement(new int[]{1,2,3,1}));
        System.out.println(x.findPeakElement(new int[]{1,2,1,3,5,6,4}));
    }
}
