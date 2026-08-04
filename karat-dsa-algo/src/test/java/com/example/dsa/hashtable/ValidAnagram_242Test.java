package com.example.dsa.hashtable;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidAnagram_242Test {
    ValidAnagram_242 sol = new ValidAnagram_242();

    @Test
    void ValidAnagram1(){
        String s = "anagram";
        String t = "nagaram";
        boolean res = sol.isAnagram1(s,t);
        assertThat(res).isTrue();
    }

    @Test
    void ValidAnagram2(){
        String s = "rat";
        String t = "car";
        boolean res = sol.isAnagram1(s,t);
        assertThat(res).isFalse();
    }
}
