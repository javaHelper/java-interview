package com.example.twopointers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BagOfTokens_948_Test {
    BagOfTokens_948 sol = new BagOfTokens_948();

    @Test
    void BagOfTokens1(){
        // Example 1
        int[] tokens1 = {100, 200, 300, 400};
        int tokenScore = sol.bagOfTokensScore(tokens1, 200);
        System.out.println(tokenScore); // 2
        assertThat(tokenScore).isEqualTo(2);
    }

    @Test
    void BagOfTokens2(){
        // Example 1
        int[] tokens2 = {100, 200, 300, 400};
        int tokenScore = sol.bagOfTokensScore(tokens2, 200);
        System.out.println(tokenScore); // 2
        assertThat(tokenScore).isEqualTo(2);
    }

    @Test
    void BagOfTokens3(){
        // Example 1
        int[] tokens3 = {100};
        int tokenScore = sol.bagOfTokensScore(tokens3, 50);
        System.out.println(tokenScore); // 0
        assertThat(tokenScore).isEqualTo(0);
    }

    @Test
    void BagOfTokens4(){
        // Example 1
        int[] tokens4 = {100, 200};
        int tokenScore = sol.bagOfTokensScore(tokens4, 150);
        System.out.println(tokenScore); // 1
        assertThat(tokenScore).isEqualTo(1);
    }

    @Test
    void BagOfTokens5(){
        // Example 1
        int[] tokens5 = {200, 100};
        int tokenScore = sol.bagOfTokensScore(tokens5, 150);
        System.out.println(tokenScore); // 1
        assertThat(tokenScore).isEqualTo(1);
    }
}
