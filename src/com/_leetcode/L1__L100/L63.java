package com._leetcode.L1__L100;

public class L63 {
    int count = 0;
    int m;
    int n;

    //Solution1: 深度优先 超时
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;

        if (obstacleGrid[m - 1][n - 1] == 1)
            return 0;


        dfs(obstacleGrid, 0, 0);
        return count;
    }

    private void dfs(int[][] obstacleGrid, int i, int j) {
        if (i == m - 1 && j == n - 1) {
            count++;
            return;
        }

        if (i == m || j == n || obstacleGrid[i][j] == 1)
            return;

        dfs(obstacleGrid, i + 1, j);
        dfs(obstacleGrid, i, j + 1);
    }

    //写错了。。。。。，写成求最短路径了
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;

        if (obstacleGrid[m - 1][n - 1] == 1)
            return 0;

        int[][] memo = new int[m][n];
        for (int i = 0, flag = 1; i < m; i++) {
            if (obstacleGrid[i][n - 1] == 1)
                flag = -1;
            memo[i][n - 1] = flag * (m - i - 1);
        }
        for (int i = 0, flag = 1; i < n; i++) {
            if (obstacleGrid[i][n - 1] == 1)
                flag = -1;
            memo[m - 1][i] = flag * (n - i - 1);
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    memo[i][j] = -1;
                    continue;
                }
                if (obstacleGrid[i + 1][j] == 1 && obstacleGrid[i][j + 1] == 1)
                    memo[i][j] = -1;
                else if (obstacleGrid[i + 1][j] != 1 && obstacleGrid[i][j + 1] == 1)
                    memo[i][j] = memo[i + 1][j] < 0 ? -1 : 1 + memo[i + 1][j];
                else if (obstacleGrid[i + 1][j] == 1 && obstacleGrid[i][j + 1] != 1)
                    memo[i][j] = memo[i][j + 1] < 0 ? -1 : 1 + memo[i][j + 1];
                else {
                    if (memo[i + 1][j] >= 0 && memo[i][j + 1] >= 0)
                        memo[i][j] = Math.min(1 + memo[i + 1][j], 1 + memo[i][j + 1]);
                    else if (memo[i + 1][j] < 0 && memo[i][j + 1] >= 0)
                        memo[i][j] = 1 + memo[i][j + 1];
                    else if (memo[i + 1][j] >= 0 && memo[i][j + 1] < 0)
                        memo[i][j] = 1 + memo[i + 1][j];
                    else
                        memo[i][j] = -1;
                }
            }
        }

        return 0;
    }


    //Solution2：动态规划，速通
    public int uniquePathsWithObstacles3(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;

        if (obstacleGrid[m - 1][n - 1] == 1)
            return 0;

        int[][] memo = new int[m][n];
        for (int i = m - 1, flag = 1; i >= 0; i--) {
            if (obstacleGrid[i][n - 1] == 1)
                flag = -1;
            memo[i][n - 1] = flag == 1 ? 1 : 0;
        }
        for (int i = n - 1, flag = 1; i >= 0; i--) {
            if (obstacleGrid[m - 1][i] == 1)
                flag = -1;
            memo[m - 1][i] = flag == 1 ? 1 : 0;
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    memo[i][j] = 0;
                    continue;
                }
                memo[i][j] = memo[i + 1][j] + memo[i][j + 1];
            }
        }

        return memo[0][0];
    }

    public static void main(String[] args) {
        L63 l63 = new L63();
        int[][] nums = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        l63.uniquePathsWithObstacles3(nums);
    }
}
