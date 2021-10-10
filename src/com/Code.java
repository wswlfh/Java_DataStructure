package com;

import com._leetcode.ListNode;
import com._leetcode.TreeNode;

public class Code {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val)
                prev.next = prev.next.next;
//            if (prev.next == null) break;
//            prev = prev.next.val == val ? prev : prev.next;
            else //引出一个else即可，如果不等才让它next下去
                prev = prev.next;
        }
        return dummyHead.next;
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        if (root.left != null && root.right != null)
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        else if (root.left != null)
            return minDepth(root.left) + 1;
        else if (root.right != null)
            return minDepth(root.right) + 1;
        else return 1;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        //经典temp交换，不过是二叉树版
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);

        return root;
    }

    public static void main(String[] args) {

    }
}
