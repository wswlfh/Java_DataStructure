package com._leetcode.L201__L300;

import java.util.HashSet;

public class L217 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]))  return true;
            set.add(nums[i]);
        }
        return false;
    }

}
