package com._leetcode.L1__L100;

import com._leetcode.ListNode;

import java.util.HashMap;
import java.util.LinkedList;

public class L61 {
    //Solution1：使用带索引的辅助空间list
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        LinkedList<ListNode> list = new LinkedList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        k = k % list.size();
        if (k == 0) return head;
        //找到新的尾节点
        list.get(list.size() - k - 1).next = null;
        //拼接旧的头结点
        list.get(list.size() - 1).next = head;

        //新的头结点
        //ListNode newHead = list.get(list.size() - k);
        return list.get(list.size() - k);
    }

    //Solution2：快慢指针解法
    //TODO

}
