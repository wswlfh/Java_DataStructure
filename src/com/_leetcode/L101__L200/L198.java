package com._leetcode.L101__L200;

public class L198 {
    //198. 打家劫舍
    public static int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        dp[2] = nums[1];
        for (int i = 3; i < dp.length; i++) {
            dp[i] = nums[i - 1] + Math.max(dp[i - 2], dp[i - 3]);
        }
        return Math.max(dp[nums.length], dp[nums.length - 1]);
    }

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(rob(nums));
    }
}
