package com._leetcode.L1__L100;

import com._leetcode.ListNode;

public class L92 {
    //Solution1：基于L206的三指针法
    //           把链表分为三部分[head,leftNode] + [newHead,.....](反转部分) + [rightNode,.....]
    //           准确得到leftNode和rightNode后，将三部分拼接在一起即可
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        ListNode newHead = null, cur = head;
        ListNode leftNode = null, rightNode = null;
        for (int i = 1; i <= right + 1 && cur != null; i++) {
            ListNode next = cur.next;
            if (i == left - 1) leftNode = cur;
            if (i == right + 1) rightNode = cur;
            if (i >= left && i <= right) {
                cur.next = newHead;
                newHead = cur;
            }
            cur = next;
        }
        //leftNode == null意味着left = 1,即头结点也倒转，然后接上右部分，返回新头结点
        //[newHead,head] + [rightNode,.....]
        if (leftNode == null) {
            head.next = rightNode;
            return newHead;
        }
        //不管rightNode是否为null，右部分都可以接上
        leftNode.next.next = rightNode;
        leftNode.next = newHead;
        return head;
    }
}
