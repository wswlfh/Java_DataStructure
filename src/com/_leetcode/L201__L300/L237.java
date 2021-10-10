package com._leetcode.L201__L300;

import com._leetcode.ListNode;

public class L237 {

    //无法访问链表的头节点 head ，只能直接访问 要被删除的节点
    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
        next.next = null;
    }
}
