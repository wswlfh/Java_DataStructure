package com._leetcode.jianzhi;

public class J15 {
    //Solution1: 左移，无论带不带符号位，左移后右边都补0；右移，补符号位
    // 适用JAVA：因为java的int类型默认为有符号数，然后左移，如果符号位变成1，则说明是负数，可以不断左移，判断为负的次数，即为1的个数
    public int hammingWeight1(int n) {
        int ans = 0;

        while (n != 0) {
            if (n < 0)
                ans++;
            n = n << 1;
        }
        return ans;
    }

    //Solution2: 减一法
    public int hammingWeight2(int n) {
        int ans = 0;
        while (n != 0) {
            n = n & (n - 1);
            ans++;
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new J15().hammingWeight1(128));
    }
}
