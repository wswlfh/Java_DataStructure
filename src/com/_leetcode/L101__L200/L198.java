package com._leetcode.L101__L200;

import java.util.Arrays;
import java.util.Vector;

public class L198 {
    //198. 打家劫舍
    //Solution：动态规划
    // [0,.....,n-1]
    //f(0) = max{  v(0)+f(2), v(1)+f(3), v(2)+f(4) , ... , v(n-2), v(n-1)  }
    public int rob(int[] nums) {
        int n = nums.length;
        //加2是防止算f(n-2)的时候越界，不加也行但要加一些判断
        int[] memo = new int[n + 2];
        memo[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                //这里是如何计算v(n-2)和v(n-1)的
                // f(n-2) = max{v(n-2) + f(n),v(n-1) + f(n+1)}
                // 因为f(n)和f(n+1)都越界，所以都为0 就自动变成了 f(n-2) = max{v(n-2),v(n-1)},不用再去额外判断
                memo[i] = Math.max(memo[i], nums[j] + memo[j + 2]);
            }
        }
        return memo[0];
    }


    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(new L198().rob(nums));
    }
}
