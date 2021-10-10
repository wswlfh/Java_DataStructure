package com._leetcode.L301_L400;

import java.util.Arrays;

public class L322 {
    //Solution3: 迭代法
    //不需要胡里花哨
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0)
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }

        }
        return dp[amount] == Integer.MAX_VALUE -1 ? -1 : dp[amount];
    }


    public static void main(String[] args) {
        int[] nums = {2};
        System.out.println(new L322().coinChange(nums, 3));
    }
}
