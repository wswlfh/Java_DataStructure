package com._leetcode.unionfind;

public interface UF {
    int getSize();
    boolean isConnected(int p,int q);
    void unionElements(int p,int q);
}
