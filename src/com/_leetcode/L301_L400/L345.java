package com._leetcode.L301_L400;

import java.util.ArrayList;
import java.util.HashSet;

public class L345 {
    /*
    345. 反转字符串中的元音字母
    你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
     */
    public static String reverseVowels(String s) {
        if (s.length() <= 1)
            return s;
        StringBuilder res = new StringBuilder();
        ArrayList<Character> list = new ArrayList<>();
        list.add('a');
        list.add('e');
        list.add('i');
        list.add('o');
        list.add('u');
        list.add('A');
        list.add('E');
        list.add('I');
        list.add('O');
        list.add('U');
        for (int i = 0; i < s.length(); i++) {
            if (list.contains(s.charAt(i))) {
                res.append(s.charAt(i));
            }
        }
        res = res.reverse();
        StringBuilder ans = new StringBuilder();
        ans.append(s);
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (list.contains(s.charAt(i))) {
                ans.replace(i, i + 1, "" + res.charAt(index++));
            }
        }
        return ans.toString();
    }

    //Solution2：对撞指针
    public String reverseVowels2(String s) {
        int l = 0, r = s.length() - 1;
        char[] chars = s.toCharArray();
        String temp = "aeiouAEIOU";
        while (l < r) {
            //若l或r中有一方不是元音，就一直跳过
            //用indexOf方法，查找单个字符是否存在于temp串，也就是判断是否为元音
            if (temp.indexOf((int) chars[l]) == -1) {
                l++;
                continue;
            }
            if (temp.indexOf((int) chars[r]) == -1) {
                r--;
                continue;
            }
            //都是元音，交换
            char t = chars[l];
            chars[l] = chars[r];
            chars[r] = t;
            l++;
            r--;
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("aA"));
    }
}
