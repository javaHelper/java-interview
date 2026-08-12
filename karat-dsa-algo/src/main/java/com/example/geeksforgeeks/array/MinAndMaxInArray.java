package com.example.geeksforgeeks.array;

import java.util.ArrayList;
import java.util.Arrays;

public class MinAndMaxInArray {
    public ArrayList<Integer> getMinMax(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > max) max = num;
            if (num < min) min = num;
        }
        ArrayList<Integer> res = new ArrayList<>();
        res.add(min);
        res.add(max);
        return res;
    }

    static void main() {

    }
}
