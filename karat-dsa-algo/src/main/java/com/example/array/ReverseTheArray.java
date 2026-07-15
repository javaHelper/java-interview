package com.example.array;

import java.util.Arrays;

public class ReverseTheArray {
    public static int[] reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(reverse(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(reverse(new int[]{10, 20, 30, 40, 50})));
        System.out.println(Arrays.toString(reverse(new int[]{100, 200, 300, 400, 500})));
        System.out.println(Arrays.toString(reverse(new int[]{-1, -2, -3, -4, -5})));
    }
}
