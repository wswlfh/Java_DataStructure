package com._leetcode.L101__L200;

import java.util.Arrays;
import java.util.Scanner;

public class L200 {
    //200. 岛屿数量
    public int area;

    public int numIslands(int[][] grid) {
        //int count = 0;
        int max = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    //count++;
                    area = 0;
                    dfs(grid, i, j);
                    max = Math.max(area, max);
                    area = 0;
                }
            }
        }
        return max;
    }

    private void dfs(int[][] grid, int i, int j) {
        int nr = grid.length;
        int nc = grid[0].length;
        if (i >= nr || j >= nc
                || i < 0 || j < 0 || grid[i][j] == 0) //越过0 不然会无线递归栈溢出
            return;
        area += grid[i][j];
        grid[i][j] = 0;
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        //求岛屿最大面积
        System.out.println(new L200().numIslands(grid));
    }

}
