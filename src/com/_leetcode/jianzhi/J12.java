package com._leetcode.jianzhi;

import com.linkedlist.LinkedList;

public class J12 {
    //Solution: 回溯法
    // 注意要设置访问标志位，不能重新访问
    // 注意移动方向：上下左右皆可
    // 使用多段 与或非 进行级联式的结果返回
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (fb(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean fb(char[][] board, char[] words, int i, int j, int k) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != words[k])
            return false;
        if (k == words.length - 1) return true;

        board[i][j] = '\0';
        boolean res = fb(board, words, i + 1, j, k + 1) || fb(board, words, i - 1, j, k + 1) ||
                fb(board, words, i, j + 1, k + 1) || fb(board, words, i, j - 1, k + 1);
        board[i][j] = words[k];
        return res;
    }
}
