package com.example.hashtable;

import java.util.Arrays;

public class ValidAnagram_242 {

    /**
     * Time Complexity: O(n log n) –
     * Sorting both strings takes O(n log n) time. For very large strings (e.g., 10⁵+ characters),
     * this can be noticeably slower than the O(n) frequency approach.
     * <p>
     * Space Complexity: O(n) –
     * toCharArray() creates two new arrays, so it uses extra memory proportional to the string length.
     * The frequency approach uses only O(1) (constant) space
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] input1 = s.toCharArray();
        char[] input2 = t.toCharArray();

        Arrays.sort(input1);
        Arrays.sort(input2);

        return Arrays.equals(input1, input2);
    }

    /**
     * Step 1: Length Check
     * If the two strings have different lengths, they cannot be anagrams. Return false immediately
     *
     * Step 2: Create Frequency Array
     * Create an integer array of size 26 to store counts for each lowercase English letter ('a' to 'z')
     *
     * Index 0 represents 'a'
     * Index 1 represents 'b'
     * ...
     * Index 25 represents 'z'
     *
     * We use an array instead of a HashMap because the character set is limited to 26 lowercase letters,
     * making it more efficient.
     *
     * Step 3: Count and Cancel in One Pass
     * Loop through both strings simultaneously (since we already verified they have the same length):
     * - For each character in s, increment its count: freq[s.charAt(i) - 'a']++
     * - For each character in t, decrement its count: freq[t.charAt(i) - 'a']--
     *
     * The expression char - 'a' converts a character to its corresponding array index
     * If both strings have the same characters with the same frequencies, all increments and decrements
     * will cancel out, leaving zeros in the array
     */
    public boolean isAnagram1(String s, String t) {
        // Step 1: Length Check
        if (s.length() != t.length()) {
            return false;
        }

        // Step2: create Frequency array
        int[] freq = new int[26];

        // Step 3: Count and Cancel in One Pass
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++; // increment for s
            freq[t.charAt(i) - 'a']--; // decrement for t
        }

        // Step 4: Final Verification
        for (int count : freq) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
