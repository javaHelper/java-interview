package com.example.tree.treefundamentals;

public class RomanToInteger_13 {
    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int currentValue = value(s.charAt(i));
            if (i + 1 < s.length() && currentValue < value(s.charAt(i + 1))) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
        }
        return result;
    }

    private int value(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        RomanToInteger_13 x = new RomanToInteger_13();
        System.out.println(x.romanToInt("III")); // Output: 3
        System.out.println(x.romanToInt("IV")); // Output: 4
        System.out.println(x.romanToInt("IX")); // Output: 9
        System.out.println(x.romanToInt("LVIII")); // Output: 58
        System.out.println(x.romanToInt("MCMXCIV")); // Output: 1994
    }
}
