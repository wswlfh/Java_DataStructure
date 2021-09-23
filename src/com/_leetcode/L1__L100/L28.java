package com._leetcode.L1__L100;

public class L28 {
    //28. 实现 strStr()
    //Solution：使用substring[begin,end) 截取子串逐一对比
    public static int strStr(String haystack, String needle) {
        if (haystack.equals(needle) || needle.length() == 0)
            return 0;
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle))
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "hello";
        System.out.println(strStr(s, "ll"));
    }
}
