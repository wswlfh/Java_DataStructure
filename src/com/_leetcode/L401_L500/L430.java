package com._leetcode.L401_L500;

public class L430 {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public Node flatten(Node head) {
        if (head == null)
            return null;
        _flatten(head);
        return head;
    }

    //返回尾指针 然后就有得到最子链表的头和尾 将子链表插入上层链表的孩子处，将孩子置空
    //
    private Node _flatten(Node head) {
        Node node = head;
        while (node.next != null || node.next == null && node.child != null) {
            if (node.child != null) {
                Node tail = _flatten(node.child);
                tail.next = node.next;
                if (tail.next != null)
                    tail.next.prev = tail;
                node.next = node.child;
                node.next.prev = node;
                node.child = null;
            }
            node = node.next;
        }
//        if (node.child != null) {
//            node.next = node.child;
//            node.child = null;
//            node.next.prev = node;
//            return node.next;
//        }
        System.out.println(head.val + " " + node.val);

        return node;
    }
}
