package com;


public class Code {
    //code1
    public static double code1(double d) {
        double ans;
        String s = String.valueOf(d);
        int i = 0;
        for (; i < s.length(); i++) {
            if (s.charAt(i) == '.')
                break;
        }
        int remainLength = s.length() - i - 1;
        //没找到
        if (remainLength < 3) return d;

        ans = Double.parseDouble(s.substring(0, i + 3));

        if (s.charAt(i + 3) == '5') {
            if (remainLength == 3 && (s.charAt(i + 2) - '0') % 2 != 0) {
                ans += 0.01;
            } else if (remainLength > 3)
                ans += 0.01;
        } else if (s.charAt(i + 3) > '5') {
            ans += 0.01;
        }

        //保留两位小数
        return (double) Math.round(ans * 100) / 100;
    }


    public int tribonacci(int n) {
        int[] memo = new int[38];
        memo[2] = memo[1] = 1;
        for (int i = 3; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2] + memo[i - 3];
        }
        return memo[n];
    }


    public int maxSubArray(int[] nums) {
        int[] memo = new int[nums.length];
        int ans;
        ans = memo[nums.length - 1] = nums[nums.length - 1];

        for (int i = nums.length - 2; i >= 0; i--) {
            memo[i] = Math.max(nums[i], nums[i] + memo[i + 1]);
            ans = Math.max(ans, memo[i]);
        }

        return ans;
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] memo = new int[cost.length + 1];
        if (cost.length == 2)
            return Math.min(cost[0], cost[1]);
        for (int i = 2; i < memo.length; i++)
            memo[i] = Math.min(memo[i - 1] + cost[i - 1], memo[i - 2] + cost[i - 2]);

        return memo[memo.length - 1];
    }

    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        int n = nums.length;
        int[] memo = new int[n];
        memo[0] = nums[0];
        memo[1] = nums[1];
        memo[2] = nums[2] + nums[0];

        for (int i = 3; i < n; i++)
            memo[i] = nums[i] + Math.max(memo[i - 2], memo[i - 3]);

        return Math.max(memo[n - 1], memo[n - 2]);
    }

    public static void main(String[] args) {

    }
}
