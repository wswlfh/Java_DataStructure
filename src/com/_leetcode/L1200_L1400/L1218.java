package com._leetcode.L1200_L1400;

import java.util.*;

public class L1218 {

    //Solution1：链表链接法 ：不错的解法，可惜怎么优化都超时
    public static int longestSubsequence(int[] arr, int difference) {
        Set<Deque<Integer>> lists = new HashSet<>();
        int max = 1;

        for (int i = arr.length - 1; i >= 0; i--) {
            int flag = 0;
            for (Deque<Integer> list : lists) {
                if (list.getFirst() - arr[i] == difference) {
                    list.addFirst(arr[i]);
                    flag = 1;
                    max = Math.max(max,list.size());
                }
            }
            if (flag == 0) {
                Deque<Integer> list = new LinkedList<>();
                list.addFirst(arr[i]);
                lists.add(list);
            }
        }
        return max;
    }

    //Solution2：如果考虑到需要维护多种情况，就使用HM来维护就很方便
    public int longestSubsequence2(int[] arr, int difference) {
        int ans = 0;
        Map<Integer, Integer> dp = new HashMap<Integer, Integer>();
        for (int v : arr) {
            dp.put(v, dp.getOrDefault(v - difference, 0) + 1);
            ans = Math.max(ans, dp.get(v));
        }
        return ans;
    }

    public static void main(String[] args) {


        longestSubsequence(new int[]{1, 5, 7, 8, 5, 3, 4, 2, 1}, -2);
    }
}
