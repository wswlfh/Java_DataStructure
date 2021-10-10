package com.jzoffer.two;

import com._leetcode.ListNode;

public class JZ29 {
    //考察了很多细节，适合练手
    //Solution:
    public ListNode insert(ListNode head, int insertVal) {
        if (head == null){
            head = new ListNode(insertVal);
            head.next = head;
            return head;
        }
        //判断是否为单个节点 需要判断next是不是自己，而不是null
        if (head.next == head){
            head.next = new ListNode(insertVal,head);
            return head;
        }
        ListNode cur = head;
        //找到最值节点,必须要加上等号，不然遇到重复元素就跳出了
        while (cur.val <= cur.next.val){
            cur = cur.next;
            if (cur.next == head) //如果循环了一圈，说明没找到，即所有元素都相等，那就直接跳出，让head当minNode
                break;
        }
        ListNode maxNode = cur;
        ListNode minNode = cur.next;
        //插入的值介于最小节点和最大节点之间
        if (insertVal <= minNode.val || insertVal >= maxNode.val){
            ListNode node = new ListNode(insertVal);
            maxNode.next = node;
            node.next = minNode;
            return head;
        }

        //正常插入
        cur = minNode;
        while (true){
            if (insertVal >= cur.val && insertVal <= cur.next.val)
                break;
            cur = cur.next;
        }
        ListNode node = new ListNode(insertVal);
        ListNode next = cur.next;
        cur.next = node;
        node.next = next;

        return head;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,9,16,25,36,49,64,81,100};
//        for (int i = 1; i < 100; i++) {
//            System.out.println(i +" "+i / Math.sqrt(i));
//        }
        System.out.println((Math.sqrt(2147483647) + 1) * (Math.sqrt(2147483647) + 1) - 2147483647) ;
    }
}
