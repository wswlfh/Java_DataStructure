package com._leetcode.L1001_L1100;

import java.util.Arrays;
import java.util.LinkedList;

public class L1052 {

    int max = Integer.MIN_VALUE;
    int[] Customers;
    int[] Grumpy;

    //Solution1：超时
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        if (n == 1)
            return customers[0];
        Customers = customers;
        Grumpy = grumpy;
        for (int i = 0; i < n - minutes + 1; i++) {
            gens(0, minutes);
        }
        return max;
    }


    private void gens(int start, int k) {
        int[] temp = new int[Grumpy.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = Grumpy[i] == 0 ? 1 : 0;
        }
        int sum = 0;
        for (int i = start; i < k + start; i++) {
            temp[i] = 1;
        }
        System.out.println(Arrays.toString(temp));

        for (int i = 0; i < temp.length; i++) {
            sum += Customers[i] * temp[i];
        }
        max = Math.max(max, sum);
    }

    //Solution：动态规划
    //memo[i] = memo[i+1] + (grumpy[i] == 0 ? 1 : 0) * customers[i]
    public int maxSatisfied2(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        if (n == 1)
            return customers[0];
        int[] memo1 = new int[n]; //memo[i]表示 未修改时，区间[i,n-1]的满意值
        //memo[i] = memo[i+1] + (grumpy[i] == 0 ? 1 : 0) * customers[i]
        memo1[n-1] = (grumpy[n-1] == 0 ? 1 : 0) * customers[n-1];
        for (int i = n - 2; i >= 0; i--) {
            memo1[i] = (grumpy[i] == 0 ? 1 : 0) * customers[i] + memo1[i + 1];
        }

        int ans = 0;
        for (int i = 0; i <= n - minutes; i++) {
            int sum = 0;
            if (i != 0) {
                sum += memo1[0]- memo1[i];
            }
            for (int j = i; j < i + minutes; j++) {
                sum += customers[j];
            }
            if (i != n - minutes) {
                sum += memo1[i + minutes];
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public static void main(String[] args) {
        L1052 l1052 = new L1052();
        l1052.maxSatisfied2(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3);
    }
}
