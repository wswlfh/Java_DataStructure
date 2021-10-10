package com._leetcode.L101__L200;

import com._leetcode.TreeNode;

public class L110 {
    //110. 平衡二叉树
    //给定一个二叉树，判断它是否是高度平衡的二叉树

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        //这个只是保证根节点平衡，不能保证所有节点平衡，所以要对所有节点判断
        if ((Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1) &&
                isBalanced(root.left) && isBalanced(root.right))
            return true;

        return false;
    }

    private int getHeight(TreeNode node) {
        if (node == null)
            return 0;

        int left = getHeight(node.left);
        int right = getHeight(node.right);


        return Math.max(left, right) + 1;
    }
}
