package com._leetcode.L201__L300;

import com._leetcode.TreeNode;

public class L222 {
    public int count = 0;

    public int countNodes(TreeNode root) {
        _countNodes(root);
        return count;
    }

    private void _countNodes(TreeNode node) {
        if (node == null)
            return;
        count++;
        _countNodes(node.left);
        _countNodes(node.right);
    }

}
