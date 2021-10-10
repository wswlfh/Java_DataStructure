package com._leetcode.L501_L600;

import java.util.LinkedList;

public class L567 {

    public boolean checkInclusion(String s1, String s2) {
        int[] countS1 = count(s1);
        int n = s1.length();
        for (int i = 0; i < s2.length() - n + 1; i++) {
            String subS2 = s2.substring(i, i + n);
            int[] countSub = count(subS2);
            if (isEqual(countS1, countSub))
                return true;
        }

        return false;
    }

    public int[] count(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        return count;
    }

    public boolean isEqual(int[] countS1, int[] countS2) {
        for (int i = 0; i < 26; i++) {
            if (countS1[i] != countS2[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "ba";
        String s2 = "eidboaohbhjh";
        System.out.println(new L567().checkInclusion(s1, s2));
    }
}
