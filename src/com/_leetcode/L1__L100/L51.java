package com._leetcode.L1__L100;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class L51 {
    //51 N皇后问题

    /**
     * <p>Solution1：回溯法，选取一行中的一点，计算其下一行是否有一点满足发放置条件
     * <p>放置条件即为：非同列、非同行、非对角线(正反两条)
     * <p>如何快速判断是否满足条件：使用三个数组 存储同列 同对角线的判定布尔值
     * <p>当前行为 index， 则下一次递归传入index+1 就避免同行
     * <p>标记 当前点的(index,i) 同列col[i]、同对角线dia1[i+index]、dia1[i-index+n-1] 为true，回溯完后重新置false
     * <p>关于对角线：如果为正对角线，点(i,j) 的 i+j 为固定值；如果为反对角线，i-j 为固定值，但是为了不让数组越界，加上n-1便能够用数组表示
     */
    LinkedList<Integer> res;
    boolean[] col;
    boolean[] dia1;
    boolean[] dia2;

    public List<List<String>> solveNQueens(int n) {
        res = new LinkedList<>();
        LinkedList<List<String>> list = new LinkedList<>();

        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];

        nQueenGen(n, 0, list);
        return list;
    }

    private void nQueenGen(int n, int index, LinkedList<List<String>> list) {
        if (index == n) //程序顺利进行完成最后一个点的放置，即找到N皇后的一个结构
        {
            list.add(ansGen(res));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!col[i] && !dia1[i + index] && !dia2[i - index + n - 1]) {
                col[i] = true;
                dia1[i + index] = true;
                dia2[i - index + n - 1] = true;
                res.addLast(i);
                nQueenGen(n, index + 1, list);
                res.removeLast();
                col[i] = false;
                dia1[i + index] = false;
                dia2[i - index + n - 1] = false;
            }
        }
        return;
    }

    private List<String> ansGen(LinkedList<Integer> res) {
        LinkedList<String> ans = new LinkedList<>();


        for (int i = 0; i < res.size(); i++) {
            char[] temp = new char[res.size()];
            Arrays.fill(temp,'.');
            temp[res.get(i)] = 'Q';
            ans.addLast(String.valueOf(temp));
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<String>> list = new L51().solveNQueens(4);
        System.out.println(list);
    }
}
