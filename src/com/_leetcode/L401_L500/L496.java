package com._leetcode.L401_L500;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class L496 {
    public int getIndex(int[] arr, int e) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == e)
                return i;
        }
        return -1;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        LinkedList<Integer> res = new LinkedList<>();
        for (int i = 0; i < nums1.length; i++) {
            int index = getIndex(nums2, nums1[i]);
            int flag = 0;
            for (int j = index + 1; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    res.add(nums2[j]);
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) res.add(-1);
        }

        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
