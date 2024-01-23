package com._leetcode.jianzhi;

import com._leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class J34 {
    //Solution: 回溯
    // 注意压入压出的时机
    List<List<Integer>> ans = new LinkedList<>();
    LinkedList<Integer> res = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) return ans;
        fb(root, target);
        return ans;
    }

    private void fb(TreeNode root, int target) {
        if (root == null) return;
        res.addLast(root.val);
        if (root.left == null && root.right == null && root.val == target) {
            ans.add(new LinkedList<>(res));
        }
        //上面的不return没关系，因为是叶子节点，所以会直接执行remove
        fb(root.left, target - root.val);
        fb(root.right, target - root.val);
        res.removeLast();
    }


    public static void main(String[] args) {

    }
}
