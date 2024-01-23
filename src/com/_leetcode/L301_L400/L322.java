package com._leetcode.L301_L400;

import java.util.Arrays;

public class L322 {

    /**
     * 322.零钱兑换
     * <p>给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
     * <p>计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
     * <p>base case：目标金额为0
     * <p>状态：唯一状态是目标金额amount
     * <p>dp：达成amount所需最少硬币
     * <p>选择：res = min(res, 1 + dp(n - coin)) amount所需最小硬币 = 1+(amount - coin)所需最小硬币，符合最优子结构
     */

    //Solution1：暴力动态规划：超时
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        if (amount < 0)
            return -1;
        int[] dp = new int[amount + 1];
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub = coinChange(coins, amount - coin);
            if (sub == -1)
                continue;
            res = Math.min(res, 1 + sub);
        }
        dp[amount] = res == Integer.MAX_VALUE ? -1 : res;
        return dp[amount];
    }

    //Solution2：Solution：动态规划
    // 完全背包不需要二维数组！因为每个物品都可以选，所以只要关注与背包容量即可
    // 状态转移方程：F(C) = min{1+F(C-c0),1+F(C-c1),....,1+F(C-cn-1)}, F(C-ci) != -1
    // 每个硬币都可以选
    public int coinChange2(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        int ans = dp(coins, memo, amount);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int dp(int[] coins, int[] memo, int C) {
        if (C == 0) return 0;
        if (C < 0) return -1;
        if (memo[C] != 0) return memo[C];
        //每种硬币都要选
        memo[C] = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub = dp(coins, memo, C - coin);
            if (sub == -1) continue;
            memo[C] = Math.min(memo[C], sub + 1);
        }
        return memo[C];
    }


    //Solution3: 迭代法
    //不需要胡里花哨
    public int coinChange3(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0)
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }

        }
        return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
    }


    public static void main(String[] args) {
        int[] nums = {2};
        System.out.println(new L322().coinChange(nums, 3));
    }

}
