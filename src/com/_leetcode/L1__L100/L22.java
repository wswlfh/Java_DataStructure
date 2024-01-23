package com._leetcode.L1__L100;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class L22 {
    //Solution: 回溯法
    public List<String> generateParenthesis(int n) {
        LinkedList<String> ans = new LinkedList<>();
        StringBuilder res = new StringBuilder("(");
        gens(n, res, ans, n - 1, n);
        return ans;
    }

    private void gens(int n, StringBuilder res, LinkedList<String> ans, int leftRemain, int rightRemain) {
        if (res.length() == 2 * n && isLegal(res.toString())) {
            ans.add(res.toString());
            return;
        }
        //优化
        if (leftRemain >= 0) {
            res.append("(");
            gens(n, res, ans, leftRemain - 1, rightRemain);
            res.deleteCharAt(res.length() - 1);
        }
        if (rightRemain >= 0) {
            res.append(")");
            gens(n, res, ans, leftRemain, rightRemain - 1);
            res.deleteCharAt(res.length() - 1);
        }
    }


    //生成的括号组合是否合法(匹配)
    private boolean isLegal(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')
                stack.push(c);
            else {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        new L22().generateParenthesis(3);
    }
}
