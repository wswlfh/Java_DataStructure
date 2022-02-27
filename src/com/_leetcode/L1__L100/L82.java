package com._leetcode.L1__L100;

import com._leetcode.ListNode;

public class L82 {
    //Solution1：递归
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        boolean flag = head.val == head.next.val;
        //引入flag是一大两点，递归回来的节点肯定已经去重，但是head节点本身可能早已在去重之前重复，
        // 这时候需要判断head与相邻的节点是否重复，如果重复则返回的时候也要把head消掉，用flag来做指引
        ListNode node = deleteDuplicates(head.next); //要注意返回的node可能为null
        if (node != null && head.val == node.val)
            return node.next;
        head.next = node;

        return flag ? head.next : head;
    }

    //Solution2：迭代
    //思路和203迭代删除一样，
    // 区别在于 203是明确知道要删除哪个值，此题中不知道确定的值，只知道要删除重复的
    // 因此，可以先遍历一遍链表，找出重复的值有哪些，然后专门删除这些值
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummyHead = new ListNode(-1, head);
        int[] count = new int[201];
        ListNode node = head;
        //遍历一遍，找出重复值，以数组的形式表示
        while (node != null) {
            count[node.val + 100]++;
            node = node.next;
        }
        node = dummyHead;
        while (node.next != null) {
            if (count[node.next.val + 100] > 1) {
                node.next = node.next.next;
            } else
                node = node.next;
        }

        return dummyHead.next;
    }


}
