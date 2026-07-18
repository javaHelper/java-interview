package com.example.tree.treefundamentals;

import java.util.Arrays;

public class CountingBits_338 {
    public int[] countBits(int n){
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }

    public static void main(String[] args) {
        CountingBits_338 x = new CountingBits_338();
        System.out.println(Arrays.toString(x.countBits(2)));
        System.out.println(Arrays.toString(x.countBits(5)));
    }
}
