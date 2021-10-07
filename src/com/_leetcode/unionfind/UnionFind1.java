package com._leetcode.unionfind;

public class UnionFind1 implements UF {
    private int[] id;

    UnionFind1(int size) {
        id = new int[size];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    private int find(int p) {
        if (p < 0 || p > id.length)
            throw new IllegalArgumentException("index is illegal");
        return id[p];
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        if (isConnected(p, q))
            return;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == find(p))
                id[i] = find(q);
        }
    }
}
