package com._leetcode.L1__L100;

import com._leetcode.ListNode;

import java.util.Stack;

public class L2 {
    /*
    2. 两数相加
    给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     */

    //Solution1：使用栈，将带进位的结果入栈，然后出栈节点相连组织链表
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

    //递归法：边每一次递归形成一个节点，当l1、l2都遍历完后，结束
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(-1);
        add(l1, l2, newHead, 0);
        return newHead.next;
    }

    private void add(ListNode l1, ListNode l2, ListNode cur, int carry) {
        //终止条件：这个情况很重要，carry为0且l1、l2都无了
        if (carry == 0 && l1 == null && l2 == null) return;

        int n1 = l1 == null ? 0 : l1.val;
        int n2 = l2 == null ? 0 : l2.val;

        cur.next = new ListNode((n1 + n2 + carry) % 10); //cur一直向后移动
        //下一次进位数carry
        add(l1 == null ? null : l1.next,
                l2 == null ? null : l2.next, cur.next, (n1 + n2 + carry) / 10);
    }

}
