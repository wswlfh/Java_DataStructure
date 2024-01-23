package com._leetcode.L201__L300;

import java.util.Arrays;
import java.util.HashSet;

public class L279 {
    public int numSquares(int n) {
        int[] memo = new int[n + 1];
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, memo[i - j * j]);
            }
            memo[i] = 1 + min;
        }
        return memo[n];
    }

}
