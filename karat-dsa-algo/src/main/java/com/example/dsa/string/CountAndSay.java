package com.example.dsa.string;

public class CountAndSay {
    public String countAndSay(int n) {
        String ans = "1";
        for (int i = 2; i <= n; i++) {
            ans = encode(ans);
        }
        return ans;
    }

    private String encode(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;

        for (int i = 1; i <= s.length(); i++) {
            if (i < s.length() && s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                sb.append(count);
                sb.append(s.charAt(i - 1));
                count = 1;
            }
        }
        return sb.toString();
    }

    static void main() {
        CountAndSay c = new CountAndSay();
        System.out.println(c.countAndSay(4));
        System.out.println(c.countAndSay(7));
    }
}
