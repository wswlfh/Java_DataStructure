package com._leetcode.L1__L100;

public class L48 {
    public  void rotate(int[][] matrix) {
        int n = matrix.length;
        int round = 0;
        while (round < n) {
            int step = n - round - 1;
            for (int i = 0; i < step; i++) {
                rotateOneStep(matrix, round, round, round + 1, matrix[round][round]);
            }
            round += 2;
        }
    }

    private  void rotateOneStep(int[][] matrix, int round, int i, int j, int last) {
        int temp = matrix[i][j];
        matrix[i][j] = last;
        last = temp;
        if (i == round && j == round) return;
        if (i == round && j != matrix.length - round - 1) {
            rotateOneStep(matrix, round, i, j + 1, last);
        } else if (i == matrix.length - round - 1 && j != 0) {
            rotateOneStep(matrix, round, i, j - 1, last);
        } else if (i != round && j == round) {
            rotateOneStep(matrix, round, i - 1, j, last);
        } else if (j == matrix.length - round - 1 && i != matrix.length - round - 1) {
            rotateOneStep(matrix, round, i + 1, j, last);
        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        int x = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = x++;
            }
        }

        System.out.println();
    }
}
