package com._leetcode.L201__L300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class L213 {
    //213. 打家劫舍 II

    //Solution1：两次动态规划 求 max{[1,....,n-1]}和max{[0,....,n-2]} 哪个大
    public  int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];

        return Math.max(robMax(nums,0,n-2),robMax(nums,1,n-1));
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
        int[] nums = {1, 2, 3, 1};
        System.out.println(new L213().rob(nums));
    }
}
