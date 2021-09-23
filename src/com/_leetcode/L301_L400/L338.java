package com._leetcode.L301_L400;

public class L338 {
    /*
    38. 比特位计数
    给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
     */
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for (int i = 0; i <= n; i++) {
            ans[i] = computeOne(i);
        }
        return ans;
    }
    private static  int computeOne(int num){
        if (num == 0 || num == 1)
            return num;
        int ans = 1;
        while (num != 1){
            ans += num % 2;
            num /= 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(computeOne(4));
    }
}
