package com._leetcode.L901_L1000;

import java.util.Arrays;

public class L977 {
    //Solution1：排序Api
    public static int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i] * nums[i];
        }
        Arrays.sort(ans);
        return ans;
    }

    //Solution：双指针思想
    public static int[] sortedSquares2(int[] nums) {
        int[] ans = new int[nums.length];
        int l = 0, r = nums.length-1;
        int k = r;
        while (l <= r) {
            if (Math.abs(nums[l]) >= Math.abs(nums[r])) {
                ans[k--] = Math.abs(nums[l]);
                l++;
            }else {
                ans[k--] = Math.abs(nums[r]);
                r--;
            }
        }
        for (int i = 0; i < ans.length; i++) {
            ans[i] *= ans[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        sortedSquares2(new int[]{-7,-3,2,3,11});
    }
}
