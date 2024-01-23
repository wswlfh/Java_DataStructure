package com._leetcode.L101__L200;

import com._leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class L113 {

    //Solution：经典回溯
    List<List<Integer>> ans = new LinkedList<>();
    LinkedList<Integer> res = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        gens(root, targetSum, 0);
        return ans;
    }

    private void gens(TreeNode root, int targetSum, int sum) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            if (root.val != targetSum - sum) return;
            res.add(root.val);
            ans.add(new LinkedList<>(res));
            res.removeLast();
            return;
        }
        res.add(root.val);
        gens(root.left, targetSum, sum + root.val);
        gens(root.right, targetSum, sum + root.val);
        res.removeLast(); //用完拿出来
    }
}
