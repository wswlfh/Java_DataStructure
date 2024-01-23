package com._leetcode.L201__L300;

import com._leetcode.TreeNode;

import java.util.HashMap;

public class L337 {
    //Solution：记忆化搜索+HashMap
    // f(root) = max{root.val + f(所有孙),f(所有子女))}
    //需要辅助空间来存储重叠子结构的值
    HashMap<TreeNode, Integer> map = new HashMap<>();

    public int rob(TreeNode root) {
        int res = map.getOrDefault(root, -1);
        if (res != -1) return res;

        if (root == null) return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        //所有孙
        int res1 = root.val;
        if (left != null) res1 += rob(left.left) + rob(left.right);
        if (right != null) res1 += rob(right.left) + rob(right.right);

        //所有子女
        int res2 = rob(left) + rob(right);

        res = Math.max(res1, res2);
        map.put(root, res);
        return res;
    }
}
