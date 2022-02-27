package com._leetcode.L1__L100;

import java.util.Arrays;

public class L16 {
    //Solution：本质上还是18.三数之和
    //          区别在于，要用一个min记录target与三数之和的差的绝对值
    //          每更新一次min，就把此时的和sum赋给ans
    //          全部操作结束后，ans即为最接近之和
    public  int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            //l为i+1,不可为0
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(sum - target) < min) {
                    min = Math.abs(sum - target);
                    ans = sum;
                }
                if (sum < target)
                    l++;
                else if (sum > target)
                    r--;
                else return target;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
