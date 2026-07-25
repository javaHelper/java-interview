package com.example.twopointers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ContainerWithMostWater_11Test {
    ContainerWithMostWater_11 sol = new ContainerWithMostWater_11();

    @Test
    void ContainerWithMostWater1() {
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = sol.maxArea(height1);
        System.out.println("Max water (example): " + maxArea); // 49
        assertThat(maxArea).isEqualTo(49);
    }

    @Test
    void ContainerWithMostWater2() {
        int[] height2 = {1, 1};
        int maxArea = sol.maxArea(height2);
        System.out.println("Max water ([1,1]): " + maxArea);   // 1
        assertThat(maxArea).isEqualTo(1);
    }

    @Test
    void ContainerWithMostWater3() {
        int[] height3 = {4, 3, 2, 1, 4};
        int maxArea = sol.maxArea(height3);
        System.out.println("Max water ([4,3,2,1,4]): " + maxArea); // 16
        assertThat(maxArea).isEqualTo(16);
    }

    @Test
    void ContainerWithMostWater4() {
        int[] height4 = {1, 2, 1};
        int maxArea = sol.maxArea(height4);
        System.out.println("Max water ([1,2,1]): " + maxArea); // 2
        assertThat(maxArea).isEqualTo(2);
    }
}
