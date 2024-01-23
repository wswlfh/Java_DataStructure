package com.sort;

public class BubbleSort {

    // 我们的算法类不允许产生任何实例
    private BubbleSort() {
    }

    public static void sort(int[] arr) {

        int n = arr.length;
        boolean swapped = false;

        while (!swapped) {
            swapped = false;
            for (int i = 1; i < n; i++)
                if (arr[i - 1] > arr[i]) {
                    swap(arr, i - 1, i);
                    swapped = true;
                }
            // 优化, 每一趟Bubble Sort都将最大的元素放在了最后的位置
            // 所以下一次排序, 最后的元素可以不再考虑
            n--;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}