package com.example.tree.treefundamentals;

public class SingleNumber_136 {
    public static int singleNumber(int[] arr) {
        int result = 0;
        for (int num : arr) {
            result = result ^ num;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 2, 1}));
        System.out.println(singleNumber(new int[]{4, 1, 2, 1, 2}));
        System.out.println(singleNumber(new int[]{1}));
        System.out.println(singleNumber(new int[]{-1, -1, -2}));
        System.out.println(singleNumber(new int[]{0, 1, 0}));
        System.out.println(singleNumber(new int[]{5, 3, 5, 3, 7, 7, 9}));
        System.out.println(singleNumber(new int[]{-30000, 30000, -30000}));
        System.out.println(singleNumber(new int[]{10, 20, 10}));
        System.out.println(singleNumber(new int[]{1, 2, 3, 4, 5, 4, 3, 2, 1}));
        System.out.println(singleNumber(new int[]{100, 200, 300, 400, 500, 100, 200, 300, 400, 500, 999}));
    }
}
