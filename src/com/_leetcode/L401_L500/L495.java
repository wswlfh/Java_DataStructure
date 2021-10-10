package com._leetcode.L401_L500;

public class L495 {
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = 0;
        int i = 0;
        while (true) {
            if (i == timeSeries.length - 1) {
                ans += duration;
                break;
            }
            if (timeSeries[i + 1] >= timeSeries[i] + duration) {
                ans += duration;
            } else
                ans += timeSeries[i + 1] - timeSeries[i];
            i++;
        }

        return ans;
    }

    public static void main(String[] args) {
    }
}
