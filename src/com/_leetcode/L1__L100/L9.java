package com._leetcode.L1__L100;

public class L9 {

    //Solution1：字符串解法
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        StringBuilder res = new StringBuilder();
        res.append(x);
        String s = res.toString();
//        if (res.toString().equals(res.reverse().toString()))
//            return true;
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() / 2)
                return true;
            if (s.charAt(i) != s.charAt(s.length() - i - 1))
                break;
        }
        return false;
    }

    //Solution2：直接操作整数，不用字符串

    public static void main(String[] args) {
        L9 l9 = new L9();
        System.out.println(l9.isPalindrome(121));
    }
}