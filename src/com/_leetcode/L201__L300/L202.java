package com._leetcode.L201__L300;

import java.util.HashMap;
import java.util.HashSet;

public class L202 {
    //202.快乐数
    /* Solution：用set记录中间数
    问题分析：
    设getNext(n)为n经过各位数平方和相加的一个数，问题解决关键在于 getNext(n)什么时候为1
    情况1：如果运气好，一直递归getNext(n)可能会得到结果
    情况2：如果进入一个循环，就永远得不到 如：58->89->145->...->58
    情况3：如果数很大，一直算下去。实际这个情况并不存在，因为不管多大的数，经过getNext(n)计算都会变成一个很小的数，从而为1或进入循环
    综上：使用HashSet解决循环问题即可
     */
    //Solution1：使用哈希集合
    public boolean isHappy(int n) {
        HashSet<Object> set = new HashSet<>();
        while (n != 1) {
            set.add(n);
            n = getNext(n);
            if (set.contains(n)) //包含之前的数，说明陷入循环
                return false;
        }
        return true;
    }

    private int getNext(int n) {
        int res = 0;
        while (n != 0) {
            res += (n % 10) * (n % 10);
            n = n / 10;
        }
        return res;
    }


    public static void main(String[] args) {


    }
}
