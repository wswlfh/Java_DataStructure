package com._leetcode.L101__L200;

public class L200 {
    //200. 岛屿数量
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int i, int j) {
        if (i >= grid.length || j >= grid[i].length
                || i < 0 || j < 0 || grid[i][j] == '0') //越过0 不然会无线递归栈溢出
            return;
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    public static void main(String[] args) {
        int[][] f = {{1, 2, 3}, {1, 2}};
        System.out.println(f[1].length);
    }
}
