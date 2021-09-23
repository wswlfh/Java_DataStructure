package com._leetcode.L801_L900;

import java.util.HashMap;
import java.util.Stack;

public class L860 {
    //860. 柠檬水找零
    public boolean lemonadeChange(int[] bills) {
        if (bills[0] != 5) //第一张如果找不了就直接false
            return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(5, 0);
        map.put(10, 0);
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) //5块大钞通通入账
                map.put(5, map.get(5) + 1);
            else if (bills[i] == 10) { //10块就给他找5块，然后更新value
                if (map.get(5) >= 1) {
                    map.replace(5, map.get(5) - 1);
                    map.replace(10, map.get(10) + 1);
                } else
                    return false;
            } else { //20块看有没有1张10块或3张5块
                if (map.get(10) >= 1 && map.get(5) >= 1) {
                    map.replace(10, map.get(10) - 1);
                    map.replace(5, map.get(5) - 1);
                } else if (map.get(10) < 1 && map.get(5) >= 3) {
                    map.replace(5, map.get(5) - 3);
                } else
                    return false;
            }
        }
        //其实用二维数组也可以实现，速度更快，开销更小
        return true;
    }

    //Solution2：二维数组
    public boolean lemonadeChange2(int[] bills) {
        if (bills[0] != 5) //第一张如果找不了就直接false
            return false;
        int[][] arr = new int[2][1];
        for (int bill : bills) {
            if (bill == 5) //5块大钞通通入账
                arr[0][0]++;
            else if (bill == 10) { //10块就给他找5块，然后更新value
                if (arr[0][0] >= 1) {
                    arr[0][0]--;
                    arr[1][0]++;
                } else
                    return false;
            } else { //20块看有没有1张10块或3张5块
                if (arr[1][0] >= 1 && arr[0][0] >= 1) {
                    arr[1][0]--;
                    arr[0][0]--;
                } else if (arr[1][0] < 1 && arr[0][0] >= 3) {
                    arr[0][0] = arr[0][0] - 3;
                } else
                    return false;
            }
        }
        return true;
    }
}
