package com._leetcode.jianzhi;

import com._leetcode.TreeNode;

public class J27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;

        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = mirrorTree(right);
        root.right = mirrorTree(left);
        return root;
    }


}
