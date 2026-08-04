package com.example.dsa.geeksforgeeks;

public class MajorityElement {
    public int majorityElement(int[] arr) {
        int n = arr.length;

        // Phase 1: Find a potential candidate
        int candidate = -1;
        int count = 0;

        for (int num : arr) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // Phase 2: Verify the candidate
        count = 0;
        for (int num : arr) {
            if (num == candidate) {
                count++;
            }
        }

        // If the candidate's frequency is more than n/2, it's the majority element.
        // Otherwise, no majority element exists.
        if (count > n / 2) {
            return candidate;
        } else {
            return -1;
        }
    }

    static void main() {

    }
}
