package com._leetcode.jianzhi;

import com._leetcode.ListNode;

public class J30 {
    //Solution: 链表实现栈
    // 最小值的更新和维护问题，其实根本不用更新和维护，每次节点进来保存当前链表最小值即可
    // 因为栈前面最小值出栈并不会影响到后边剩下的的最小值，类似于快照机制
    class MinStack {
        private Node head;

        public MinStack() {

        }

        public void push(int x) {
            //每个节点存的是当前节点起到末尾的子链表的最小值，只存当前链表最小值即可，弹出不影响
            //根本不用更新最小值
            if (head == null)
                head = new Node(x, x, null);
            else
                head = new Node(x, Math.min(head.min, x), head);
        }

        public void pop() {

            head = head.next;
        }

        public int top() {

            return head.val;
        }

        public int min() {

            return head.min;
        }

        private class Node {

            int val;
            int min;
            Node next;

            public Node(int val, int min, Node next) {

                this.val = val;
                this.min = min;
                this.next = next;
            }
        }
    }

    public static void main(String[] args) {

    }
}
