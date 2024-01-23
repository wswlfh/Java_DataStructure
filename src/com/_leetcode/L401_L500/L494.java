package com._leetcode.L401_L500;

import java.util.Arrays;

public class L494 {
    //Solution：回溯
    public int findTargetSumWays(int[] nums, int target) {
        fb(nums, 0, target);
        return count;
    }

    int count = 0;
    int res = 0;

    public void fb(int[] nums, int index, int target) {
        if (index > nums.length) return;

        if (index == nums.length) {
            if (res == target) count++;
            return;
        }

        res += nums[index];
        fb(nums, index + 1, target);
        res -= nums[index];

        res -= nums[index];
        fb(nums, index + 1, target);
        res += nums[index];

    }

    //Solution：动态规划
    public int findTargetSumWays2(int[] nums, int target) {
        int[][] memo = new int[nums.length][target + 1];
        Arrays.stream(memo).forEach(arr -> Arrays.fill(arr, -1));
        for (int i = 0; i < nums.length; i++) {
            nums[i] += 1000;
        }
        return search(nums, 0, target + 1000, memo);
    }

    public int search(int[] nums, int index, int target, int[][] memo) {
        if (index == nums.length) {
            if (target == 0) return 1;
            else return 0;
        }
        if (index > nums.length) return 0;
        if (memo[index][target] != -1) return memo[index][target];

        int res = search(nums, index + 1, target - nums[index], memo) +
                search(nums, index + 1, target + nums[index], memo);
        memo[index][target] = res;
        return res;
    }

    public static void main(String[] args) {

    }
}
