package com.jzoffer.two;

import com._leetcode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class JZ43 {
    class CBTInserter {
        TreeNode root;

        //普通树转为完全二叉树
        public CBTInserter(TreeNode root) {
            if (root != null) {
                Deque<TreeNode> queue = new LinkedList<>();
                queue.addLast(root);
                while (!queue.isEmpty()) {
                    TreeNode node = queue.removeFirst();
                    insert(node.val);
                    if (node.left != null)
                        queue.addLast(node.left);
                    if (node.right != null)
                        queue.addLast(node.right);
                }
            }

        }

        //完全二叉树插入节点：只有三种情况
        public int insert(int v) {
            int ans = -1;
            if (root == null) {
                root = new TreeNode(v);
                return ans;
            }
            Deque<TreeNode> queue = new LinkedList<>();
            queue.addLast(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.removeFirst();
                if (node.left == null) {
                    node.left = new TreeNode(v);
                    ans = node.val;
                    break;
                } else if (node.left != null && node.right == null) {
                    node.right = new TreeNode(v);
                    ans = node.val;
                    break;
                } else if (node.left != null && node.right != null) {
                    queue.addLast(node.left);
                    queue.addLast(node.right);
                }
            }
            return ans;
        }

        //返回根节点
        public TreeNode get_root() {
            return this.root;
        }
    }
}
