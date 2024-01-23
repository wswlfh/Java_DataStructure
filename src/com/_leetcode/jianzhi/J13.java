package com._leetcode.jianzhi;

public class J13 {
    int m, n;
    boolean[][] flag;

    public int movingCount(int k, int rows, int cols) {
        m = rows;
        n = cols;
        flag = new boolean[m][n];
        return fb(k, 0, 0);
    }

    private int fb(int k, int i, int j) {
        if (i >= m || i < 0 || j >= n || j < 0 || getSum(i) + getSum(j) > k)
            return 0;

        flag[i][j] = true;
        int count = 0;
        count = 1 + fb(k, i + 1, j) + fb(k, i - 1, j) + fb(k, i, j + 1) + fb(k, i, j - 1);
        flag[i][j] = false;
        return count;
    }

    //计算一个数的各个位数上的数字之和
    private int getSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }
}
