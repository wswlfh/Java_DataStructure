package com._leetcode.L1__L100;

import java.util.*;

public class L18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length - 3; i++) {
            int target3 = target - nums[i];
            for (int j = i + 1; j < nums.length - 2; j++) {
                int target2 = target3 - nums[j];
                int l = j + 1, r = nums.length - 1;
                while (l < r) {
                    if (nums[l] + nums[r] == target2) {
                        List<Integer> list = new LinkedList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        set.add(list);
                        l++;
                        r--;
                    } else if (nums[l] + nums[r] < target2)
                        l++;
                    else
                        r--;
                }
            }
        }
        return new ArrayList<>(set);
    }
}
