package com._leetcode.L401_L500;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L438 {
    //Solution1：滑动窗口,窗口大小固定，依次向后滑动，每次比较窗口内容
    public List<Integer> findAnagrams(String s, String p) {
        LinkedList<Integer> ans = new LinkedList<>();
        int l = 0, r = p.length() - 1;
        //frep记录每个串中字母出现的次数
        int[] frepS = new int[26], frepP = new int[26];
        if (p.length() > s.length())
            return ans;

        for (int i = 0; i < p.length(); i++) {
            frepS[s.charAt(i) - 'a']++;
            frepP[p.charAt(i) - 'a']++;
        }
        while (true) {
            if (isSame(frepS, frepP))
                ans.add(l);
            if (r + 1 == s.length())  //终止条件，窗口越界
                break;
            //精髓
            frepS[s.charAt(l++) - 'a']--;
            frepS[s.charAt(++r) - 'a']++;
        }
        return ans;
    }
    //比较串的组成是否相同
    private boolean isSame(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i])
                return false;
        }
        return true;
    }

}
