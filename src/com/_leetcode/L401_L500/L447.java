package com._leetcode.L401_L500;

import java.util.HashMap;

public class L447 {

    //Solution：Map
    //          计算每个点到其他点的距离，然后统计距离一样的点，即可算出三元组对数
    //              关键在于：每个点有一个属于自己的map，(k,v) -> (dist,times)，key值为距离，v值为距离的频次
    //              这样三元组数就为：times * (times -1)
    //          例如：到点i(x,y)距离为2的点有3个
    //              则以i为首可以组建的三元组(i,j,k)为 2*(C32) = 2*3  (j和k在3里面选，即3选2),属于算出当前状态，而不依赖于算出全局状态
    //          时间复杂度O(n^2)
    public int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int dist = getDist(points[i], points[j]);
                map.put(dist, map.getOrDefault(dist, 0) + 1);
            }
            for (int dist : map.keySet())
                ans += map.get(dist) * (map.get(dist) - 1);
        }
        return ans;
    }

    //距离相等只需要证明平方和相等即可，不需要开根号
    //因为题目的限制，所以两点距离不会超过 Integer.MAX_VALUE
    private int getDist(int[] x, int[] y) {
        assert x.length == 2;
        return (x[0] - y[0]) * (x[0] - y[0]) + (x[1] - y[1]) * (x[1] - y[1]);
    }

    public static void main(String[] args) {
        int[][] nums = {{0,0},{1,0},{2,0}};
        new L447().numberOfBoomerangs(nums);
    }
}
