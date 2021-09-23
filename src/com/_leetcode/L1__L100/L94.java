package com._leetcode.L1__L100;

import com._leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class L94 {
    //94.二叉树的中序遍历
    //Solution：迭代法，进入循环后 把所有左节点(带自身)压入栈，出栈之后移动到右节点再继续
    //出栈顺序即为中序遍历
    //前序遍历是 进入循环前先压自己，进入循环后出栈，再压右再压左，左右压完，取出继续
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return null;
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            while (root != null){
                stack.push(root.left);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return  list;
    }
}
