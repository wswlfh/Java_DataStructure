package com._leetcode.L1101_L1200;

public class L1137 {
    /**
     * 1137：第 N 个泰波那契数
     * 泰波那契序列 Tn 定义如下：
     * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
     * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
     */
    public int tribonacci(int n) {
        if (n <= 2)
            return n == 0 ? 0 : 1;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[2] = dp[1] = 1;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }
}
