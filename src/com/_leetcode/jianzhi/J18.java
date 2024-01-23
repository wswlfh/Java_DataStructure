package com._leetcode.jianzhi;

import com._leetcode.ListNode;

public class J18 {
    //删除节点
    //Solution：O(1)级别删除
    public ListNode deleteNode(ListNode head, ListNode toBeDelete) {
        if (head != null && toBeDelete != null) {
            //如果要删的是尾结点，只能使用顺序查找来删除了
            //不明白的点：如果要删尾节点，为什么不直接置尾结点为null
            //toBeDelete = null;
            if (toBeDelete.next == null) {
                if (head == toBeDelete) return null;

                ListNode node = head;
                while (node.next != toBeDelete) {
                    node = node.next;
                }
                node.next = null;
                return head;
            }
            toBeDelete.val = toBeDelete.next.val;
            ListNode next = toBeDelete.next;
            toBeDelete.next = next.next;
            next.next = null;
        } else
            throw new IllegalArgumentException("非法输入");
        return head;
    }

    //删除重复节点
    //Solution2：递归写法，双重递归
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode node = removeDuplicateNodes(head.next);
        //删除值为val的节点
        head.next = remove(node, head.val);
        return head;
    }

    private ListNode remove(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return remove(head.next, val);
        head.next = remove(head.next, val);
        return head;
    }


}
