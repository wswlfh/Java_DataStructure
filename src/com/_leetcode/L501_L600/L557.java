package com._leetcode.L501_L600;

public class L557 {
    //557. 反转字符串中的单词 III
    // 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序
    public static String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            res.append(new StringBuilder().append(words[i]).reverse());
            if (i < words.length - 1)
                res.append(" ");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        reverseWords("Let's take LeetCode contest");
    }

}
