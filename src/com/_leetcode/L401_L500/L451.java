package com._leetcode.L401_L500;

import java.util.*;

public class L451 {
    //Solution1：Map+优先队列
    //           首先先统计每个字母的频次，然后插入优先队列，排序的规则按照频次
    //           poll出来的是最大频次的字母，然后组合即可
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        //lambda表达式就是好用
        PriorityQueue<Character> pq = new PriorityQueue<>((o1, o2) -> {
            return map.get(o2) - map.get(o1);
        });

        for (int i = 0; i < s.length(); i++)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

        for (char c : map.keySet())
            pq.add(c);

        StringBuilder ans = new StringBuilder();
        while (!pq.isEmpty()) {
            char c = pq.poll();
            for (int i = 0; i < map.get(c); i++) {
                ans.append(c);
            }
        }
        return ans.toString();
    }

    //Solution2：根据Collections.sort()方法 对map中的value进行排序
    //           先存入map,将key存入list，然后重写Comparator
    public String frequencySort2(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

        ArrayList<Character> list = new ArrayList<>(map.keySet());
        //lambda表达式就是好用
        Collections.sort(list, (o1, o2) -> {
            return map.get(o2) - map.get(o1);
        });

        StringBuilder ans = new StringBuilder();
        for (char c : list) {
            for (int i = 0; i < map.get(c); i++)
                ans.append(c);
        }
        return ans.toString();
    }

    public String frequencySort3(String s) {


        return "";
    }


    public static void main(String[] args) {
    }
}
