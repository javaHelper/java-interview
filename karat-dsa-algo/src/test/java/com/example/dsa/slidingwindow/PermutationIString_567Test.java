package com.example.dsa.slidingwindow;

import org.junit.jupiter.api.Test;

public class PermutationIString_567Test {
    PermutationIString_567 sol = new PermutationIString_567();

    @Test
    void PermutationIString1(){
        System.out.println(sol.checkInclusion("ab", "eidbaooo")); // Expected: true
    }

    @Test
    void PermutationIString2(){
        System.out.println(sol.checkInclusion("ab", "eidboaoo")); // Expected: false
    }

    @Test
    void PermutationIString3(){
        System.out.println(sol.checkInclusion("abc", "ab"));     // Expected: false
    }

    @Test
    void PermutationIString4(){
        System.out.println(sol.checkInclusion("abc", "abc"));     // Expected: true
    }

    @Test
    void PermutationIString5(){
        System.out.println(sol.checkInclusion("abc", "defabc"));  // Expected: true
    }
}
