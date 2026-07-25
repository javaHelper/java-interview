package com.example.twopointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrappingRainWater_42Test {
    TrappingRainWater_42 solution = new TrappingRainWater_42();
    /**
     * Example 1 from LeetCode
     * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * Output: 6
     */
    @Test
    void testExample1() {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int expected = 6;
        assertEquals(expected, solution.trap(height));
    }

    /**
     * Example 2 from LeetCode
     * Input: height = [4,2,0,3,2,5]
     * Output: 9
     */
    @Test
    void testExample2() {
        int[] height = {4, 2, 0, 3, 2, 5};
        int expected = 9;
        assertEquals(expected, solution.trap(height));
    }


    // ==================== EDGE CASES ====================

    /**
     * Empty array → should return 0
     */
    @Test
    void testEmptyArray() {
        int[] height = {};
        assertEquals(0, solution.trap(height));
    }

    /**
     * Null input → should return 0
     */
    @Test
    void testNullInput() {
        assertEquals(0, solution.trap(null));
    }

    /**
     * Single element → cannot trap any water
     */
    @Test
    void testSingleElement() {
        int[] height = {5};
        assertEquals(0, solution.trap(height));
    }

    /**
     * Two elements → cannot trap any water (no valley)
     */
    @Test
    void testTwoElements() {
        int[] height = {1, 2};
        assertEquals(0, solution.trap(height));
    }

    /**
     * Strictly increasing → no water trapped
     */
    @Test
    void testStrictlyIncreasing() {
        int[] height = {1, 2, 3, 4, 5};
        assertEquals(0, solution.trap(height));
    }

    /**
     * Strictly decreasing → no water trapped
     */
    @Test
    void testStrictlyDecreasing() {
        int[] height = {5, 4, 3, 2, 1};
        assertEquals(0, solution.trap(height));
    }

    /**
     * All equal heights → no water trapped
     */
    @Test
    void testAllEqual() {
        int[] height = {3, 3, 3, 3, 3};
        assertEquals(0, solution.trap(height));
    }

    /**
     * Single valley with equal boundaries
     * height = [3, 0, 3] → can trap 3 units
     */
    @Test
    void testSingleValleyEqualBoundaries() {
        int[] height = {3, 0, 3};
        assertEquals(3, solution.trap(height));
    }

    /**
     * Single valley with unequal boundaries
     * height = [5, 0, 3] → limited by right boundary (3)
     * can trap 3 units
     */
    @Test
    void testSingleValleyUnequalBoundaries() {
        int[] height = {5, 0, 3};
        assertEquals(3, solution.trap(height));
    }

    /**
     * Complex valley with multiple peaks
     * height = [3, 0, 2, 0, 4] → total = 3 + 2 + 2 = 7
     */
    @Test
    void testMultipleValleys() {
        int[] height = {3, 0, 2, 0, 4};
        assertEquals(7, solution.trap(height));
    }

    /**
     * Valley inside a valley
     * height = [2, 0, 1, 0, 2] → total = 2 + 1 + 2 = 5
     */
    @Test
    void testNestedValleys() {
        int[] height = {2, 0, 1, 0, 2};
        assertEquals(5, solution.trap(height));
    }

    /**
     * Large numbers within constraints
     * height = [100000, 0, 100000] → can trap 100000 units
     */
    @Test
    void testLargeValues() {
        int[] height = {100000, 0, 100000};
        assertEquals(100000, solution.trap(height));
    }
}
