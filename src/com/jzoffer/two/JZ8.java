package com.jzoffer.two;

import java.util.Deque;
import java.util.LinkedList;

public class JZ8 {
    public static int minSubArrayLen(int target, int[] nums) {
        Deque<Integer> queue = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            queue.addLast(nums[i]);
            sum += nums[i];
            if (sum >= target) {
                while (true) {
                    if (sum >= target) {
                        min = Math.min(min, queue.size());
                        sum -= queue.removeFirst();
                    } else
                        break;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(15, new int[]{5,1,3,5,10,7,4,9,2,8}));
    }
}
