package linkedlist;

import queue.Queue;

public class LinkedListQueue<E> implements Queue<E> {
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

    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void enqueue(E e) {
        if (tail == null) { //1.如果链表为空
            tail = new Node(e);
            head = tail;
        } else {//2.链表不为空
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Queue is empty!");
        E ret = head.e;
        if (head == tail) { //如果链表只有一个元素
            head = null;
            tail = null;
        } else {
            Node newHead = head.next;
            head.next = null;
            head = newHead;
        }
        size--;
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Queue is empty!");
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size is %d\n",getSize()));
        res.append("front| ");
        Node cur = head;
        while (cur != null){
            res.append(cur.e + "->");
        }
        res.append("NULL |tail");

        return res.toString();
    }
}
