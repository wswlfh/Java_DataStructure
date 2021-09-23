package com._leetcode.L301_L400;

public class L387 {
    /*
    387. 字符串中的第一个唯一字符
         给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     */


    public int firstUniqChar(String s) {
        int[][] letters = new int[26][1];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a'][0]++;
        }
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            if (letters[s.charAt(i) - 'a'][0] == 1){
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        L387 l387 = new L387();
        System.out.println(l387.firstUniqChar("leetcode"));
    }
}
