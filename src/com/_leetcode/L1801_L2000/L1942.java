package com._leetcode.L1801_L2000;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class L1942 {
    boolean[] used;//记录椅子使用情况
    int firstUnused = 0; //维护第一个未使用过的椅子的索引,比从头到尾查快一倍
    int[] targetNums;//记录每个人使用过哪一把椅子

    //Solution1：模拟计时法
    //使用两个map 记录到达和离开的时间和该索引
    //模拟时间1-10000，优先处理离开的索引
    public int smallestChair(int[][] times, int targetFriend) {
        HashMap<Integer, Integer> arMap = new HashMap<>();
        HashMap<Integer, List<Integer>> leMap = new HashMap<>();

        used = new boolean[times.length + 1];
        targetNums = new int[times.length];

        for (int i = 0; i < times.length; i++) {
            int arrival = times[i][0];
            int leaving = times[i][1];
            arMap.put(arrival, i);

            List list = leMap.containsKey(leaving) ? leMap.get(leaving) : new LinkedList();
            list.add(i);
            leMap.put(leaving, list);

        }

        for (int i = 1; i <= 100000; i++) {
            //leaving
            if (leMap.containsKey(i)) {
                for (int index : leMap.get(i)) {
                    used[targetNums[index]] = false;
                    firstUnused = Math.min(firstUnused, targetNums[index]);
                }
            }
            //arrival
            if (arMap.containsKey(i)) {
                int index = arMap.get(i);
                //apply(index);
                used[firstUnused] = true;
                targetNums[index] = firstUnused;
                while (used[firstUnused])
                    firstUnused++;
            }


        }

        return targetNums[targetFriend];
    }

    //从头到尾查第一个空位
    private void apply(int index) {
        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                used[i] = true;
                targetNums[index] = i;
                break;
            }
        }
    }

    public static void main(String[] args) {

        new L1942().smallestChair(new int[][]{{33889, 98676}, {80071, 89737}, {44118, 52565}, {52992, 84310}, {78492, 88209}, {21695, 67063}, {84622, 95452}, {98048, 98856}, {98411, 99433}, {55333, 56548}, {65375, 88566}, {55011, 62821}, {48548, 48656}, {87396, 94825}, {55273, 81868}, {75629, 91467}},
                6);
    }

}
