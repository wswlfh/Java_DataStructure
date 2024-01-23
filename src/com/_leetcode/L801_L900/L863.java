package com._leetcode.L801_L900;

import com._leetcode.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class L863 {
    //Solution: 深度优先搜索+哈希表

    List<Integer> ans;
    HashMap<TreeNode, TreeNode> parent;
    HashSet<TreeNode> visited;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        //初始化
        ans = new LinkedList<>();
        parent = new HashMap<>();
        visited = new HashSet<>();
        //k==0
        if (k == 0) ans.add(target.val);
        else {
            //找父节点
            parent.put(root, null);
            getParent(root);
            //dfs找节点
            find(target, k);
        }
        return ans;
    }

    private void find(TreeNode target, int k) {
        //健壮性
        if (target == null || !visited.add(target)) return;

        TreeNode parent = this.parent.get(target);
        TreeNode left = target.left;
        TreeNode right = target.right;
        if (k == 1) {
            if (parent != null && visited.add(parent)) ans.add(parent.val);
            if (left != null && visited.add(left)) ans.add(left.val);
            if (right != null && visited.add(right)) ans.add(right.val);
        } else {
            find(parent, k - 1);
            find(left, k - 1);
            find(right, k - 1);
        }
    }

    void getParent(TreeNode root) {
        if (root == null) return;
        if (root.left != null) parent.put(root.left, root);
        if (root.right != null) parent.put(root.right, root);
        getParent(root.left);
        getParent(root.right);
    }

}
