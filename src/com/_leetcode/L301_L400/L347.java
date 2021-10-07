package com._leetcode.L301_L400;

import java.util.*;

public class L347 {
    //347. 前 K 个高频元素
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 1)
            return nums;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });
        for (int key : map.keySet()){
            if (pq.size() < k)
                pq.add(key);
            else if (map.get(key) > map.get(pq.peek())){
                pq.remove();
                pq.add(key);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.remove();
        }
        return res;
    }
}
