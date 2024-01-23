package com._leetcode.L1__L100;

public class L91 {
    public int numDecodings(String s) {
        //Solution：动态规划
        // 高级版的斐波那契数列，爬格子
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) != '0') {
                //取1位时，此位不能位0
                f[i] += f[i - 1];
            }

            // 取两位时，两位要在26之内且首位不能为0
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                f[i] += f[i - 2];
            }

        }
        return f[n];
    }

}
