package com._leetcode.L101__L200;

import com._leetcode.TreeNode;

public class L226 {
    //Solution：递归
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        //经典temp交换，不过是二叉树版
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);

        return root;
    }
}
