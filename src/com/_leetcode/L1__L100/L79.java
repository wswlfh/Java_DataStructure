package com._leetcode.L1__L100;

import com.array.Array;

import java.util.Arrays;
import java.util.HashMap;

public class L79 {
    public boolean exist(char[][] board, String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (map.containsKey(board[i][j]))
                    map.put(board[i][j], map.get(board[i][j]) + 1);
                else
                    map.put(board[i][j], 1);
            }
        }
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!map.containsKey(c))
                return false;
            else if (map.containsKey(c) && map.get(c) < 1)
                return false;
            else
                map.put(c, map.get(c) - 1);
        }
        return true;
    }
}
