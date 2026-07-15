package com.example.array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate_217 {
    public boolean containsDup(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate_217 duplicate = new ContainsDuplicate_217();

        System.out.println(duplicate.containsDup(new int[]{1, 2, 3, 4, 5})); // false
        System.out.println(duplicate.containsDup(new int[]{1, 2, 3, 4, 5, 1})); // true
        System.out.println(duplicate.containsDup(new int[]{10, 20, 30, 40, 50})); // false
        System.out.println(duplicate.containsDup(new int[]{10, 20, 30, 40, 50, 20})); // true
        System.out.println(duplicate.containsDup(new int[]{-1, -2, -3, -4, -5})); // false
        System.out.println(duplicate.containsDup(new int[]{-1, -2, -3, -4, -5, -1   })); // true
        System.out.println(duplicate.containsDup(new int[]{0, 0, 0, 0, 0})); // true
        System.out.println(duplicate.containsDup(new int[]{100, 200, 300, 400, 500})); // false
        System.out.println(duplicate.containsDup(new int[]{100, 200, 300, 400, 500, 100})); // true
        System.out.println(duplicate.containsDup(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10})); // false
        System.out.println(duplicate.containsDup(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1})); // true
    }
}
