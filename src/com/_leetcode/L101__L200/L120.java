package com._leetcode.L101__L200;

import java.util.List;

public class L120 {
    //Solution：动态规划
    // 自底向上，到一个节点的最小路径和，肯定来源于其左上或右上的节点的最小路径和再加上自身的值
    // 建立好memo数组即可
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] memo = new int[triangle.size()][triangle.size()];
        memo[0][0] = triangle.get(0).get(0);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                //核心算法
                //为了防止越界分别计算left(左上)和right(右上)
                int left = j - 1 >= 0 ? memo[i - 1][j - 1] : 10001;
                int right = j <= triangle.get(i - 1).size() - 1 ? memo[i - 1][j] : 10001;
                memo[i][j] = triangle.get(i).get(j) + Math.min(left, right);
                if (i == triangle.size() - 1) //到了最后一行，才开始找最小
                    min = Math.min(memo[i][j], min);
            }
        }
        return min == Integer.MAX_VALUE ? memo[0][0] : min;
    }
}
