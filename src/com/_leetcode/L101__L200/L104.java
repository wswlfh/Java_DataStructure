package com._leetcode.L101__L200;

import com._leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class L104 {
    //204.二叉树的深度

    //Solution1：回溯法，将遍历到的所有层数置于TreeSet，取最大值（最末尾）
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        TreeSet<Integer> treeSet = new TreeSet<>();
        dfs(root, 1, treeSet);
        return treeSet.last();
    }

    private void dfs(TreeNode node, int deep, TreeSet<Integer> treeSet) {
        if (node == null) {
            treeSet.add(deep - 1);
            return;
        }

        dfs(node.left, deep + 1, treeSet);
        dfs(node.right, deep + 1, treeSet);
    }

    //Solution2 : 简简单单递归，不用那么多花里胡哨
    public int maxDepth2(TreeNode root) {
        if (root == null)
            return 0;

        //每次递归 记录各自左右子树的高度，然后返回最大高度，
        int leftHeight = maxDepth2(root.left);
        int rightHeight = maxDepth2(root.right);

        return Math.max(leftHeight, rightHeight) + 1; //加1是精髓，每一层回来都加1`
    }

}
