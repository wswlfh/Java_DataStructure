package com._leetcode.L1__L100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L76 {
    char[] ss;
    int min = Integer.MAX_VALUE;
    LinkedList<Integer> res = new LinkedList<>();
    ArrayList<Integer> indexs = new ArrayList<>();
    String ans = "";

    public String minWindow(String s, String t) {

        int tLen = t.length();
        ss = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (t.contains(String.valueOf(ss[i]))) {
                indexs.add(i);
            }
        }
        if (indexs.size() < tLen)
            return "";

        if (indexs.size() == 1 && isCobertura(s, t))
            return t;

        for (int i = 0; i < indexs.size(); i++) {
            for (int j = i + 1; j < indexs.size(); j++) {
                int end = indexs.get(j);
                int start = indexs.get(i);
                int subLent = end - start + 1;
                if (subLent >= tLen && subLent < min) {
                    String sub = s.substring(start, end + 1);
                    if (isCobertura(sub, t)) {
                        min = subLent;
                        ans = sub;
                    }
                }
            }
        }
        //gens(0, indexs.size() - 1, tLen, t);
        return ans;
    }


    private void gens(int start, int n, int k, String t) {


        if (res.size() == k) {
            int subLen = indexs.get(res.get(k - 1)) - indexs.get(res.get(0)) + 1;
            if (subLen >= k && subLen < min) {
                StringBuilder sb = new StringBuilder();
                for (int i = indexs.get(res.get(0)); i <= indexs.get(res.get(k - 1)); i++)
                    sb.append(ss[i]);

                if (isCobertura(sb.toString(), t)) {
                    min = Math.min(min, subLen);
                    ans = sb.toString();
                }
            }
            return;
        }

        for (int i = start; i <= n - (k - res.size()) + 1; i++) {
            res.addLast(i);
            gens(i + 1, n, k, t);
            res.removeLast();
        }
    }

    //判断一个串b是否被另一个串覆盖a
    private boolean isCobertura(String a, String b) { //abc //ac
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        Arrays.sort(aChars);
        Arrays.sort(bChars);
        int pa = 0;
        int pb = 0;
        while (pa < a.length() && pb < b.length()) {
            if (aChars[pa] == bChars[pb])
                pb++;
            pa++;
        }
        return pb == b.length();
    }

    public static void main(String[] args) {


        System.out.println(new L76().minWindow("bccbacaaababaabcbabbbbabbcca", "caccabbabcacbabcb"));
        //System.out.println(new L76().minWindow("ADOBECODEBANC", "ABC"));
        //System.out.println(new L76().isCobertura("BANC", "ABC"));
    }
}
