package com._leetcode.L501_L600;

import java.util.HashSet;
import java.util.Stack;

public class L575 {

    public int distributeCandies(int[] candyType) {
        if (candyType.length == 2)
            return 1;

        HashSet<Integer> set = new HashSet<>();


        for (int i = 0; i < candyType.length; i++) {
            set.add(candyType[i]);
        }
        return set.size() > candyType.length/2 ? candyType.length/2 : set.size();
    }
}
