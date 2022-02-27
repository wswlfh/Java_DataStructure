package com._leetcode.L201__L300;

import java.util.HashSet;

public class L219 {
    //Solution：Set+滑动窗口
    //          保持窗口大小为 k+1 即 [l,r]，然后将[l,r]的元素全部加入set
    //              若没有重复元素，则set.size()=r-l+1
    //              若有，则set.size() < r-l+1 窗口向前移动(l++,r++)直至有重复元素
    //          使用固定滑动窗口大小，就可以保证元素相等元素的索引之差小于k+1
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int l = 0;
        //注意这里r的取值，要防止k比数组长度还大
        int r = k >= nums.length ? nums.length - 1 : k;

        HashSet<Integer> set = new HashSet<>();
        for (int i = l; i <= r; i++)
            set.add(nums[i]);

        while (true) {
            if (set.size() < r - l + 1) return true;
            if (r == nums.length - 1) break;
            set.remove(nums[l++]);
            set.add(nums[++r]);
        }
        return false;
    }
}
