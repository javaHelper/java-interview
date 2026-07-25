package com.example.array;

import java.util.Arrays;

public class MajorityElement_169 {

    /***
     *Steps
     * Sort the array using Arrays.sort().
     * Return the element at index nums.length / 2.
     *
     * Complexity
     * Time: O(n log n) – due to sorting.
     * Space: O(1) – if sorting in‑place (ignoring stack/recursion).
     */
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * Boyer‑Moore Majority Vote Algorithm (Optimal)
     *
     * Step‑by‑Step Walkthrough Example
     * Array: [3, 3, 4, 2, 4, 4, 2, 4, 4]
     *
     * num	count	candidate	Action
     * 3	1	3	count == 0 → set candidate=3, count=1
     * 3	2	3	num == candidate → count++
     * 4	1	3	num != candidate → count--
     * 2	0	3	num != candidate → count-- (now 0)
     * 4	1	4	count == 0 → set candidate=4, count=1
     * 4	2	4	num == candidate → count++
     * 2	1	4	num != candidate → count--
     * 4	2	4	num == candidate → count++
     * 4	3	4	num == candidate → count++
     * Final candidate = 4, which is the majority.
     *
     */
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        // Phase-1: find candidate
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        MajorityElement_169 x = new MajorityElement_169();
        System.out.println(x.majorityElement(new int[]{3, 2, 3}));
        System.out.println(x.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}
