package com._leetcode.L201__L300;

import com._leetcode.ListNode;

import java.util.Stack;

public class L206 {
    //Solution1：用三个指针，prev永远指向首部，cur每指向一个节点，就先存储这个节点的下一个节点next；
    // 然后进行cur和prev进行置换，cur回到下一段链表(next所指的部分)
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    //Solution2：递归 newHead = reverseList(node)
    //newHead虽然已经完成逆转，但是其尾部节点存在环，需要（事后）消除
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = reverseList2(head.next);
        //1->2->3->4->5 ==>> 5->4->3->2->null
        //                   (head)1--↑
        //
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    //Solution3：不改变链表结构，只颠覆元素的位置，即创建一个新链表，依次插入旧表头元素，新表自然就逆转
    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = new ListNode(-1);
        ListNode cur = head;
        while (cur != null) {
            ListNode node = new ListNode(cur.val);
            node.next = newHead.next;
            newHead.next = node;
            cur = cur.next;
        }
        return newHead.next;
    }

    //Solution4：使用栈，出栈顺序正好就是逆转
    public ListNode reverseList4(ListNode head) {
        if (head == null || head.next == null)
            return head;
        Stack<ListNode> stack = new Stack<>();  // 用笔演化一下入栈过程
        while (head!= null){
            stack.push(head);
            head = head.next;
        }
        ListNode node = stack.pop();
        ListNode newHead = node;
        while (!stack.isEmpty()){
            ListNode tempNode = stack.pop();
            node.next = tempNode;
            node = node.next;
        }
        node.next = null;  //这一步至关重要
        return newHead;
    }
}

