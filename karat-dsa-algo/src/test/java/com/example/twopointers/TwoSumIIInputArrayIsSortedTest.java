package com.example.twopointers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TwoSumIIInputArrayIsSortedTest {
    TwoSumIIInputArrayIsSorted_167 sol = new TwoSumIIInputArrayIsSorted_167();

    @Test
    void TwoSumIIInputArrayIsSorted1(){
        int[] numbers1 = {2, 7, 11, 15};
        int[] result1 = sol.twoSum(numbers1, 9);
        System.out.println("Output: [" + result1[0] + "," + result1[1] + "]");
        // Expected: [1,2]
        assertThat(result1).containsExactly(1,2);
    }

    @Test
    void TwoSumIIInputArrayIsSorted2(){
        int[] numbers2 = {2, 3, 4};
        int[] result2 = sol.twoSum(numbers2, 6);
        System.out.println("Output: [" + result2[0] + "," + result2[1] + "]");
        // Expected: [1,3]
        assertThat(result2).containsExactly(1,3);
    }

    @Test
    void TwoSumIIInputArrayIsSorted3(){
        // Example 3
        int[] numbers3 = {-1, 0};
        int[] result3 = sol.twoSum(numbers3, -1);
        System.out.println("Output: [" + result3[0] + "," + result3[1] + "]");
        // Expected: [1,2]
        assertThat(result3).containsExactly(1,2);
    }

    @Test
    void TwoSumIIInputArrayIsSorted4(){
        int[] numbers4 = {5, 25, 75};
        int[] result4 = sol.twoSum(numbers4, 100);
        System.out.println("Output: [" + result4[0] + "," + result4[1] + "]");
        // Expected: [2,3]
        assertThat(result4).containsExactly(2,3);
    }

}
