package com._leetcode.L101__L200;

import com._leetcode.TreeNode;

import java.util.Stack;

public class L112 {
    /*
    112. 路径总和
       给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
     */

    //Solution1：使用递归法，注意递归终止条件，要求是叶子节点
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        if (root.right == null && root.left == null)
            return root.val == targetSum;

        return hasPathSum(root.left, targetSum - root.val) ||
                hasPathSum(root.right, targetSum - root.val);
    }


    //Solution2：广度优先
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        //TODO...
        return false;
    }

    //Solution3：深度优先
    public boolean hasPathSum3(TreeNode root, int targetSum) {
        return dfs(root, 0, targetSum);
    }

    private boolean dfs(TreeNode node, int cur, int targetSum) {
        if (node == null)
            return false;
        cur = cur + node.val;
        if (node.left == null && node.right == null )
            return cur == targetSum;
        return dfs(node.left,cur,targetSum) || dfs(node.right,cur,targetSum);
    }


}