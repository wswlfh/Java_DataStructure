package com._leetcode.jianzhi;

import com.Partition;

import java.util.Arrays;
import java.util.Random;

public class J40 {
    //Solution：快排partition
    // 找一个数来排序，如果排完序他的位置index正好在nums[k-1] ，说明已经前k个已经排好了
    // 如果index<k-1，则去它右边找，反之去左边
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || k <= 0 || arr.length == 0 || arr.length < k)
            return new int[0];
        int index = Partition.partition(arr, 0, arr.length - 1);
        int start = 0, end = arr.length - 1;
        while (index != k - 1) {
            if (index < k - 1) {
                start = index + 1;
                index = Partition.partition(arr, start, end);
            } else {
                end = index - 1;
                index = Partition.partition(arr, start, end);
            }
        }
        return Arrays.copyOf(arr, k);
    }
}



