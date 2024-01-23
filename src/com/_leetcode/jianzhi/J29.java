package com._leetcode.jianzhi;

public class J29 {
    //Solution：采用dfs，控制移动方向：右下左上
    // 麻烦也要写
    int m, n, k = 0;
    int[] ans;
    boolean[][] visited;

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[]{};
        m = matrix.length;
        n = matrix[0].length;
        visited = new boolean[m][n];
        ans = new int[m * n];
        dfs(matrix, 0, 0, "right");
        return ans;
    }

    private void dfs(int[][] matrix, int i, int j, String turn) {
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j]) return;
        ans[k++] = matrix[i][j];
        visited[i][j] = true;
        if ("right".equals(turn)) {
            if (j + 1 >= n || visited[i][j + 1]) dfs(matrix, i + 1, j, "down");
            else dfs(matrix, i, j + 1, "right");
        } else if ("down".equals(turn)) {
            if (i + 1 >= m || visited[i + 1][j]) dfs(matrix, i, j - 1, "left");
            else dfs(matrix, i + 1, j, "down");
        } else if ("left".equals(turn)) {
            if (j - 1 < 0 || visited[i][j - 1]) dfs(matrix, i - 1, j, "up");
            else dfs(matrix, i, j - 1, "left");
        } else if ("up".equals(turn)) {
            if (i - 1 < 0 || visited[i - 1][j]) dfs(matrix, i, j + 1, "right");
            else dfs(matrix, i - 1, j, "up");
        }
    }


}
