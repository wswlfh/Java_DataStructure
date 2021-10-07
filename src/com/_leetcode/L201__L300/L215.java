package com._leetcode.L201__L300;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Random;

public class L215 {
    /*
    215. 数组中的第K个最大元素
    给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
    请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素 ！！！ 指元素可以重复
     */

    //Solution1：优先队列法
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {

            if (pq.size() < k)
                pq.add(nums[i]);
            else if (pq.peek() < nums[i]) {
                pq.remove();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }

    //Solution2：快排法....

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(nums, 4));
    }
}
