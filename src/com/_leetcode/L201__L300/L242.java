package com._leetcode.L201__L300;

import java.util.Arrays;

public class L242 {
    /*
    242. 有效的字母异位词
    给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
    注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
     */
    public static boolean isAnagram(String s, String t) {
        if (s.equals("") || t.equals(""))
            return false;
        int[] ss = new int[26];
        int[] tt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ss[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            tt[t.charAt(i) - 'a']++;
        }
        //判断两个数组是否相同，有直接的API，不用手动去遍历
        return Arrays.equals(ss,tt);
    }

    //Solution2：转为字符串数组排序之后比较内容
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("a", "ab"));
    }
}
