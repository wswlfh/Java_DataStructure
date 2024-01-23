package com._leetcode.L301_L400;

import java.util.Arrays;

public class L416 {
    //Solution：
    //变种背包问题，判断背包能不能填满即可，背包容量为sum/2
    //对于判断有没有的动态规划问题，采用记忆化搜索自顶向下递归来搜索思路更为清晰
    // 动态规划更适合用来求最值问题
    public boolean canPartition(int[] nums) {
        int n = nums.length, sum = 0;
        for (int x : nums) sum += x;
        if (nums.length == 1 || sum % 2 == 1) return false;
        int[][] memo = new int[n][sum / 2 + 1];

        for (int[] arr : memo) {
            Arrays.fill(arr, -1);//1代表有，0代表没有，-1代表没计算
        }

        return find(nums, memo, 0, sum / 2);
    }

    public boolean find(int[] nums, int[][] memo, int index, int C) {
        if (C == 0) return true;
        if (index >= nums.length || C < 0) return false;
        if (memo[index][C] != -1) return memo[index][C] == 1;

        memo[index][C] = find(nums, memo, index + 1, C) ||
                find(nums, memo, index + 1, C - nums[index]) ? 1 : 0;
        return memo[index][C] == 1;
    }


}
