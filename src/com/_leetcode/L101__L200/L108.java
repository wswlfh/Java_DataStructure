package com._leetcode.L101__L200;

import com._leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class L108 {
    TreeNode root;

    public TreeNode sortedArrayToBST(int[] nums) {
        insertMiddle(nums, 0, nums.length - 1);
        return root;
    }

    private void insertMiddle(int[] nums, int l, int r) {
        if (l > r)
            return;
        int middle = l + (r - l) / 2;
        add(nums[middle]);
        insertMiddle(nums, l, middle - 1);
        insertMiddle(nums, middle + 1, r);
    }

    public void add(int e) {
        root = add(root, e);
    }

    private TreeNode add(TreeNode node, int e) {
        if (node == null)
            return new TreeNode(e);
        if (e < node.val)
            node.left = add(node.left, e);
        else if (e > node.val)
            node.right = add(node.right, e);

        return node;
    }

    public static void main(String[] args) {
        new L108().sortedArrayToBST(new int[]{0,1,2,3,4,5});
    }
}
