package com._leetcode.jianzhi;

public class J04 {
    int n, m;

    //Solution1： 二分法 + 递归缩减矩阵规模
    // 每到一个矩阵，以最左上角的元素为起点，对其所在列和行进行二分查找
    // 如果没有，则进入下一个矩阵(剔除起点元素当前所在行和列后剩下的元素)
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;
        n = matrix.length;
        m = matrix[0].length;
        return _find(matrix, target, 0);
    }

    private boolean _find(int[][] matrix, int target, int round) {
        if (round >= n || round >= m) return false;
        if (matrix[round][round] == target) return true;

        if (target <= matrix[round][m - 1]) {
            int l = round;
            int r = m - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (target == matrix[round][mid]) return true;
                else if (target > matrix[round][mid]) l = mid + 1;
                else r = mid - 1;
            }
        }

        if (target <= matrix[n - 1][round]) {
            int l = round;
            int r = n - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (target == matrix[mid][round]) return true;
                else if (target > matrix[mid][round]) l = mid + 1;
                else r = mid - 1;
            }
        }

        return _find(matrix, target, round + 1);
    }


    //Solution2：对比右上角元素
    // 如果右上角元素正好等于target，则返回
    // 如果右上角元素大于target，说明target不在当前列，只能在右上角元素的左面，即剔除当前列，选右上角元素左边的元素作为新的右上角元素
    // 如果右上角元素小于target，说明target不在当前行，只能在右上角元素的下面，即剔除当前行，选右上角元素下边的元素作为新的右上角元素
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;
        int rX = 0;
        int rY = matrix[0].length - 1;
        while (rX < matrix.length && rY >= 0) {
            if (target > matrix[rX][rY])
                rX++;
            else if (target < matrix[rX][rY])
                rY--;
            else
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
