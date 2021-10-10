package com._leetcode.L201__L300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L229 {

    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        if (nums.length <= 2) {
            list.add(nums[0]);
            return list;
        }

        int v = nums.length / 3;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i]) + 1);
            else
                map.put(nums[i], 1);
        }
        for (int key : map.keySet()){
            if (map.get(key) > v)
                list.add(key);
        }
        return list;
    }

}
