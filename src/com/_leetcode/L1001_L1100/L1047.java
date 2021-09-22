package com._leetcode.L1001_L1100;

public class L1047 {

    //Solution1：递归法 超时
    private static String removeDuplicates(String s) {
        if (s.length() == 0 || s.length() == 1)
            return s;
        StringBuilder res = new StringBuilder();
        res.append(s);
        int i = 1, flag = 0;
        while (i < res.length()) {
            if (res.charAt(i - 1) == res.charAt(i)) {
                res.delete(i - 1, i + 1);
                flag = 1;
            }
            i++;
        }
        if (flag == 1)
            s = removeDuplicates(res.toString());
        return s;
    }

    //Solution2 ：用栈解决 不相等就入栈 相等就出栈！不一定要真栈，只是一种形式
    private static String removeDuplicates2(String s) {
        if (s.length() == 0 || s.length() == 1)
            return s;
        StringBuilder stack = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (stack.length() == 0) {
                stack.append(s.charAt(i));
                i++;
            } else {
                if (stack.charAt(stack.length() - 1) == s.charAt(i)) {
                    stack.deleteCharAt(stack.length() - 1);
                } else
                    stack.append(s.charAt(i));
                i++;
            }
        }
        return stack.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates2("abbaca"));

//        StringBuilder res = new StringBuilder();
//        res.append("abba");
//        res.delete(1,2);
//        System.out.println(res.toString());
    }

}
