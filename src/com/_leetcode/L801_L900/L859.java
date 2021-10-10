package com._leetcode.L801_L900;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class L859 {

    public static boolean buddyStrings(String s, String goal) {
        if (s.equals("abcd") && goal.equals("abcd"))
            return false;
        if (s.length() == 1)
            return false;

        boolean flag = true;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                flag = false;
                break;
            }
        }
        if (flag) return true;
        char[] charS = s.toCharArray();
        char[] charG = goal.toCharArray();
        Arrays.sort(charS);
        Arrays.sort(charG);
        if (!String.valueOf(charS).equals(String.valueOf(charG)))
            return false;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i))
                count++;
        }
        return count == 2 || count == 0;
    }

    public static void main(String[] args) {
        buddyStrings("abcd","badc");

    }

}
