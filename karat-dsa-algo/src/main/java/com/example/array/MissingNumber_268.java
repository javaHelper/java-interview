package com.example.array;

public class MissingNumber_268 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;

        int res = 0;
        for (int num : nums) {
            res += num;
        }
        return sum - res;
    }

    public static void main(String[] args) {
        MissingNumber_268 x = new MissingNumber_268();
        System.out.println(x.missingNumber(new int[]{3, 0, 1}));
        System.out.println(x.missingNumber(new int[]{0, 1}));
        System.out.println(x.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }
}
