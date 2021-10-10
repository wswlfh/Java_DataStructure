package com._leetcode.L101__L200;

import com._leetcode.TreeNode;

import java.util.*;


public class L111 {
    //111. 二叉树的最小深度

    //Solution1：回溯法，将遍历到的所有层数置于TreeSet，取最小值（最首）
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        TreeSet<Integer> treeSet = new TreeSet<>();
        dfs(root, 1, treeSet);
        return treeSet.first();
    }

    private void dfs(TreeNode node, int deep, TreeSet<Integer> treeSet) {
        if (node == null) return; //重要
        //与maxDepth不同的是，遇到叶子节点才把当前的深度放入set，如果没遇到则一直搜索下去
        if (node.left == null && node.right == null)
            treeSet.add(deep);

        dfs(node.left, deep + 1, treeSet);
        dfs(node.right, deep + 1, treeSet);
    }

    //Solution2：深度优先，递归
    public int minDepth2(TreeNode root) {
        //假设minDepth()已经实现了其功能，只需返回 左右子树中寻找的最小深度 + 1 化解为子问题
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        int minDepth = Integer.MAX_VALUE;
        if (root.left != null)
            minDepth = Math.min(minDepth2(root.left), minDepth);
        if (root.right != null)
            minDepth = Math.min(minDepth2(root.right), minDepth);

        return minDepth + 1;
    }

    //Solution3：广度优先，由于广度优先是逐层扫描，扫描到的第一个叶子节点，就是最小深度节点
    //为了精确节点当前的深度，需要设计一个QueueNode结构，其中包括TreeNode本身和其深度
    //这样入队的时候，就可以记录每个节点的高度
    class QueueNode {
        TreeNode node;
        int depth;

        public QueueNode(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public int minDepth3(TreeNode root) {
        if (root == null)
            return 0;
        Queue<QueueNode> queue = new LinkedList<>();
        queue.add(new QueueNode(root, 1));
        while (!queue.isEmpty()) {
            QueueNode queueNode = queue.poll();
            TreeNode node = queueNode.node;
            int depth = queueNode.depth;
            if (node.left == null && node.right == null)
                return depth;
            if (node.left != null)
                queue.add(new QueueNode(node.left, depth + 1));
            if (node.right != null)
                queue.add(new QueueNode(node.right, depth + 1));
        }
        return 0;
    }


}
