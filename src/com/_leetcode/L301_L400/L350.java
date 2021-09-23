package com._leetcode.L301_L400;

import java.util.ArrayList;
import java.util.HashMap;

public class L350 {
    /*
 350. 两个数组的交集
      给定两个数组，编写一个函数来计算它们的交集。
      与349区别是：求出带有重复元素的交集
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null)
            return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            if (map.containsKey(num))
                map.replace(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                list.add(num);
                map.replace(num, map.get(num) - 1);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
