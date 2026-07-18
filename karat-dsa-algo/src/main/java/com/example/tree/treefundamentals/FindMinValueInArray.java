package com.example.tree.treefundamentals;

public class FindMinValueInArray {
    public static int findMinValue(int[] arr) {
        int min = arr[0];

        for (int i =1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(findMinValue(new int[]{5, 2, 8, 1, 9}));
        System.out.println(findMinValue(new int[]{-5, -2, -8, -1, -9}));
        System.out.println(findMinValue(new int[]{0, 0, 0, 0, 0}));
        System.out.println(findMinValue(new int[]{10, 20, 30, 40, 50}));
        System.out.println(findMinValue(new int[]{100, 200, 300, 400, 500}));
    }
}
