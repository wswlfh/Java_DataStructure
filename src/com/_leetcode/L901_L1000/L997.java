package com._leetcode.L901_L1000;

public class L997 {
    //997. 找到小镇的法官
    public int findJudge(int n, int[][] trust) {
        int[][] arr = new int[n + 1][1];
        for (int[] num : trust) {
            arr[num[0]][0] = 0;
            arr[num[1]][0]++;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0] == n - 1)
                return i;
        }
        return -1;
    }
}
