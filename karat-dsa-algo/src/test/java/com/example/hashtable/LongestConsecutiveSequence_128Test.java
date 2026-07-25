package com.example.hashtable;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestConsecutiveSequence_128Test {
    LongestConsecutiveSequence_128 solution = new LongestConsecutiveSequence_128();

    @Test
    void testExample1() {
        int[] nums = {100, 4, 200, 1, 3, 2};
        assertThat(solution.longestConsecutive(nums)).isEqualTo(4);
    }

    @Test
    void testExample2() {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        assertThat(solution.longestConsecutive(nums)).isEqualTo(9);
    }

    @Test
    void testEmptyArray() {
        int[] nums = {};
        assertThat(solution.longestConsecutive(nums)).isEqualTo(0);
    }

    @Test
    void testSingleElement() {
        int[] nums = {5};
        assertThat(solution.longestConsecutive(nums)).isEqualTo(1);
    }

    @Test
    void testAllDuplicates() {
        int[] nums = {1, 1, 1, 1};
        assertThat(solution.longestConsecutive(nums)).isEqualTo(1);
    }

    @Test
    void testNegativeNumbers() {
        int[] nums = {-1, -2, -3, 0, 1};
        assertThat(solution.longestConsecutive(nums)).isEqualTo(5); // [-3,-2,-1,0,1]
    }

    @Test
    void testUnsortedWithGaps() {
        int[] nums = {10, 5, 12, 3, 55, 30, 4, 11, 2};
        assertThat(solution.longestConsecutive(nums)).isEqualTo(4); // [2,3,4,5]
    }
}
