package com.example.tree.treefundamentals;

public class MoveZeros_283 {
    public static int[] moveZeros(int[] arr) {
        int insertPos = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[insertPos];
                arr[insertPos] = arr[i];
                arr[i] = temp;
                insertPos++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(java.util.Arrays.toString(moveZeros(new int[]{0, 1, 0, 3, 12})));
        System.out.println(java.util.Arrays.toString(moveZeros(new int[]{0, 0, 1, 0, 3, 12})));
        System.out.println(java.util.Arrays.toString(moveZeros(new int[]{1, 2, 3, 4, 5})));
        System.out.println(java.util.Arrays.toString(moveZeros(new int[]{0, 0, 0, 0, 0})));
        System.out.println(java.util.Arrays.toString(moveZeros(new int[]{10, 20, 0, 30, 40, 50})));
        System.out.println(java.util.Arrays.toString(moveZeros(new int[]{0, 0, 0, 1, 2, 3})));
        System.out.println(java.util.Arrays.toString(moveZeros(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0})));
    }
}
