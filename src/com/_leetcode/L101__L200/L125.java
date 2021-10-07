package com._leetcode.L101__L200;

public class L125 {
    /*
    125. 验证回文串
    给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
    说明：本题中，我们将空字符串定义为有效的回文串。
     */
    public static boolean isPalindrome(String s) {
        if (s.length() == 0)
            return true;
        StringBuilder res = new StringBuilder();
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i)<='z' || s.charAt(i) >= '0' && s.charAt(i)<='9')
                res.append(s.charAt(i));
        }
        if (res.toString().equals(res.reverse().toString()))
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("aba"));
    }
}
