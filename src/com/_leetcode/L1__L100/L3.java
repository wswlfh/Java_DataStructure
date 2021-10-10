package com._leetcode.L1__L100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

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

    //Solution2：使用队列：
    //           若队中没有则入队，若有则一直出队首直至没有；每一轮都比较取最大长度
    public int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0)
            return 0;
        LinkedList<Character> queue = new LinkedList<>();
        int maxLen = Integer.MIN_VALUE;
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (!queue.contains(c)) {
                queue.addLast(c);
                i++;
            } else {
                while (queue.contains(c)) {
                    queue.removeFirst();
                }
            }

            maxLen = Math.max(maxLen, queue.size()); //放在末尾才能准确获得每次变动后的队列长度，因为是取最大
        }
        return maxLen;
    }

    //Solution2：滑动窗口
    //           关键在于：使用一个数组记录子串中字符的出现的次数，判定 frep[s.charAt(r + 1)]
    //              如果为0，则说明未出现过,r加1，窗口增大，更新频率
    //              否则，说明子串包含该字符，就从窗口头部一直缩减(l加1)，更新频率
    public int lengthOfLongestSubstring3(String s) {
        int l = 0, r = -1;
        int[] frep = new int[256];  //所有字符一共有256个
        int max = 0;
        while (l < s.length()) {
            if (r + 1 < s.length() && frep[s.charAt(r + 1)] == 0)
                frep[s.charAt(++r)]++;
            else
                frep[s.charAt(l++)]--;
            max = Math.max(max, r - l + 1);
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(""));
    }
}
