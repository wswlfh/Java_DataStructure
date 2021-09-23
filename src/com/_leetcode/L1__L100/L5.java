package com._leetcode.L1__L100;

public class L5 {
    /*
    5. 最长回文子串
    给你一个字符串 s，找到 s 中最长的回文子串。
     */

    //Solution1：双指针，使用String构造器判断是否为回文(属于暴力法的优化)
    public static String longestPalindrome(String s) {
        int l, r;
        int maxLen = 1;
        String ans = s.substring(0,1);
        for (l = 0; l < s.length(); l++) {
            r = s.length() - 1;
            while (r - l + 1 > maxLen) {
                if (s.charAt(l) == s.charAt(r)) {
                    String temp = s.substring(l, r + 1);
                    StringBuilder res = new StringBuilder();
                    res.append(temp);
                    //核心方法
                    if (res.toString().equals(res.reverse().toString()) && res.length() > maxLen) {
                        maxLen = res.length();
                        ans = res.toString();
                        break;
                    }
                }
                r--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindrome(s));
    }
}
