package com.graph;

import java.util.Stack;
import java.util.Vector;

public class Path {
    Graph G;
    private boolean[] visited;
    private int s;
    private int[] from;

    Path(Graph G, int s) {
        this.G = G;
        this.s = s;
        visited = new boolean[G.V()];
        from = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            visited[i] = false;
            from[i] = -1;
        }

        dfs(s);
    }

    private void dfs(int v) {
        visited[v] = true;
        for (int i : G.adj(s)) {
            if (!visited[i]) {
                from[i] = v;
                dfs(i);
            }
        }
    }

    // 查询从s点到w点是否有路径
    boolean hasPath(int w) {
        assert w >= 0 && w < G.V();
        return visited[w];
    }

    Vector<Integer> path(int w) {
        assert hasPath(w);
        Stack<Integer> stack = new Stack<>();
        int p = from[w];
        while (p != -1) {
            stack.push(p);
            p = from[p];
        }
        Vector<Integer> res = new Vector<>();
        while (!stack.isEmpty())
            res.add(stack.pop());

        return res;
    }

    // 打印出从s点到w点的路径
    void showPath(int w) {

        assert hasPath(w);

        Vector<Integer> vec = path(w);
        for (int i = 0; i < vec.size(); i++) {
            System.out.print(vec.elementAt(i));
            if (i == vec.size() - 1)
                System.out.println();
            else
                System.out.print(" -> ");
        }
    }

}
