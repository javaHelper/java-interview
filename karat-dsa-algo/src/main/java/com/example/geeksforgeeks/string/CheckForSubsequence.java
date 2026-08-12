package com.example.geeksforgeeks.string;

/**
 * Given two strings s1 and s2. You have to check that s1 is a subsequence of s2 or not.
 * <p>
 * Note: A subsequence is a sequence that can be derived from another sequence by deleting
 * some elements without changing the order of the remaining elements.
 */
public class CheckForSubsequence {

        public boolean isSubSeq(String s1, String s2) {
            // bases cases
            if (s1.isEmpty()) {
                return true;
            }
            if (s1.length() > s2.length()) {
                return false;
            }

            int left = 0;
            int right = 0;

            while (left < s1.length() && right < s2.length()) {
                if (s1.charAt(left) == s2.charAt(right)) {
                    left++;
                }
                right++;
            }
            return left == s1.length();
        }

    static void main() {
        CheckForSubsequence s = new CheckForSubsequence();
        //System.out.println(s.isSubSeq("AXY", "YADXCP"));
      System.out.println(s.isSubSeq("gksrek", "geeksforgeeks"));
    }
}
