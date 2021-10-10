package com._01KnapsackProblem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class KnapsackProblem {

    //假设有n件物品，背包容量为c
    //每件物品的重量为w,价值为v
    //求 在不超过背包容量的前提下，所放入物品价值之和的最大值
    int[] weight; //单件物品重量
    int[] value;  //单件物品价值

    int[][] memo; //记录f(i,c)

    // 状态转移方程：f(i,c) = max{ f(i-1,c) , v(i) + f(i-1,c - v(i)) } {i>=0,c>=0}
    public void knapsack01(int n, int[] weight, int[] value, int capacity) {
        this.weight = weight;
        this.value = value;

        memo = new int[n][capacity+1];
        for (int[] nums : memo) {
            Arrays.fill(nums, -1);
        }

        System.out.println(bestValue(n - 1, capacity));
        System.out.println(bestValueNR(n, capacity));
    }

    private int bestValue(int index, int capacity) {
        if (index < 0 || capacity <= 0)
            return 0;
        if (memo[index][capacity] != -1)
            return memo[index][capacity];

        int branch1 = bestValue(index - 1, capacity);
        int branch2 = (weight[index] > capacity) ? 0 :
                value[index] + bestValue(index - 1, capacity - weight[index]);
        memo[index][capacity] = Math.max(branch1, branch2);

        return memo[index][capacity];
    }

    private int bestValueNR(int n, int capacity) {
        for (int i = 0; i <= capacity; i++) {
            memo[0][i] = (weight[0] > i) ? 0 : weight[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= capacity; j++) {
                int branch1 = memo[i - 1][j];
                int branch2 = (weight[i] > j) ? 0 : value[i] + memo[i - 1][j - weight[i]];
                memo[i][j] = Math.max(branch1, branch2);
            }
        }
        return memo[n-1][capacity];
    }

    public static void main(String[] args) {
        int[] weight = {1, 2, 3};
        int[] value = {6, 10, 12};
        new KnapsackProblem().knapsack01(3,weight,value,5);
    }
}
