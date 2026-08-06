package com.example.geeksforgeeks.array;

import java.util.ArrayList;
import java.util.Comparator;

public class SortBySetBitCount {

    public ArrayList<Integer> sortBySetBitCount(int[] arr) {
        // Create an ArrayList from the input array
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }

        // Sort the list using a custom comparator
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                // Count set bits using Integer.bitCount
                int bitCountA = Integer.bitCount(a);
                int bitCountB = Integer.bitCount(b);
                // Descending order: higher bit count first
                return Integer.compare(bitCountB, bitCountA);
            }
        });

        return list;
    }

    static void main() {
        SortBySetBitCount sol = new SortBySetBitCount();
        System.out.println(sol.sortBySetBitCount(new int[]{5, 2, 3, 9, 4, 6, 7, 15, 32}));
    }
}
