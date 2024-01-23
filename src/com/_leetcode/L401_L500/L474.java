package com._leetcode.L401_L500;

import java.util.Arrays;
import java.util.function.Consumer;

public class L474 {
    //Solution：多维度背包问题
    int[][][] memo;

    public int findMaxForm(String[] strs, int m, int n) {
        memo = new int[strs.length][m + 1][n + 1];
        Arrays.stream(memo).forEach(arrs -> Arrays.stream(arrs).forEach(arr -> Arrays.fill(arr,-1)));
//        for (int i = 0; i < strs.length; i++) {
//            for (int j = 0; j <= m; j++) {
//                for (int k = 0; k <= n; k++) {
//                    memo[i][j][k] = -1;
//                }
//            }
//        }
        return fb(strs, 0, m, n);
    }

    int fb(String[] strs, int index, int m, int n) {
        //多维度背包问题要用与！！ &&&&&&&&
        if (index >= strs.length || m <= 0 && n <= 0) return 0;
        if (memo[index][m][n] != -1) return memo[index][m][n];
        int res1 = 0, res2 = 0;

        //选
        int[] count = compute01(strs[index]);
        if (m - count[0] >= 0 && n - count[1] >= 0)
            res2 = 1 + fb(strs, index + 1, m - count[0], n - count[1]);

        //不选
        res1 = fb(strs, index + 1, m, n);

        memo[index][m][n] = Math.max(res1, res2);
        return memo[index][m][n];
    }

    int[] compute01(String s) {
        int one = 0, zero = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') zero++;
            if (s.charAt(i) == '1') one++;
        }
        return new int[]{zero, one};
    }

    public static void main(String[] args) {
        System.out.println(new L474().findMaxForm(new String[]{"1","0"}, 1, 1));
    }

}
