package com._leetcode.L301_L400;

import java.util.Arrays;
import java.util.Vector;

public class L343 {
    //343. 整数拆分 中等
    //给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。

    //Solution1：记忆化搜索，自顶向下递归
    //从n开始，使用for循环完善memo[n]、memo[n-i]。。。。。
    //保存重叠子结构的结果，降低递归开销
    public int integerBreak(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        memo[n] = gens(n, memo);
        return memo[n];
    }

    private int gens(int n, int[] memo) {
        if (n == 2) {
            return 1;
        }

        if (memo[n] != -1)
            return memo[n];

        int res = -1;
        //为什么使用for循环：因为要构造出树的结构
        //                         n
        //       1*gens(n-1) 2*gens(n-2) 3*gens(n-3) ..... 比下去
        //刚拆分成两个数 i 和 n-i 它们的积可能比分成的多个数的积还大，所以要判断 i * n-1
        for (int i = 1; i <= n - 1; i++)
            //这里只能用res，因为每次res的值都会变化，把最终变化存入memo[n]里
            res = Math.max(Math.max(res, i * (n - i)), i * gens(n - i, memo));
        memo[n] = res;
        return res;
    }

    //Solution2：根据Solution1的自顶向下记忆化搜索，构造自底向上的动态规划
    //即从memo[1]开始 一直构建到memo[n]
    public int integerBreak2(int n) {
        int[] memo = new int[n + 1];
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                //比较 原来的memo[i] 和 j * memo[i-j] 哪个大
                // 但如果有的数不需要再分就会更大 即 (i-j) > memo[i-j] 的情况，所以要再判断一次
                memo[i] = Math.max(memo[i], Math.max(j * memo[i - j], j * (i - j)));
            }
        }
        return memo[n];
    }
}
