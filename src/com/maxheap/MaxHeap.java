package com.maxheap;

import com.array.Array;

public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    MaxHeap() {
        data = new Array<>();
    }


    //------------传入整个数组进行Heapify：以数组直接建堆
    MaxHeap(E[] arr) {
        data = new Array<>(arr);
        for (int i = parent(size() - 1); i >= 0; i--) {
            siftDown(i); //要用siftDown 让所有非叶子节点的元素全部沉下来
        }
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    //------------------------------节点-----------------------------------
    //获取父节点
    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("root has no parent!");
        return (index - 1) / 2;
    }

    //左节点
    private int leftChild(int index) {
        if (index < 0 || 2 * index + 1 >= size())
            throw new IllegalArgumentException("index is illegal");
        return 2 * index + 1;
    }

    //右节点
    private int rightChild(int index) {
        if (index < 0 || 2 * index + 2 >= size())
            throw new IllegalArgumentException("index is illegal");
        return 2 * index + 2;
    }

    //---------------------增删改查-------------------------
    //添加
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    //上浮
    private void siftUp(int k) {
        while (k > 0 && data.get(k).compareTo(data.get(parent(k))) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    //找最大
    public E findMax() {
        if (size() == 0)
            throw new IllegalArgumentException("heap is empty !");
        return data.get(0);
    }

    //取出最大，维护堆结构
    public E extractMax() {
        E ret = findMax();
        data.swap(0, size() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    private void siftDown(int k) {
        //如果没有左孩子，则没有必要进行siftDown操作
        //因为左孩子索引始终比右孩子小1，所以右孩子没必要在此判断
        while (leftChild(k) < size()) {
            int j = leftChild(k);
            //rightChild(k) 实际上 就是 j+1
            //这里的逻辑是，如果节点的右孩也存在并且大于左孩子，则就交换最大的那个
            //后面交换是k和j，所以这里更新j
            if (rightChild(k) < size() && data.get(j).compareTo(data.get(j + 1)) < 0)
                j = j + 1;
            data.swap(k, j);
            k = j;
        }
    }

    //取出最大元素，并加入一个元素：只需要将data.get(0)替换即可
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }

}
