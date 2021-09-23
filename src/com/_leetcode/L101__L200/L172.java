package com._leetcode.L101__L200;

import java.util.Arrays;

public class L172 {
    /*
    172. 阶乘后的零
    给定一个整数 n ，返回 n! 结果中尾随零的数量。
     */
    //Solution: 没有那么多花里胡哨，直接检查5的因子个数，5因子个数即为0个数
    public int trailingZeroes(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 5 == 0) {
                int t = i;
                while (t % 5 == 0) {
                    t = t / 5;
                    ans++;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new L172().trailingZeroes(723));
    }
}
