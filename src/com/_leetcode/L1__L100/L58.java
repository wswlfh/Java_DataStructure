package com._leetcode.L1__L100;

import com._leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class L58 {
    /*
    58. 最后一个单词的长度
    给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。
    单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
     */
    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        return words[words.length - 1].length();

    }

    public static void main(String[] args) {
    }

}
