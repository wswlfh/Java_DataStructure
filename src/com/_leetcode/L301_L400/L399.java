package com._leetcode.L301_L400;

import java.util.*;

public class L399 {

    //恶心： 使用回溯法 有空复盘
    ArrayList<Double> res;
    Map<String, Boolean> used;
    int flag;

    public double[] calcEquation
            (List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, Set<Object[]>> maps = new HashMap<>();
        used = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            double value = values[i];
            String x = equations.get(i).get(0);
            String y = equations.get(i).get(1);
            used.put(x, false);
            used.put(y, false);

            Set<Object[]> setX = maps.containsKey(x) ? maps.get(x) : new HashSet<>();
            setX.add(new Object[]{y, value});
            maps.put(x, setX);

            Set<Object[]> setY = maps.containsKey(y) ? maps.get(y) : new HashSet<>();
            setY.add(new Object[]{x, 1 / value});
            maps.put(y, setY);

        }

        res = new ArrayList<>();
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            flag = 0;
            gens(maps, start, end, 1.0);
            if (flag == 0) res.add(-1.0);
        }
        double[] ans = new double[queries.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    private void gens(HashMap<String, Set<Object[]>> maps, String start, String end, double v) {
        if (!maps.containsKey(start) || flag == 1) //至关重要 找到了就返回，防止重复添加
            return;
        if (start.equals(end)) {
            flag = 1;
            res.add(v);
            return;
        }
        for (Object[] obj : maps.get(start)) {
            String key = (String) obj[0];
            double value = (double) obj[1];
            if (!used.get(key)) {
                used.put(key, true);
                gens(maps, key, end, value * v);
                used.put(key, false);
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        equations.add(new ArrayList<>(list));
        list.clear();

        list.add("b");
        list.add("c");
        equations.add(new ArrayList<>(list));
        list.clear();

        list.add("bc");
        list.add("cd");
        equations.add(new ArrayList<>(list));
        list.clear();

        double[] values = {1.5, 2.5, 5.0};

        HashMap<String, Set<Object[]>> maps = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            double value = values[i];
            String x = equations.get(i).get(0);
            String y = equations.get(i).get(1);

            Set<Object[]> setX = maps.containsKey(x) ? maps.get(x) : new HashSet<>();
            setX.add(new Object[]{y, value});
            maps.put(x, setX);

            Set<Object[]> setY = maps.containsKey(y) ? maps.get(y) : new HashSet<>();
            setY.add(new Object[]{x, 1 / value});
            maps.put(y, setY);

        }

        System.out.println();
    }
}
