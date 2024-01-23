package com._leetcode.L901_L1000;

import java.util.*;

public class L954 {
    //Solution: Hash+排序，关键在于x和2x的配对
    public static boolean canReorderDoubled(int[] arr) {

        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : arr) {
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        }
        if (cnt.getOrDefault(0, 0) % 2 != 0) {
            return false;
        }

        List<Integer> vals = new ArrayList<>();
        for (int x : cnt.keySet()) {
            vals.add(x);
        }
        Collections.sort(vals, (a, b) -> Math.abs(a) - Math.abs(b));

        for (int x : vals) {
            //这里很妙，查2x，如果找不到则置0，如果x已被减为0 则为0<0 如果x还剩余，则为0 < 正数
            if (cnt.getOrDefault(2 * x, 0) < cnt.get(x)) { // 无法找到足够的 2x 与 x 配对
                return false;
            }
            cnt.put(2 * x, cnt.getOrDefault(2 * x, 0) - cnt.get(x));
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canReorderDoubled(new int[]{4,-4,4,-2,-4,-8}));
    }
}
