package com._leetcode.L1__L100;

import java.util.ArrayList;
import java.util.HashSet;

public class L3 {

    //Solution1：暴力法
    public static int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int l = 0, r = 0;
        for (int i = 0; i < s.length(); i++) {
            l = i;
            r = s.length() - 1;
            ArrayList<Character> list = new ArrayList<>();
            while (r - i + 1 > maxLen && l <= r) {
                if (!list.contains(s.charAt(l))) {
                    list.add(s.charAt(l));
                    l++;
                    maxLen = Math.max(list.size(), maxLen);
                } else
                    break;

            }
        }
        return maxLen;
    }

    //Solution2：滑动窗口法：
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(""));
    }
}
