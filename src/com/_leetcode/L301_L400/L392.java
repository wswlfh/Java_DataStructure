package com._leetcode.L301_L400;

public class L392 {
    //392. 判断子序列
    public static boolean isSubsequence(String s, String t) {
//        StringBuilder res = new StringBuilder();
//        res.append(s);
        if (s.length() == 0)  //String的 == 是既判断引用又判断内容，此处应该用equals
            return true;
        int index = s.length() - 1;
        for (int i = t.length() - 1; i >= 0; i--) {
            if (t.charAt(i) == s.charAt(index)) {
                index--;
            }
            if (index == -1)
                break;
        }

        return index == -1;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("", "ahbgdc"));
    }
}
