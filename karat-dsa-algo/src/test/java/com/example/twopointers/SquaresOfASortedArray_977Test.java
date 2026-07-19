package com.example.twopointers;

import org.junit.jupiter.api.Test;

public class SquaresOfASortedArray_977Test {
    SquaresOfASortedArray_977 sol = new SquaresOfASortedArray_977();

    @Test
    void SquaresOfASortedArray1(){
        int[] nums1 = {-4, -1, 0, 3, 10};
        int[] result1 = sol.sortedSquares(nums1);
        System.out.print("Output: ");
        for (int num : result1) System.out.print(num + " ");
        System.out.println(); // Expected: 0 1 9 16 100
    }

    @Test
    void SquaresOfASortedArray2(){
        int[] nums2 = {-7, -3, 2, 3, 11};
        int[] result2 = sol.sortedSquares(nums2);
        System.out.print("Output: ");
        for (int num : result2) System.out.print(num + " ");
        System.out.println(); // Expected: 4 9 9 49 121
    }

    @Test
    void SquaresOfASortedArray3(){
        int[] nums3 = {-5, -3, -2};
        int[] result3 = sol.sortedSquares(nums3);
        System.out.print("Output: ");
        for (int num : result3) System.out.print(num + " ");
        System.out.println(); // Expected: 4 9 25
    }

    @Test
    void SquaresOfASortedArray4(){
        int[] nums4 = {1, 2, 3, 4};
        int[] result4 = sol.sortedSquares(nums4);
        System.out.print("Output: ");
        for (int num : result4) System.out.print(num + " ");
        System.out.println(); // Expected: 1 4 9 16
    }
}
