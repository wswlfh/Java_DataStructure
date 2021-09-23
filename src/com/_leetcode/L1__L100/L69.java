package com._leetcode.L1__L100;

public class L69 {
    //Solution：采用二分法，减小计算大数开销
    public static int mySqrt(int x) {
        if (x == 0 || x == 1)
            return x;
        int l = 0, r = x;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid < x) {
                if ((long) (mid+1) * (mid + 1) > x)
                    return mid;
                l = mid - 1;
            } else if ((long) mid * mid > x)
                r = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int x = 2147483647;
        System.out.println(x);
        System.out.println(mySqrt(2147483647));
    }
}
