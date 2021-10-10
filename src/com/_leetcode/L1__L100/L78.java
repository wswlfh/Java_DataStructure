package com._leetcode.L1__L100;

import java.util.LinkedList;
import java.util.List;

public class L78 {
    List<List<Integer>> ans;
    LinkedList<Integer> res;

    public List<List<Integer>> subsets(int[] nums) {
        ans = new LinkedList<>();
        res = new LinkedList<>();
        gens(0, nums);
        return ans;
    }

    private void gens(int start, int[] nums) {
        if (start > nums.length)
            return;

        if (res.size() <= nums.length) {
            ans.add(new LinkedList<>(res));
        }

        for (int i = start; i < nums.length; i++) {
            res.addLast(nums[i]);
            gens(i + 1, nums);
            res.removeLast();
        }
    }

    public static void main(String[] args) {
        new L78().subsets(new int[]{1,2,3});
    }
}
