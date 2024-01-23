package com._leetcode.L1__L100;

public class L64 {
    //Solution：62题的变形版
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] memo = new int[m][n];
        memo[m - 1][n - 1] = grid[m - 1][n - 1];
        for (int i = n - 2; i >= 0; i--)
            memo[m - 1][i] = grid[m - 1][i] + memo[m - 1][i + 1];
        for (int i = m - 2; i >= 0; i--)
            memo[i][n - 1] = grid[i][n - 1] + memo[i + 1][n - 1];

        for (int i = m - 2; i >= 0; i--)
            for (int j = n - 2; j >= 0; j--)
                memo[i][j] = grid[i][j] + Math.min(memo[i + 1][j], memo[i][j + 1]);

        return memo[0][0];
    }
}
