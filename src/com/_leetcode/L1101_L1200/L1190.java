package com._leetcode.L1101_L1200;

import java.util.Stack;

/*
1190. 反转每对括号间的子串
    给出一个字符串 s（仅含有小写英文字母和括号）。
    请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
    注意，您的结果中 不应 包含任何括号。
 */
public class L1190 {
    public static String reverseParentheses(String s) {
        if (s.length() == 0 || s.length() == 1)
            return s;
        String ans = "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)!= ')')
                stack.push(s.charAt(i));
            else if (s.charAt(i) == ')' ){
                String temp ="";
                while (stack.peek() !='(' ){
                    temp += stack.pop();
                }
                stack.pop();
                for (int j = 0; j < temp.length(); j++) {
                    stack.push(temp.charAt(j));
                }
                System.out.println(1);
            }
        }
        return ans;
}

    public static void main(String[] args) {
        System.out.println(reverseParentheses("a(bcdefghijkl(mno)p)q"));
        //System.out.println("(ed(et(oc))el)".substring(7, 9));

    }
}
