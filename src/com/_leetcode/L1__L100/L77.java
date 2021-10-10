package com._leetcode.L1__L100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L77 {
    /*
    77. 组合 中等
    给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
     */
    LinkedList<Integer> res = new LinkedList<>();
    List<List<Integer>> list = new LinkedList<>();
    public  List<List<Integer>> combine(int n, int k) {
        gens(1, n, k);
        return list;
    }

    private void gens(int start, int n, int k) {
        if (res.size() == k) {
            list.add(new LinkedList<>(res));
            return;
        }

        //剪枝 --- 定标
        //如 5个数取2个数的组合数 可有
        //(1,2),(1,3),(1,4),(1,5)
        //(2,3),(2,4),(2,5)
        //(3,4),(3,5)
        //(4,5)
        //也就是说 只用处理 start = 1,2,3,4 的数就好了，不用考虑5开头的数
        //此时最后一个能处理的数的索引为4 也就是 n - (k-res.size()) + 1
        //每次递归要对新数组定一次标(找到最后一个能处理的数的索引)
        //因为 res.size()在变，所以每一个新递归子数组的标也在变(往后退)
        for (int i = start; i <= n - (k - res.size()) + 1; i++) {
            res.addLast(i);
            gens(i + 1, n, k);
            res.removeLast();
        }
    }

    public static void main(String[] args) {
        new L77().combine(4,2);
    }
}
