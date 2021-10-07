package com._leetcode.unionfind;

public class UnionFind3 implements UF{
    private int[] parent; //节点存的是父节点的值
    private int[] sz; //每一个根节点，包括自己以及所有孩子节点个数

    UnionFind3(int size){
        parent = new int[size];
        sz = new int[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i; //一开始每个节点都指向自己
            sz[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    private int find(int p){ // 找父节点 O(h)级别
        if (p < 0 || p > parent.length)
            throw new IllegalArgumentException("index is illegal");
        while (parent[p] !=p){
            p = parent[p];
        }
        return p;
    }
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        //O(1)级别
        //找到两个元素根节点，让其中一个根节点指向另一个根节点
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot)
            return;
        if (sz[pRoot] < sz[qRoot]){
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }else {
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
    }
}
