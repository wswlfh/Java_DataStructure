package com._leetcode.L201__L300;

import java.util.Deque;
import java.util.LinkedList;

public class L209 {
    //Solution1：使用队列，记录队中元素之和sum
    //                   如果sum < target，将数组元素依次入队(保证连续)
    //                   如果sum >= target,说明该连续子数组满足条件，然后记录其长度(用minLen来对比)
    //           最终minLen的长度即为最小连续子数组的长度，如果无变化(较于minLen初值)，说明无解，返回0
    public int minSubArrayLen(int target, int[] nums) {
        Deque<Integer> queue = new LinkedList<>();
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (sum < target) {
                queue.addLast(nums[i]);
                sum += nums[i];
            }
            while (sum >= target) {
                minLen = Math.min(minLen, queue.size());
                sum -= queue.removeFirst();
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    //Solution2：滑动窗口
    //			 实际上就是O(1)级别的队列，用两个索引(左l，右r)维护队首和队尾
    public int minSubArrayLen2(int target, int[] nums) {
        int l = 0, r = -1;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        while (l < nums.length) {
            if (sum < target && r < nums.length - 1)
                sum += nums[++r];
            else
                sum -= nums[l++];
            if (sum >= target)
                minLen = Math.min(minLen, r - l + 1);
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
