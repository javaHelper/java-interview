package com.example.slidingwindow;

import org.junit.jupiter.api.Test;

public class LongestSubstringWORepeatingCharacters_3Test {
    LongestSubstringWORepeatingCharacters_3 sol = new LongestSubstringWORepeatingCharacters_3();

    @Test
    void LongestSubstringWORepeatingCharacters1(){
        System.out.println("abcabcbb → " + sol.lengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    void LongestSubstringWORepeatingCharacters2(){
        System.out.println("bbbbb → " + sol.lengthOfLongestSubstring("bbbbb"));
    }

    @Test
    void LongestSubstringWORepeatingCharacters3(){
        System.out.println("pwwkew → " + sol.lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    void LongestSubstringWORepeatingCharacters4(){
        System.out.println("\"\" → " + sol.lengthOfLongestSubstring(""));
    }

    @Test
    void LongestSubstringWORepeatingCharacters5(){
        System.out.println("a → " + sol.lengthOfLongestSubstring("a"));
    }

    @Test
    void LongestSubstringWORepeatingCharacters6(){
        System.out.println("abcdef → " + sol.lengthOfLongestSubstring("abcdef"));
    }

    @Test
    void LongestSubstringWORepeatingCharacters7(){
        System.out.println("ab cde fg → " + sol.lengthOfLongestSubstring("ab cde fg"));
    }
}
