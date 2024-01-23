package com._leetcode.L1__L100;

import java.util.Arrays;

public class L31 {
    //Solution：排序
    // 下一个序列，从后往前找第i元素，从第i元素开始往后找，找到一个刚好比num[i]大的元素num[j]
    // 互换后，将[i,n)的元素重新进行小到大的排序即可
    public void nextPermutation(int[] nums) {
        // 7 8 2 1 -> 8 1 2 7
        // 1278 1287 1728 1782
        int i;
        for (i = nums.length - 1; i >= 0; i--) {
            boolean find = false;
            int least = Integer.MAX_VALUE;
            int index = -1;
            for (int j = i + 1; j < nums.length; j++) {
                //找到一个刚好比自己大的
                if (nums[j] > nums[i] && nums[j] < least) {
                    least = nums[j];
                    index = j;
                    find = true;
                }
            }
            if (find) {
                int t = nums[index];
                nums[index] = nums[i];
                nums[i] = t;
                break;
            }
        }
        Arrays.sort(nums, i + 1, nums.length);
        for (int j = 0; j < nums.length; j++) {
            if (j == 0) System.out.print("[");
            System.out.print(nums[j]);
            System.out.print(j == nums.length - 1 ? "]" : ",");
        }
    }


    public static void main(String[] args) {
        new L31().nextPermutation(new int[]{1, 3, 2});
    }
}
