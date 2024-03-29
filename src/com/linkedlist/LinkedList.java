package com.linkedlist;

public class LinkedList<E> {
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this.e = e;
            this.next = null;
        }

        public Node() {
            this.e = null;
            this.next = null;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

//add

    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Index must be in [0,size] !");
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    //get
    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Index must be in [0,size) !");
        Node cur = dummyHead.next; //当前 与prev（前一）不同
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Index must be in [0,size) !");
        Node cur = dummyHead.next; //当前 与prev（前一）不同
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    public boolean contains(E e) {
        Node cur = dummyHead.next;
        for (int i = 0; i < size; i++) {
            if (cur.e.equals(e))
                return true;
            cur = cur.next;
        }
//        while (cur!=null){
//            if (cur.e.equals(e))
//                return true;
//            cur = cur.next;
//        }
        return false;
    }

    //remove
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Index must be in [0,size) !");
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;

        return delNode.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format(
                "LinkedList: size = %d\n", getSize()));
        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            res.append(cur + "->");
        }
        res.append("NULL");

        return res.toString();
    }
}
