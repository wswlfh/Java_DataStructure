package com._leetcode.L101__L200;

import com._leetcode.TreeNode;

import java.util.ArrayList;

public class L104 {
    //204.二叉树的深度

    //Solution1：使用深度优先，用一个链表跟进，递归到底的时候把值加入链表，然后去链表最大值
    public  int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        ArrayList<Integer> list = new ArrayList<>();
        dfs(root, 1, list);
        System.out.println(list);
        int max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > max)
                max = list.get(i);
        }
        return max;
    }

    private void dfs(TreeNode node, int deep, ArrayList<Integer> list) {
        if (node == null) {
            list.add(deep - 1);
            return;
        }
        dfs(node.left, deep + 1,list);
        dfs(node.right, deep + 1,list);
    }

    //Solution2 : 简简单单递归，不用那么多花里胡哨
        public int maxDepth2(TreeNode root) {
            if (root == null) {
                return 0;
            } else {
                //每次递归 记录各自左右子树的高度，然后返回最大高度，
                int leftHeight = maxDepth2(root.left);
                int rightHeight = maxDepth2(root.right);
                return Math.max(leftHeight, rightHeight) + 1; //加1是精髓，每一层回来都加1`
            }
        }

}
