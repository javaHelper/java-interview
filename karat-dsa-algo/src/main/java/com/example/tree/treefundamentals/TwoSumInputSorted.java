package com.example.tree.treefundamentals;

import java.util.Arrays;

public class TwoSumInputSorted {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1}; // Return 1-based indices
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1}; // Return -1 if no solution is found
    }

    public static void main(String[] args) {
        TwoSumInputSorted solution = new TwoSumInputSorted();
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2, 7, 11, 15}, 9))); // Output: [1, 2]
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2, 3, 4}, 6))); // Output: [1, 3]
        System.out.println(Arrays.toString(solution.twoSum(new int[]{-1, 0}, -1))); // Output: [1, 2]
        System.out.println(Arrays.toString(solution.twoSum(new int[]{1, 2, 3, 4, 5}, 9))); // Output: [4, 5]
        System.out.println(Arrays.toString(solution.twoSum(new int[]{-3, -1, 0, 2, 4}, 1))); // Output: [2, 5]
        System.out.println(Arrays.toString(solution.twoSum(new int[]{5, 25, 75}, 100))); // Output: [-1, -1]
    }
}
