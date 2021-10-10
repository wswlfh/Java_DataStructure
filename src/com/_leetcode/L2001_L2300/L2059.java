package com._leetcode.L2001_L2300;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class L2059 {
    public static int minimumOperations(int[] nums, int start, int goal) {
        Deque<int[]> queue = new LinkedList<>();
        //HashSet<Object> used = new HashSet<>();
        boolean[] used = new boolean[1001];
        //used.add(start);
        used[start] = true;
        queue.addLast(new int[]{start, 0});
        while (!queue.isEmpty()) {
            int[] ints = queue.removeFirst();
            int x = ints[0], time = ints[1];
            for (int i = 0; i < nums.length; i++) {
                int a = x + nums[i], b = x - nums[i], c = x ^ nums[i];

                if (a == goal || b == goal || c == goal)
                    return time + 1;

                if (a >= 0 && a <= 1000 && !used[a]) {
                    queue.addLast(new int[]{a, time + 1});
                    used[a] = true;
                }
                if (b >= 0 && b <= 1000 && !used[b]) {
                    queue.addLast(new int[]{b, time + 1});
                    used[b] = true;
                }
                if (c >= 0 && c <= 1000 && !used[c]) {
                    queue.addLast(new int[]{c, time + 1});
                    used[c] = true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        minimumOperations(new int[]{2, 8, 6}, 0, 1);
    }

}
