package com._leetcode.L1__L100;

public class L59 {
    int v = 1;

    public int[][] generateMatrix(int n) {
        int[][] grid = new int[n][n];
        dfs(grid, 0, 0, "right", v);
        return grid;
    }

    private static void dfs(int[][] grid, int i, int j, String turn, int v) {
        int n = grid.length;
        if (v == n * n + 1)
            return;
        if (turn.equals("right")) {
            if (j >= n || grid[i][j] != 0) {
                dfs(grid, i + 1, j - 1, "down", v);
                return;
            }
            grid[i][j] = v;
            dfs(grid, i, j + 1, "right", v + 1);

        }
        if (turn.equals("down")) {
            if (i >= n || grid[i][j] != 0) {
                dfs(grid, i - 1, j - 1, "left", v);
                return;
            }
            grid[i][j] = v;
            dfs(grid, i + 1, j, "down", v + 1);
        }

        if (turn.equals("left")) {
            if (j < 0 || grid[i][j] != 0) {
                dfs(grid, i - 1, j + 1, "up", v);
                return;
            }
            grid[i][j] = v;
            dfs(grid, i, j - 1, "left", v + 1);
        }
        if (turn.equals("up")) {
            if (i < 0 || grid[i][j] != 0) {
                dfs(grid, i + 1, j + 1, "right", v);
                return;
            }
            grid[i][j] = v;
            dfs(grid, i - 1, j, "up", v + 1);
        }
    }

    public static void main(String[] args) {
        int[][] ints = new L59().generateMatrix(5);
        System.out.println();
    }
}
