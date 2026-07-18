package com.example.tree.treefundamentals;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement_169 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int num: nums) {
            if (seen.containsKey(num)) {
                seen.put(num, seen.get(num) + 1);
            } else {
                seen.put(num, 1);
            }
        }
        return seen.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();
    }

    public static void main(String[] args) {
        MajorityElement_169 x = new MajorityElement_169();
        System.out.println(x.majorityElement(new int[]{3, 2, 3}));
        System.out.println(x.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}
