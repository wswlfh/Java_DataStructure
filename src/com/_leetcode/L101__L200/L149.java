package com._leetcode.L101__L200;

import java.util.HashMap;

public class L149 {

    //Solution：Map
    //          同L447，每个点一个map，记录其他点到当前点的斜率和点数，(k,v) -> (K,times)
    //              到当前点同斜率的点必在同一直线上
    //              遍历map，寻找斜率相同的点数的最大值，在同一直线的点数即为同斜率点数+自身 (times+1)
    public int maxPoints(int[][] points) {
        int n = points.length;
        int ans = 1; //若points只有一个点，最坏情况就是一个点成一条直线
        for (int i = 0; i < n; i++) {
            HashMap<Double, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                double K = getK(points[i], points[j]);
                map.put(K, map.getOrDefault(K, 0) + 1);
            }
            for (double K : map.keySet()) {
                ans = Math.max(ans, map.get(K) + 1);
            }
        }
        return ans;
    }

    private double getK(int[] x, int y[]) {
        assert x.length == 2 && y.length == 2;
        return x[0] == y[0] ? 20001.0 : (double) (y[1] - x[1]) / (y[0] - x[0]);
    }

    public static void main(String[] args) {

    }
}
