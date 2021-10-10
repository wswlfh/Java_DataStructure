package com._leetcode.L2001_L2300;

import java.util.HashSet;

public class L2057 {
    public int smallestEqual(int[] nums) {
        //HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i % 10 == nums[i])
                return i;
        }
        return -1;
    }
}
