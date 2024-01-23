package com._leetcode.jianzhi;

public class J16 {
    //Solution：注意边界+二分计算
    public double myPow(double x, int n) {
        // 边界问题：底数为0，如果n<0 要求倒数，则会出错
        if (Double.compare(x, 0) == 0) {
            if (n < 0) throw new IllegalArgumentException("非法输入");
            return 0;
        }
        double ans;
        //计算：循环计算太慢超时，使用巧算：二分计算法 2^32 = 2^16 x 2^16 = (2^8 x 2^8) x (2^8 x 2^8) .....一直递归下去
//        for (int i = 0; i < Math.abs(n) ; i++) {
//            ans *= x;
//        }
        ans = compute(x, Math.abs(n));
        return n > 0 ? ans : 1 / ans;
    }

    private double compute(double x, int abs) {
        if (abs == 0) return 1;
        if (abs == 1) return x;
        double res = compute(x, abs / 2);
        res *= res;
        if (abs % 2 != 0)  //判断是否为奇数，是的话要多乘一次
            res = res * x;
        return res;
    }


    public static void main(String[] args) {
        System.out.println(Double.compare(0, -0.31221421421421));
    }
}
