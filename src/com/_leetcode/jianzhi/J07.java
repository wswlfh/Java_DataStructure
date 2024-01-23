package com._leetcode.jianzhi;

import com._leetcode.TreeNode;

import java.util.HashMap;

public class J07 {
    //Solution：
    //思路：前序遍历第一个节点就是根节点，然后去找根节点在中序遍历中的索引i
    // [0,i-1]就是根节点左子树部分；[i+1,inorder.length-1]就是根节点右子树部分
    // 然后在前序数组中找到左右两个子树的根节点的索引，然后就可建立起左右子树根节点
    // 递归下去就可以完善整个树
    int[] preorder;
    HashMap<Integer, Integer> dic = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++)
            dic.put(inorder[i], i);
        return recur(0, 0, inorder.length - 1);
    }

    private TreeNode recur(int rootIndex, int left, int right) {
        if (left > right) return null;                          // 递归终止
        TreeNode node = new TreeNode(preorder[rootIndex]);          // 建立根节点
        int i = dic.get(preorder[rootIndex]);                       // 划分根节点、左子树、右子树
        node.left = recur(rootIndex + 1, left, i - 1);              // 开启左子树递归
        //右子树的索引 = 右子树根节点在前序数组中的索引 = 右子树父节点索引 + 左子树的结点个数
        //中序数组：[left ... i ... right] 左子树节点个数 = i - left + 1;
        node.right = recur(rootIndex + i - left + 1, i + 1, right); // 开启右子树递归
        return node;                                           // 回溯返回根节点
    }

}
