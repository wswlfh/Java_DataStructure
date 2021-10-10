package com._leetcode.L1801_L2000;

public class L1827 {
    public static int minOperations(int[] nums) {
        if (nums.length == 1)
            return 0;
        int sum = 0;
        for (int i = 1; i < nums.length; i++) {
            int res = nums[i - 1] - nums[i];
            if (res < 0)
                continue;
            nums[i] += res + 1;
            sum += res + 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        minOperations(new int[]{1,1,1});
    }
}
