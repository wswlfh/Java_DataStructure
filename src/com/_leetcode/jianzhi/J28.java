package com._leetcode.jianzhi;

import com._leetcode.TreeNode;

public class J28 {
    //Solution:递归
    //判断树中，位置对称的全部节点对互为镜像即可
    public boolean isSymmetric(TreeNode root) {
        //空节点或单个节点也算对称
        if (root == null || root.left == null && root.right == null) return true;
        return isMirror(root.left, root.right);
    }

    //判断是否为镜像
    private boolean isMirror(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null || node1.val != node2.val) return false;
        //囊括所有对称节点对
        return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
    }

}
