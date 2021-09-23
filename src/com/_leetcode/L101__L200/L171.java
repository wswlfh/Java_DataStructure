package com._leetcode.L101__L200;

public class L171 {
    //171：找excel列表值
    public static int titleToNumber(String columnTitle) {
        int ans = 0;

        for (int i = columnTitle.length() - 1; i >= 0 ; i--) {
            int temp = columnTitle.charAt(i) - 'A' + 1;
            ans += temp * Math.pow(26,columnTitle.length() - 1 - i);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("FXSHRXW"));
    }
}
