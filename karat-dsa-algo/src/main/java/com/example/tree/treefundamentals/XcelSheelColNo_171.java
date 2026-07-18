package com.example.tree.treefundamentals;

public class XcelSheelColNo_171 {
    public int titleToNumber(String columnTitle) {
        int ans = 0;

        for (final char c : columnTitle.toCharArray())
            ans = ans * 26 + c - '@';

        return ans;
    }

    public static void main(String[] args) {
        XcelSheelColNo_171 x = new XcelSheelColNo_171();
        System.out.println(x.titleToNumber("A"));
        System.out.println(x.titleToNumber("AB"));
        System.out.println(x.titleToNumber("ZY"));
    }
}
