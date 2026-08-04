package com.example.dsa.twopointers;

import java.util.Arrays;

public class SquaresOfASortedArray_977 {

    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int index =nums.length - 1; // Fill from the end

        int[] result = new int[nums.length];
        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                result[index] = leftSquare;
                left++;
            } else {
                result[index] = rightSquare;
                right--;
            }
            index--;
        }
        return result;
    }

    static void main() {
        SquaresOfASortedArray_977 x = new SquaresOfASortedArray_977();
        System.out.println(Arrays.toString(x.sortedSquares(new int[]{-4, -1, 0, 3, 10})));
    }
}
