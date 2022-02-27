package com._leetcode.L201__L300;

import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class L220 {
    //Solution: TreeSet + 滑动窗口
    //          保证set的容量为k，然后从头往里面添加元素
    //          添加规则：保证num[i]与floor和ceiling的差值超过t
    //              floor：set中比至多比num[i]小的元素
    //              ceiling：set中比至少比num[i]大的元素
    //          floor和ceiling直接用TreeSet的api方法获取
    public  boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer floor = set.floor(nums[i]);
            Integer ceiling = set.ceiling(nums[i]);
            if ((floor != null && (long) nums[i] - (long) floor <= t) ||
                    ceiling != null && (long) ceiling - (long) nums[i] <= t)
                return true;

                set.add(nums[i]);
            if (set.size() == k + 1)
                set.remove(nums[i - k]);
        }
        return false;
    }


    public static void main(String[] args) {
//        int a = 2147483647;
//        int b = -1;
//        System.out.println((long)a-(long)b);
    }
}
