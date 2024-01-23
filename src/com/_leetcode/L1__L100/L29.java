package com._leetcode.L1__L100;

public class L29 {
    public static int divide(int dividend, int divisor) {
        //Sp
        if (dividend == 0) return 0;

        //取符号并转正
        boolean flag = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        //计算
        int ans = 0,sum = 0;
        if (b == 1) return (int) (flag ? a : -a);

        while (a >= b) {
            sum += b;
            if (sum > a) break;
            ans++;
        }

        return flag ? ans : -ans;
    }

    public static void main(String[] args) {

        System.out.println(divide(-2147483648 ,-1));
    }

}
