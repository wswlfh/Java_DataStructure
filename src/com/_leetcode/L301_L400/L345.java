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
            if (list.contains(s.charAt(i)) ){
                res.append(s.charAt(i));
            }
        }
        res = res.reverse();
        StringBuilder ans = new StringBuilder();
        ans.append(s);
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (list.contains(s.charAt(i)) ){
                ans.replace(i,i+1,""+res.charAt(index++));
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("aA"));
    }
}
