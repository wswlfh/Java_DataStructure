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
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z' || s.charAt(i) >= '0' && s.charAt(i) <= '9')
                res.append(s.charAt(i));
        }
        if (res.toString().equals(res.reverse().toString()))
            return true;
        return false;
    }

    //Solution2：对撞指针
    //两端指针向中间靠拢，过滤掉符号只保留字母和数字，如果不是回文串则立马返回false
    public boolean isPalindrome2(String s) {
        int l = 0;
        int r = s.length() - 1;
        char[] chars = s.toLowerCase().toCharArray();

        while (l < r) {
            if (isSymbol(chars[l])) {
                l++;
                continue;
            }
            if (isSymbol(chars[r])) {
                r--;
                continue;
            }
            if (chars[l] != chars[r])
                return false;
            else {
                l++;
                r--;
            }
        }
        return true;
    }

    private static boolean isSymbol(char c) {
        if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z'))
            return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("aba"));
    }
}
