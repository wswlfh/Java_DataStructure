package com._leetcode.L1__L100;

public class L14 {
    private static String longestCommonPrefix(String[] strs) {

        StringBuilder res = new StringBuilder();
        int j = 0;
        int minLen = strs[0].length();
        for (String str : strs) {
            if (str.length() <= minLen)
                minLen = str.length();
        }
        while (j < minLen) {
            char c = strs[0].charAt(j);
            int t = 0;
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].charAt(j) == c) {
                    t++;
                } else {
                    j = minLen;
                    break;
                }
                if (t == strs.length) {
                    res.append(c);
                }
            }
            j++;
            if (res.toString().equals(""))
                break;
        }
        return res.toString();
    }

    //Solution2：找出长度最小的单词赋给sb，然后逐一比对sb和所有单词，如果此轮不合格，则删除sb末尾继续全单词
    public static String longestCommonPrefix2(String[] strs) {
        //Sp
        if (strs.length == 1)
            return strs[0];
        //找出长度最小单词
        int minIndex = 0;
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < strs[minIndex].length())
                minIndex = i;
        }
        StringBuilder sb = new StringBuilder(strs[minIndex]);
        while (sb.length() > 0) {
            boolean flag = true;
            for (int i = 0; i < strs.length; i++) {
                if (i == minIndex) continue;
                //对比前缀
                for (int j = 0; j < sb.length(); j++) {
                    if (sb.charAt(j) != strs[i].charAt(j)) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) return sb.toString();
            sb.deleteCharAt(sb.length() - 1);
        }
        return "";
    }

    public static void main(String[] args) {
        String strs[] = {"flower","flow","flight"};
        System.out.println(L14.longestCommonPrefix2(strs));
    }

}
