package com._leetcode.L301_L400;

import java.util.Arrays;

public class L377 {
    int[] memo;

    //Solution：记忆化搜索
    public int combinationSum4(int[] nums, int target) {
        memo = new int[target + 1];
        Arrays.fill(memo, -1); //一定要设为-1
        return fb(nums, target);
    }

    private int fb(int[] nums, int target) {
        if (target < 0) return 0;
        if (target == 0) return 1;
        if (memo[target] != -1) return memo[target];
        int res = 0;
        for (int num : nums) {
            res += fb(nums, target - num);
        }
        memo[target] = res;
        return memo[target];
    }

    //Solution：dp
    public int combinationSum4_dp(int[] nums, int target) {
        memo = new int[target + 1];
        memo[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] <= i) //能不能放进背包
                    memo[i] += memo[i - nums[j]];
            }
        }
        return memo[target];
    }


    public static void main(String[] args) {
        System.out.println(new L377().combinationSum4(new int[]{1, 2, 3}, 4));
    }


}
