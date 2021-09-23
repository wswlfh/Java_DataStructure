package com._leetcode.L1__L100;

import com._leetcode.ListNode;

import java.util.Stack;

public class L2 {
    /*
    2. 两数相加
    给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        Stack<ListNode> stack = new Stack<>();
        int carry = 0;
        while (l1 != null || l2 != null) {
            ListNode node = new ListNode(-1);
            if (l1 != null && l2 != null) {
                node.val = l1.val + l2.val + carry;
                carry = node.val / 10;
                node.val = node.val % 10;
                stack.push(node);
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 == null) {
                node.val = l2.val + carry;
                carry = node.val / 10;
                node.val = node.val % 10;
                stack.push(node);
                l2 = l2.next;
            } else {
                node.val = l1.val + carry;
                carry = node.val / 10;
                node.val = node.val % 10;
                stack.push(node);
                l1 = l1.next;
            }
        }
        if (carry == 1)
            stack.push(new ListNode(1));
        ListNode newHead = new ListNode(-1);
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            node.next = newHead.next;
            newHead.next = node;
        }
        return newHead.next;
    }
}
