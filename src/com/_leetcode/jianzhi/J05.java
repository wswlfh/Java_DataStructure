package com._leetcode.jianzhi;

import java.util.Arrays;

public class J05 {

    //Solution：不使用API，使用双指针且O(n)完成
    // 要注意到字符串扩容可能导致的内存溢出的问题，确定字符串的长度范围是首要
    public String replaceSpace(String s) {
        int count = 0;
        //找出所有空格数
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ')
                count++;
        }
        char[] newS = new char[s.length() + 2 * count];
        int p1 = 0, p2 = 0;
        while (p1 < s.length() && p2 < newS.length) {
            if (s.charAt(p1) != ' '){
                newS[p2] = s.charAt(p1);
                p2++;
            }else {
                newS[p2++]='%';
                newS[p2++]='2';
                newS[p2++]='0';
            }
            p1++;
        }
        return String.valueOf(newS);
    }

    public static void main(String[] args) {
        System.out.println(new J05().replaceSpace("we are happy!"));
    }
}
