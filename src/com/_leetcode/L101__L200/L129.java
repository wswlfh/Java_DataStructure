package com._leetcode.L101__L200;

import com._leetcode.TreeNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class L129 {
    //Solution：队列加Map
    //层次遍历：每次加入新节点时，记录该节点到根节点的总值，用map来记录
    // 存入map中，每往下一层，子节点的总值就为父节点总值*10+父节点的val值
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        HashMap<TreeNode, Integer> map = new HashMap<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        map.put(root, root.val);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pop();
            if (node.left == null && node.right == null)
                sum += map.get(node);
            if (node.left != null) {
                deque.add(node.left);
                map.put(node.left, 10 * map.get(node) + node.left.val);
            }
            if (node.right != null) {
                deque.add(node.right);
                map.put(node.right, 10 * map.get(node) + node.right.val);
            }
        }

        return sum;
    }
}
