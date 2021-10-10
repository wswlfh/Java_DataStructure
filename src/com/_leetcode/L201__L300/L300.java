package com._leetcode.L201__L300;

import java.util.Arrays;

public class L300 {
    int[] memo;

    public int lengthOfLIS(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, partition(i, nums));
//            if (res >= nums.length - i )
//                break;
        }
        return res;
    }


    //寻找从[index,....,n-1]以index为开头的递增子序列
    private int partition(int index, int[] nums) {

        if (memo[index] != -1)
            return memo[index];

        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] > nums[index])
                memo[index] = Math.max(memo[index], 1 + partition(i, nums));
        }
        if (memo[index] == -1)
            return 1;
        return memo[index];
    }

    public static void main(String[] args) {
        int[] nums = {4, 10, 4, 3, 8, 9};
        System.out.println(new L300().lengthOfLIS(nums));
    }
}
