package com._leetcode.L1__L100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

public class L1 {
    //Solution1：hashmap
    //          遍历nums将数逐个插入(nums[i],i)
    //          然后在插入之前判断map中是否存在target - nums[i]，这样就可以规避重复元素
    //          如果插入完后再去判断，重复元素的索引值将会更新
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]))
                return new int[]{i, map.get(target - nums[i])};
            map.put(nums[i], i);
        }
        return null;
    }


    public int[] twoSum2(int[] nums, int target) {

        return null;
    }


}
