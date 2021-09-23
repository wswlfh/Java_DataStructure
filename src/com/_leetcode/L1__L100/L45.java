package com._leetcode.L1__L100;

public class L45 {
    /*
    45. 跳跃游戏 II
    给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
    数组中的每个元素代表你在该位置可以跳跃的最大长度。
    你的目标是使用最少的跳跃次数到达数组的最后一个位置。
    假设你总是可以到达数组的最后一个位置
     */

    //Solution1：暴力法，遍历算出每一个位置的最小跳跃次数
    //如果 index <= min( i - 1 + num[i] ) 每一个点 都是从某一个点跳跃过来
    //如果一个点能被跳跃到，那这个点的下标就小于 跳跃点的下标 + 跳跃点的数组值，
    //计算所有满足跳跃条件的跳跃点所需的跳跃值，存在f[i][0]里面
    //  least = 1（前一个点的跳跃次数） + f[i -1][0] 到达这个点的最小跳跃次数
    public int jump(int[] nums) {
        if (nums.length == 1)
            return 0;
        if (nums[0] >= nums.length - 1)
            return 1;
        int[][] f = new int[nums.length][1];
        f[0][0] = 0;
        for (int i = 1; i < nums.length; i++) {
            f[i][0] = compute(f, nums, i);
        }
        return f[nums.length - 1][0];
    }

    private int compute(int[][] f, int[] nums, int index) {
        int least = Integer.MAX_VALUE;
        for (int i = 1; i <= index; i++) {
            if (index <= i - 1 + nums[i - 1]) {
                if ((1 + f[i - 1][0]) < least)
                    least = 1 + f[i - 1][0];
            }
        }
        return Math.min(index, least);
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 0, 1, 4};
        System.out.println(new L45().jump(nums));
    }
}
