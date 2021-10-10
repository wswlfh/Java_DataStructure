package com._leetcode.L701_L800;

public class L746 {

    //746. 使用最小花费爬楼梯
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 1)
            return cost[0];
        if (cost.length == 2)
            return Math.min(cost[0], cost[1]);

        int[] dp = new int[cost.length + 1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }
}
