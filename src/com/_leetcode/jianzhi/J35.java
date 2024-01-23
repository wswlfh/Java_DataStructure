package com._leetcode.jianzhi;

public class J35 {
    //Solution:
    // 直接把复制的节点放在原始后面
    // 定位 复制节点的random指针，即原始指针的random.next
    // 分离链表
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        //复制节点
        Node node = head;
        while (node != null) {
            Node copy = new Node(node.val);
            copy.next = node.next;
            node.next = copy;
            node = copy.next;
        }

        //复制random
        for (node = head; node != null; node = node.next.next) {
            node.next.random = node.random == null ? null : node.random.next;
        }

        Node newHead = new Node(-1);
        Node cur = newHead;

        //分离
        for (node = head; node != null && node.next != null; node = node.next) {
            cur.next = node.next;
            node.next = node.next.next;
            cur = cur.next; //cur作为新链表的尾节点
            cur.next = null;
        }
        return newHead.next;
    }
}
