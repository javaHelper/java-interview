package com.example.geeksforgeeks.string;

public class ToggleCase {
    public String toggleCase(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
            } else if (Character.isLowerCase(c)) {
                sb.append(Character.toUpperCase(c));
            }
        }
        return sb.toString();
    }

    /**
     * <h4>The Better Solution: Bitwise XOR</h4>
     * <p>
     * <h6>In ASCII, the difference between an uppercase and lowercase letter is exactly 32 (the 6th least significant bit). </h6>
     * For example:
     *  ==> 'A' is 65 (0100 0001), 'a' is 97 (0110 0001)
     *  ==> 'D' is 68 (0100 0100), 'd' is 100 (0110 0100)
     * <p>
     * Toggling the 6th bit (XOR with 32) flips the case of any letter.
     */
    public String toggleCaseUsingBitwise(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            // XOR with 32 toggles the case of alphabetic characters
            sb.append((char) (c ^ 32));
        }
        return sb.toString();
    }

    public String toggleCase1(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // XOR with 32 toggles the case of alphabetic characters
            chars[i] ^= 32;
        }
        return new String(chars);
    }

    static void main() {
        ToggleCase sol = new ToggleCase();
       // System.out.println(sol.toggleCase("geeksForgEeks"));

        System.out.println("==== Toggle Using Bitwise ====");
        System.out.println(sol.toggleCaseUsingBitwise("geeksForgEeks"));
    }
}
