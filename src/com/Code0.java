package com;

import java.util.Random;

public class Code0 {
    public int Partition(int[] arr, int start, int end) {
        int v = arr[new Random().nextInt(end - start + 1) + start];
        int l = start, r = end + 1;
        swap(arr[start], v);
        int i = l + 1;
        while (i < r) {
            if (arr[i] < v) {
                l++;
                swap(arr[i], arr[l]);
            } else {
                r--;
                swap(arr[i], arr[r]);
                continue;
            }
            i++;
        }
        swap(arr[start], arr[l]);
        return l;
    }
}
