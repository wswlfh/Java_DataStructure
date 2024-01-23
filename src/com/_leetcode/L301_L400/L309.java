package com._leetcode.L301_L400;

public class L309 {
    //Solution: 动态规划
    //f(i) = max{f(i+1),v(i+1) - v(i) + f(i+3),...,v(n-1) - v(n-2),0}
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 1) return 0;
        int[] memo = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                int res = Math.max(memo[i], (j + 1 < n ? prices[j + 1] - prices[i] : 0) +
                        (j + 3 < n ? memo[j + 3] : 0));
                //比较[start,end]和start[start+1,end]，即用不用新加进来的
                memo[i] = Math.max(res, i + 1 < n ? memo[i + 1] : 0);
            }
        }
        return memo[0];
    }
}
