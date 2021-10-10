package com._leetcode.L701_L800;

import java.util.*;

public class L740 {

    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        map.put(nums[n - 1], 1);
        int max = 0;
        for (int i = n - 2; i >= 0; i--) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            max = Math.max(max, sum(map, nums[i] + 1, nums[i] - 1));
            max = Math.max(max, sum(map, nums[i], -1));
        }

        return max;
    }

    private int sum(Map<Integer, Integer> map, int key1, int key2) {
        int sum = 0;
        for (int x : map.keySet()) {
            if (x == key1 || x == key2)
                continue;
            sum += x * map.get(x);
        }
        return sum;
    }

    public static void main(String[] args) {
        //new L740().deleteAndEarn(new int[]{8, 10, 4, 9, 1, 3, 5, 9, 4, 10});
        new L740().deleteAndEarn(new int[]{2,2,3,3,3,4});
    }
}
