package com._leetcode.L1__L100;

public class L70 {
    public int climbStairs(int n) {
        int arr[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i <= 2) {
                arr[i] = i;
            } else
                arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }
}
