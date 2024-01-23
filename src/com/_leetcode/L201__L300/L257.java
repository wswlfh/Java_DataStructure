package com._leetcode.L201__L300;

import com._leetcode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class L257 {
    //Solution：回溯
    //耗时是如何转成String，题目本身不难
    Deque<LinkedList> temp = new LinkedList<>();
    LinkedList<Integer> res = new LinkedList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        gens(root);
        LinkedList<String> ans = new LinkedList<>();
        for (LinkedList<Integer> t : temp) {
            StringBuilder sb = new StringBuilder();
            for (int x : t)
                sb.append(x).append("->");
            sb.delete(sb.length() - 2, sb.length()); //删掉最后一个"->"
            ans.add(sb.toString());
        }
        return ans;
    }

    private void gens(TreeNode root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            res.add(root.val);
            temp.add(new LinkedList(res));
            res.removeLast();
            return;
        }
        res.add(root.val);
        gens(root.left);
        gens(root.right);
        res.removeLast();
    }

}
