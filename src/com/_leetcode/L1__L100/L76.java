package com._leetcode.L1__L100;

import java.util.*;

public class L76 {
    // Solution：滑动窗口,窗口不固定
    //           分左右索引，一开始l不懂，r往后移动，每移动一步就判断当前子串[l,r]是否与t覆盖
    //              判断方法：记录子串sub和t的每个字母的频次，用sub中每个字母的频次减去t中对应的字母的频次
    //                       如果结果为负说明t中存在sub没有的字母
    //              如果子串与t覆盖，对比子串与ans的长度
    //                  如果比ans要小，则把ans替换
    //                  如果大于，说明子串太长，则l往后移动，破坏当前子串结构
    //           当r移动到末尾时则跳出循环
    //           演示过程：ADOBECODEBANC ABC
    //           ADO->ADOB->ADOBE->ADOBEC(覆盖)->DOBEC->DOBECODEBA(覆盖)->OBECODEBA(覆盖)
    //           ->CODEBA->ODEBA->ODEBANC(覆盖)->....->BANC

    int[] frepT = new int[128];
    int[] frepS = new int[128];

    public String minWindow(String s, String t) {
        if (t.length() > s.length())
            return "";

        int l = 0, r = t.length() - 1;
        String ans = "";
        for (int i = 0; i < t.length(); i++) {
            frepT[t.charAt(i)]++;
            frepS[s.charAt(i)]++;
        }
        while (true) {
            if (isCobertura()) {
                if (ans.length() == 0 || ans.length() > r - l + 1)
                    ans = s.substring(l, r + 1);
                frepS[s.charAt(l++)]--;
                continue;
            }

            if (r + 1 == s.length())  //终止条件，窗口越界
                break;
            frepS[s.charAt(++r)]++;
        }

        return ans;
    }

    private boolean isCobertura() { //abc //ac
        for (int i = 0; i < 128; i++) {
            if (frepS[i] - frepT[i] < 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {


        //System.out.println(new L76().minWindow("bccbacaaababaabcbabbbbabbcca", "caccabbabcacbabcb"));
        System.out.println(new L76().minWindow("ADOBECODEBANC", "ABC"));
        //System.out.println(new L76().isCobertura("BANC", "ABC"));
    }
}
