package com._leetcode.jianzhi;

public class J36 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    //Solution: dfs递归
    // 依次取出BST最小节点，然后组成双向链表
    // 重点是实现取出最小节点后剩下的节点如何衔接，直接接上原最小节点的右子树即可
    Node head = new Node(-1);
    Node cur = head;

    public Node treeToDoublyList(Node root) {

        if (root == null) return root;
        //单节点
        if (root.left == null && root.right == null) {
            root.left = root;
            root.right = root;
        }
        while (root != null) {
            root = getMinAndRemove(root);
        }

        //头尾链接
        cur.right = head.right;
        head.right.left = cur;
        return head.right;
    }

    private Node getMinAndRemove(Node root) {
        if (root == null) return null;
        if (root.left == null) {
            cur.right = root;
            root.left = cur;
            cur = cur.right;
            return root.right;  //衔接只需要返回右子树即可，空不空都可
        }
        root.left = getMinAndRemove(root.left);
        return root;
    }
}
