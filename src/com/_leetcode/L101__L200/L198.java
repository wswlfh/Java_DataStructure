package com._leetcode.L101__L200;

import java.util.Arrays;
import java.util.Vector;

public class L198 {
    //198. 打家劫舍
    //Solution1：动态规划
    //dp[i] = nums[i - 1] + Math.max(dp[i - 2], dp[i - 3]);
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

    //Solution2：记忆化搜索
    //max[0,.....,n-1] - > max(num[0] + max[2,...,n-1] , nums[1] + max[3,...,n-1],
    // ........., num[n-1] )
    public static int rob2(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);

        return gens(0, nums, memo);
    }

    // 从 [index,.....,n] 所能抢劫的最大的钱
    private static int gens(int index, int[] nums, int[] memo) {
        if (index >= nums.length)
            return 0;
        if (memo[index] != -1)
            return memo[index];
        int res = -1; //
        for (int i = index; i < nums.length; i++) {
            //使用i+2是因为只能隔着屋子抢劫
            res = Math.max(res, nums[i] + gens(i + 2, nums, memo));
        }
        memo[index] = res;
        return memo[index];
    }

    //Solution3：记忆化搜索 转为 动态规划
    public static int rob3(int[] nums) {

        int[] memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        //memo[i] 表示从nums[i,n-1]所能抢到最多的钱，最终要返回memo[0]
        memo[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            //求memo[i]
            for (int j = i; j < nums.length; j++) {
                memo[i] = Math.max(memo[i], nums[j] +
                        (j + 2 < nums.length ? memo[j + 2] : 0));
            }
        }
        return memo[0];
    }

    //终极版 求 max[start,...,end]
    private int robMax(int[] nums, int start, int end) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        //memo[i] 表示从nums[i,end]所能抢到最多的钱，最终要返回memo[start]
        memo[end] = nums[end];
        for (int i = end - 1; i >= start; i--) {
            //求memo[i]
            for (int j = i; j < end + 1; j++) {
                memo[i] = Math.max(memo[i], nums[j] +
                        (j + 2 < end + 1 ? memo[j + 2] : 0));
            }
        }
        return memo[start];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(rob(nums));
    }
}
