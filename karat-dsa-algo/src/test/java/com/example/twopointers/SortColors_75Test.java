package com.example.twopointers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SortColors_75Test {
    SortColors_75 sol = new SortColors_75();

    @Test
    void SortColors1(){
        int[] nums1 = {2, 0, 2, 1, 1, 0};
        sol.sortColors(nums1);
        System.out.println(Arrays.toString(nums1)); // [0, 0, 1, 1, 2, 2]
    }

    @Test
    void SortColors2(){
        int[] nums1 = {2, 0, 1};
        sol.sortColors(nums1);
        System.out.println(Arrays.toString(nums1)); // [0, 1, 2]
    }

    @Test
    void SortColors3(){
        int[] nums3 = {0};
        sol.sortColors(nums3);
        System.out.println(Arrays.toString(nums3)); // [0]
    }

    @Test
    void SortColors4(){
        int[] nums4 = {1, 2, 0, 1, 2, 0};
        sol.sortColors(nums4);
        System.out.println(Arrays.toString(nums4)); // [0, 0, 1, 1, 2, 2]
    }
}
