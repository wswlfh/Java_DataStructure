package com._leetcode.L101__L200;

import java.util.*;

public class L169 {
    //169. 多数元素
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = 1;
            if (map.containsKey(nums[i]))
                value = map.get(nums[i]) + 1;
            map.put(nums[i], value);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2){
                return entry.getKey();
            }
        }
        return 0;
    }

    //Solution2：排序后返回中位数，中位数一定是众数
}
