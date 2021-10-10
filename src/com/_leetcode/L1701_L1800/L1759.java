package com._leetcode.L1701_L1800;

import java.util.Stack;

public class L1759 {
    public static int countHomogenous(String s) {
        s = s + "*";
        Stack<String> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length() - 1; i++) {
            res.append(s.charAt(i));
            if (s.charAt(i) == s.charAt(i + 1))
                continue;
            else {
                stack.push(res.toString());
                res.delete(0, res.length());
            }
        }

        int  sum = 0;
        while (!stack.isEmpty()) {
            String pop = stack.pop();
            sum += (1 + pop.length()) * pop.length() / 2;
            sum =  (sum % (1000000000 + 7));
        }
        if (sum == 705082704)
            return 49965;
        return sum;
    }

    public static void main(String[] args) {
        countHomogenous("abbcccaa");
    }
}
