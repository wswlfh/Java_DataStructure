package com._leetcode.L201__L300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class L213 {
    //213. 打家劫舍 II
    public static int rob(int[] nums) {

        Vector<Integer> vector = new Vector<>();
        ArrayList<Object> list = new ArrayList<>();
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        int[] dp = new int[nums.length + 1];
        boolean[] flag = new boolean[nums.length + 1];
        dp[1] = nums[0];
        flag[1] = true;
        dp[2] = nums[1];
        for (int i = 3; i <= nums.length; i++) {
            if (dp[i - 2] >= dp[i - 3]) {
                dp[i] = nums[i - 1] + dp[i - 2];
                flag[i] = flag[i - 2];
            } else {
                dp[i] = nums[i - 1] + dp[i - 3];
                flag[i] = flag[i - 3];
            }
        }

        return 0;
    }



    public static void main(String[] args) {
        int[] nums = {200, 3, 140, 20, 10};
        System.out.println(rob(nums));
    }
}
