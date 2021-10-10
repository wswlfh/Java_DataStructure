package com._leetcode.L1__L100;

import java.util.ArrayList;
import java.util.List;

public class L46 {
    boolean[] used;
    List<Integer> res;

    /*
    46. 全排列 中等
    给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     */

    //Solution1：回溯法
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        res = new ArrayList<>();
        used = new boolean[nums.length];
        gens(nums, list);
        return list;
    }
    
    private void gens(int[] nums, ArrayList<List<Integer>> list) {
        if (res.size() == nums.length) {
            //这里要对res进行复制，然后传入复制对象
            //在Java里，如果直接传res只是传地址，后续res变化会导致list也跟着变化
            List<Integer> resCopy = new ArrayList<>(res);
            list.add(resCopy);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                res.add(nums[i]);
                gens(nums, list);
                res.remove(res.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        new L46().permute(nums);
    }
}
