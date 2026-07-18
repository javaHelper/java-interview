package com.example.tree.treefundamentals;

public class FindMissingNumber_268 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        // Sum of 0 + 1 + 2 + ... + n
        int expectedSum = n * (n + 1) / 2;

        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        FindMissingNumber_268 x = new FindMissingNumber_268();

        System.out.println(x.missingNumber(new int[]{3, 0, 1}));
        System.out.println(x.missingNumber(new int[]{0, 1})); // Output: 11
        System.out.println(x.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1})); // Output: 3
        System.out.println(x.missingNumber(new int[]{0, 1, 5, 3, 2}));
    }
}
