package com._leetcode.jianzhi;

import com._leetcode.TreeNode;

public class J08 {
    //中序遍历的下一个节点
    public TreeNode getNext(TreeNode curNode) {

        if (curNode == null) return null;
        //有右孩
        if (curNode.right != null)
            return getNext(curNode.right);
        //无右孩
        //根节点

        while (curNode.parent != null) {
            TreeNode parent = curNode.parent;
            if (parent.left == curNode) return parent;
            curNode = parent;
        }
        return null;
    }

    private TreeNode getLeft(TreeNode node) {
        if (node == null) return null;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
