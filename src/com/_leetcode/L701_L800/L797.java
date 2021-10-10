package com._leetcode.L701_L800;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L797 {
    LinkedList<Integer> res;
    //boolean[] used;
    List<List<Integer>> ans;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        //used = new boolean[graph.length];
        res = new LinkedList<>();
        ans = new LinkedList<>();
        res.add(0);
        gens(0, graph.length - 1, graph);
        return ans;
    }

    private void gens(int start, int end, int[][] graph) {
        if (start == end) {
            ans.add(new ArrayList<>(res));
            return;
        }

        for (int next : graph[start]){
            res.addLast(next);
            gens(next,end,graph);
            res.removeLast();
        }
    }
}
