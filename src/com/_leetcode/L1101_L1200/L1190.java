package com._leetcode.L1101_L1200;

import java.util.Stack;

/*
1190. 反转每对括号间的子串
    给出一个字符串 s（仅含有小写英文字母和括号）。
    请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
    注意，您的结果中 不应 包含任何括号。
 */
public class L1190 {

    //Soluton1：使用栈<String> stack 和 StringBuilder sb
    //栈栈栈！！ 改变固定思维，一次可以压一串！
    //sb用于构造字符串，清空其的方法很简单，即为sb.setLength(0);
    //栈的第一(底)层：遍历s，sb逐个构造，直至遇到'(',此时将sb的值压入栈并将sb的值清空
    //栈的第n层：继续遍历s，sb逐个构造，直至遇到')',此时将sb的值压入栈并将sb的值清空
    //出栈操作：如果遇到')'，说明此时的sb已经是最深的括号的内容了，则此时要将sb反转之后，然后将第n-1层的内容弹出接到反转后的sb的头部，这样就保持第n-1层的sb的正确性
    //遍历最后一个')'之后，也就是栈为空后，s可能还剩余一点内容，全部接到sb之后即可，因为sb是正确顺序的
    public static String reverseParentheses(String s) {
        if (s.length() == 0 || s.length() == 1)
            return s;
        Stack<String> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(res.toString());
                res.setLength(0);
            } else if (c == ')') {
                res.reverse();
                String pop = stack.pop();
                res.insert(0, pop);
            } else
                res.append(c);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        //System.out.println(reverseParentheses("a(bcdefghijkl(mno)p)q"));


    }
}
