package com._leetcode.L1__L100;

import java.util.Arrays;

public class L53 {
    int[] memo;
    int max;
    //53. 最大子序和


    //Solution1：记忆化搜索
    public int maxSubArray(int[] nums) {
        memo = new int[nums.length];
        max = nums[nums.length - 1];  // max本来定义为memo[]中的最大值，但算法中，
        // memo[]的最后一位并没有把num[]的末位元素放进去，为了防止极端情况只有最后一位元素的子序列最大
        Arrays.fill(memo, -1);
        partition(0, nums);
        return max;
    }

    //求出 [index,....,n-1] 的最大子序和
    private int partition(int index, int[] nums) {
        if (index == nums.length - 1)
            return nums[index];

        if (memo[index] != -1)
            return memo[index];

        int res = Math.max(nums[index], nums[index] + partition(index + 1, nums));
        memo[index] = res;
        max = Math.max(res, max);
        return res;
    }

    //Solution2：动态规划
    public int maxSubArray2(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        max = memo[nums.length - 1] = nums[nums.length - 1]; //防止最后一位元素的单序列是最大的
        for (int i = nums.length - 2; i >= 0; i--) {
            memo[i] = Math.max(nums[i], nums[i] + memo[i + 1]);
            max = Math.max(memo[i],max);
        }
        return max;
    }

    public int maxSubArray3(int[] nums) {
        int[] memo = new int[nums.length];
        int ans;
        ans = memo[nums.length - 1] = nums[nums.length - 1];

        for (int i = nums.length - 2; i >= 0; i--) {
            memo[i] = Math.max(nums[i], nums[i] + memo[i + 1]);
            ans = Math.max(ans, memo[i]);
        }

        return ans;
    }



    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new L53().maxSubArray2(nums));
    }
}
