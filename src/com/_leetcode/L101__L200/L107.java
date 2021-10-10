package com._leetcode.L101__L200;

import com._leetcode.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class L107 {
    TreeMap<Integer, List<Integer>> map = new TreeMap<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        dfs(root, 0);
        LinkedList<List<Integer>> ans = new LinkedList<>();
        for (int height : map.keySet()) {
            ans.addFirst(map.get(height));
        }
        return ans;
    }

    private void dfs(TreeNode node, int height) {
        if (node == null)
            return;
        if (!map.containsKey(height))
            map.put(height, new LinkedList());

        map.get(height).add(node.val);


        dfs(node.left, height + 1);
        dfs(node.right, height + 1);
    }
}
