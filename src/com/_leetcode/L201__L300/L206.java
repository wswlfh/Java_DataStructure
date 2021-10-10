package com._leetcode.L201__L300;

import com._leetcode.ListNode;

import java.util.Stack;

public class L206 {
    //Solution1：三指针法
    //          三指针: newHead cur next
    //          思路：将链表拆解成两部分：一部分原序，一部分反序
    //              newHead为反序链表的首部(开始为空)，cur为原序首部，next为cur.next 待定的新原序首部
    //              cur指向newHead，然后cur变成newHead，这样反序链表就添加了一个新元素且为首部
    //              原序元素少了一个，这时候要确定新的原序首部(cur=next)，next提前保存了
    //              当cur==null时 反转完毕
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = next;
        }
        return newHead;
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

    //Solution4：使用栈
    //          遍历链表 压节点
    //          遍历链表 出栈重新组织节点顺序
    public ListNode reverseList4(ListNode head) {
        if (head == null || head.next == null)
            return head;
        Stack<ListNode> stack = new Stack<>();  // 用笔演化一下入栈过程
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode node = stack.pop();
        ListNode newHead = node;
        while (!stack.isEmpty()) {
            ListNode tempNode = stack.pop();
            node.next = tempNode;
            node = node.next;
        }
        node.next = null;  //这一步至关重要
        return newHead;
    }
    //Solution5：使用栈，
    //          遍历链表 压节点的值
    //          遍历链表 出栈赋值
    public ListNode reverseList5(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode node = head;
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        node = head;
        while (node != null) {
            node.val = stack.pop();
            node = node.next;
        }
        return head;
    }
}

