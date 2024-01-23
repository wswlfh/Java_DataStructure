package com._leetcode.L1__L100;


import com._leetcode.ListNode;

import java.util.LinkedList;


public class L21 {
    //Solution1：队列法
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode curL1 = l1, curL2 = l2;
        LinkedList<ListNode> queue = new LinkedList<>();
        while (curL1 != null || curL2 != null) {
            if (curL1 == null) {
                queue.addLast(curL2);
                curL2 = curL2.next;
            } else if (curL2 == null) {
                queue.addLast(curL1);
                curL1 = curL1.next;
            } else if (curL1 != null && curL2 != null) {
                if (curL1.val <= curL2.val) {
                    queue.addLast(curL1);
                    curL1 = curL1.next;
                } else {
                    queue.addLast(curL2);
                    curL2 = curL2.next;
                }
            }

        }
        ListNode node = queue.pollFirst();
        ListNode head = node;
        while (!queue.isEmpty()) {
            ListNode temp = queue.pollFirst();
            node.next = temp;
            node = node.next;
        }
        node.next = null;
        return head;
    }

    //Solution2：递归法: 分成两部分，递归思想
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

    //Solution3：迭代法
    //设置一个虚拟头结点和一个前置节点prev 比较两个链表，哪个节点小 prev就指向谁，同时！！小节点向后移动，prev也向后移动
    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode prev = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = (l1 == null ? l2 : l1);
        return dummyHead.next;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        int nums[] = {1, 5, 23, 6, 2};
        for (int num : nums)
            list.addLast(num);
        System.out.println(list);
        list.pollLast();
        System.out.println(list);
    }
}
