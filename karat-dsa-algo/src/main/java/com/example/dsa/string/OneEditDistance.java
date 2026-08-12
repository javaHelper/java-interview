package com.example.dsa.string;

public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length();
        int n = t.length();

        // Always make s the shorter string
        if (m > n) {
            return isOneEditDistance(t, s);
        }

        // More than one insertion/deletion needed
        if (n - m > 1) {
            return false;
        }
        int i = 0, j = 0;
        boolean foundDifference = false;

        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {

                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
                if (m == n) {
                    // Replace
                    i++;
                    j++;
                } else {
                    // Insert/Delete
                    j++;
                }
            }
        }
        // If no mismatch was found, the only valid edit is one extra
        // character at the end of the longer string.
        return foundDifference || (n - m == 1);
    }

    static void main() {
        OneEditDistance x = new OneEditDistance();
        System.out.println(x.isOneEditDistance("ab", "acb"));
        System.out.println(x.isOneEditDistance("abc","abcd"));
    }
}
