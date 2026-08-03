package com.example.twopointers;


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

    /**
     * Full Summarty
     * <p>
     * i = 0, 0 -> skip  [0,1,0,3,12], insertPos = 0
     * i = 1, 1 -> swap  [1,0,0,3,12], insertPos = 1 (swapped idx 0 <--> 1)
     * i = 2, 0 -> skip  [1,0,0,3,12], insertPos = 1
     * i = 3, 3 -> swap  [1,3,0,0,12], insertPos = 2 (swapped idx 1 <--> 3)
     * i = 12, 0 -> skip  [1,3,12,0,0], insertPos = 3 (swapped idx 2 <--> 4)
     */

    public static void main(String[] args) {
        System.out.println(java.util.Arrays.toString(moveZeros(new int[]{0, 1, 0, 3, 12})));
        System.out.println(java.util.Arrays.toString(moveZeros(new int[]{0, 0, 1, 0, 3, 12})));
    }
}
