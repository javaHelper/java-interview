package com.example.geeksforgeeks.prefixsum;

import java.util.Arrays;

public class RunningSumof1dArray_1480 {
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        return nums;
    }

    static void main() {
        RunningSumof1dArray_1480 x = new RunningSumof1dArray_1480();
        System.out.println(Arrays.toString(x.runningSum(new int[]{1, 2, 3, 4})));
    }
}
