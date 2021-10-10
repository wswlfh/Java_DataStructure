package com._leetcode.L801_L900;

import java.util.*;

public class L900 {

    //Solution：数组模拟map
    //此题的复杂之处在于，如果直接用list存单个数的话，会插入几十亿个数据造成内存溢出
    //因此将list的单个元素设置为一个二元组 Object[key,value]，然后每次进行next就更新value的值
    static class RLEIterator {
        List<Object[]> list;
        Map<Integer, Integer> maps;
        long size = 0;
        boolean empty = false;

        public RLEIterator(int[] encoding) {
            if (encoding.length == 0)
                return;
            assert encoding.length % 2 == 0;


            list = new LinkedList<>();
            for (int i = 0; i < encoding.length; i = i + 2) {
                if (encoding[i] == 0)
                    continue;
                list.add(new Object[]{encoding[i + 1], encoding[i]});
                size += encoding[i];
            }

            System.out.println();
        }

        public int next(int n) {
            if (n > size || empty) {
                empty = true;
                return -1;
            }
            int ans = -1;
            for (Object[] o : list) {
                int key = (int) o[0];
                int value = (int) o[1];

                if (value == 0)
                    continue;

                if (value >= n) {
                    o[1] = value - n;
                    ans = key;
                    break;
                } else if (n > value) {
                    o[1] = 0;
                    n = n - value;
                }

            }
            return ans;
        }
    }

    public static void main(String[] args) {
        //

        RLEIterator rleIterator = new RLEIterator(new int[]{923381016, 843, 898173122, 924, 540599925, 391, 705283400, 275, 811628709, 850, 895038968, 590, 949764874, 580, 450563107, 660, 996257840, 917, 793325084, 82});
        rleIterator.next(2);
    }
}
