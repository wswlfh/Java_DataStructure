package com;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class Partition {
    //排序
    public void sort(int[] data, int lo, int hi) {
        if (lo >= hi) return;
        //分区
        int j = partition(data, lo, hi);
        //对左边进行排序
        sort(data, lo, j - 1);
        //对右边数组排序
        sort(data, j + 1, hi);
    }

    //三路快排Partition

    /**
     * @param arr 要进行Partition的数组,闭区间[l,r]
     * @param l   要进行Partition的数组的元素的区间左边界
     * @param r   要进行Partition的数组的元素的区间右边界
     * @return Partition一次之后的分界点的最左位置
     */
    public static int partition(int[] arr, int l, int r) {
        //区间范围的计算方式是: （(最大值 - 最小值 + 1) + 最小值）
        swap(arr, l, new Random().nextInt(r - l + 1) + l);
        int v = arr[l], i = l + 1, lt = l, gt = r + 1;
        while (i < gt) {
            if (arr[i] < v) {
                lt++;
                swap(arr, lt, i);
            } else if (arr[i] > v) {
                gt--;
                swap(arr, gt, i);
                continue;
            }
            i++;
        }
        swap(arr, l, lt);
        return lt;
    }

    private static void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}
