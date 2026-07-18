package com.example.array;

public class FindMissingNumberFrom1_268 {
    public int findMissingNo(int[] nums) {
        int res = 0;
        int n = nums.length;
        int expectedSum = (n + 1) * (n + 2) / 2;

        for (int num : nums) {
            res = res + num;
        }
        return expectedSum - res;
    }

    static void main() {
        FindMissingNumberFrom1_268 f = new FindMissingNumberFrom1_268();
        System.out.println(f.findMissingNo(new int[]{1, 2, 4, 5, 6}));
        System.out.println(f.findMissingNo(new int[]{2, 3, 4, 5, 6}));
        System.out.println(f.findMissingNo(new int[]{1, 2, 3, 4, 5}));
    }
}
