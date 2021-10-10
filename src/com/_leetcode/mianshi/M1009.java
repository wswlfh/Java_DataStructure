package com._leetcode.mianshi;

public class M1009 {
    int m;
    int n;

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;
        m = matrix.length;
        n = matrix[0].length;
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (find(matrix, target, i, j))
                return true;
            i++;
            j++;
        }
        return false;
    }

    private boolean find(int[][] matrix, int target, int i, int j) {
        int rightMax = matrix[i][n - 1];
        int downMax = matrix[m - 1][j];
        if (target == matrix[i][j] || target == rightMax || target == downMax)
            return true;

        //行
        if (target < matrix[i][n - 1]) {
            int l = j;
            int r = n - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (matrix[i][mid] < target)
                    l = mid + 1;
                else if (matrix[i][mid] > target)
                    r = mid - 1;
                else
                    return true;
            }
        }
        //列
        if (target < matrix[m - 1][j]) {
            int l = i;
            int r = m - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (matrix[mid][j] < target)
                    l = mid + 1;
                else if (matrix[mid][j] > target)
                    r = mid - 1;
                else
                    return true;
            }
        }

        return false;
    }

}
