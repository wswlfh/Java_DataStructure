package com._leetcode.L1__L100;

import com._leetcode.ListNode;

import java.util.ArrayList;

public class L19 {
    //Solution1：容器法，直接把链表存入容器，然后通过get()方法定位到改节点进行删除
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //Sp：题目已经规避倒数的节点可能大于链表长度
        if (head == null || head.next == null)
            return null;

        ArrayList<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int removeIndex = list.size() - n;
        if (removeIndex == 0) return list.get(1);
        //删除
        list.get(removeIndex - 1).next = list.get(removeIndex).next;
        list.get(removeIndex).next = null;

        return list.get(0);
    }

    public static void main(String[] args) {
        ListNode head = ListNode.buildList(new int[]{1, 2, 3, 4, 5});
        ListNode node = removeNthFromEnd(head, 2);
        System.out.println();
    }
}
