package com._leetcode.L401_L500;

import java.util.HashMap;

public class L454 {
    //Solution1：Map
    //          将nums3[i]+nums4[j]的所有结果放入map,(和，次数)
    //          然后双重遍历nums1和nums2,查找 0 - (nums1[i]+nums2[j]) 是否在map中，然后将次数汇总
    //          时间复杂度O(n^2) 1<=n<=200 可以接受
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        int n = nums1.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                int sum = nums3[i] + nums4[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                int sum = nums1[i] + nums2[j];
                if (map.containsKey(0 - sum))
                    count += map.get(0 - sum);
            }

        return count;
    }

    //Solution2：Map
    //           创建两个map分别存 nums1[i]+nums2[j] 和 nums3[i]+nums4[j]
    //           然后遍历两个map，查找和为500的key，将次数汇总
    //           时间复杂度O(n^2)
    public int fourSumCount2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map12 = new HashMap<>();
        HashMap<Integer, Integer> map34 = new HashMap<>();
        int count = 0;
        int n = nums1.length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                int sum12 = nums1[i] + nums2[j];
                map12.put(sum12, map12.getOrDefault(sum12, 0) + 1);
                int sum34 = nums3[i] + nums4[j];
                map34.put(sum34, map34.getOrDefault(sum34, 0) + 1);
            }

        for (int key12 : map12.keySet())
            for (int key34 : map34.keySet())
                if (key12 + key34 == 0)
                    count += map12.get(key12) * map34.get(key34);

        return count;
    }
}
