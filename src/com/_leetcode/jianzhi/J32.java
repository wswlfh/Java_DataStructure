package com._leetcode.jianzhi;

import com._leetcode.TreeNode;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class J32 {
    //Solution：队列 实现层序遍历
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[]{};
        Deque<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode pop = queue.pop();
            if (pop.left != null) queue.add(pop.left);
            if (pop.right != null) queue.add(pop.right);
            res.add(pop.val);
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    //Solution: 递归实现层序遍历
    // 根据需求反转偶数层
    LinkedList<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> levelOrder_fb(TreeNode root) {
        if (root == null) return ans;
        fb(root, 0);
        //反转
        for (int i = 0; i < ans.size(); i++)
            if (i % 2 == 1) Collections.reverse(ans.get(i));
        return ans;
    }
    //递归，按照节点所在层数加到对应的容器
    private void fb(TreeNode root, int k) {
        if (root == null) return;
        if (ans.size() <= k)
            ans.add(new LinkedList<>());
        ans.get(k).add(root.val);
        fb(root.left, k + 1);
        fb(root.right, k + 1);
    }
}
