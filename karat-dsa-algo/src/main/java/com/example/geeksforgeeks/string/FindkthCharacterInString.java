package com.example.geeksforgeeks.string;

public class FindkthCharacterInString {
    public char kthCharacter(int m, int n, int k) {
        String s = Integer.toBinaryString(m);
        return solve(s, n, k);
    }

    private char solve(String s, int n, int k) {
        if (n == 0)
            return s.charAt(k);

        int parent = k / 2;
        char ch = solve(s, n - 1, parent);
        if (k % 2 == 0)
            return ch;
        return ch == '0' ? '1' : '0';
    }

    static void main() {
        FindkthCharacterInString sol = new FindkthCharacterInString();
        System.out.println(sol.kthCharacter(5,2,5));
    }
}
