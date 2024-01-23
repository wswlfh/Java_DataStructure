package com._leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right, TreeNode parent) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public static TreeNode build(Integer[] data) {
        TreeNode[] nodes = new TreeNode[data.length];
        nodes[0] = new TreeNode(data[0]);

        for (int i = 1; i < data.length; i++) {
            if (data[i] == null) {
                continue;
            }
            // 计算父节点索引位置
            int parentNodeIndex = (i - 1) / 2;

            TreeNode node = new TreeNode(data[i]);
            nodes[i] = node;
            if (parentNodeIndex * 2 + 1 == i) {
                nodes[parentNodeIndex].left = node;
            } else {
                nodes[parentNodeIndex].right = node;
            }
            node.parent = nodes[parentNodeIndex];
        }
        return nodes[0];
    }

    public StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb) {
        if (right != null) {
            right.toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, sb);
        }
        sb.append(prefix).append(isTail ? "└── " : "┌── ").append(val).append("\n");
        if (left != null) {
            left.toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb);
        }
        return sb;
    }

    @Override
    public String toString() {
        return this.toString(new StringBuilder(), true, new StringBuilder()).toString();
    }


    public static TreeNode find(TreeNode node, int key) {
        if (node == null || node.val == key)
            return node;
        TreeNode node1 = find(node.left, key);
        TreeNode node2 = find(node.right, key);
        return node1 != null ? node1 : node2;
    }


    //前序遍历
    //递归
    public static void preOrder(TreeNode node) {
        if (node == null)
            return;
        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    //非递归：用栈，访问当前节点，先放右后放左，栈空终止
    public static void preOrderNR(TreeNode node) {
        if (node == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node); //前序：while前根节点入栈
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            System.out.print(pop.val + " ");
            if (pop.right != null) stack.push(pop.right);
            if (pop.left != null) stack.push(pop.left);
        }
    }

    //中序遍历
    public static void inOrder(TreeNode node) {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.print(node.val + " ");
        inOrder(node.right);
    }

    //非递归
    //用栈，但要依赖于 判断节点是否为空 来进行跳转
    //双while循环，内层while用来压最左节点
    //不同于前序非递归，节点是在while之后才入栈，且节点是否为空的判断具有重要作用
    public static void inOrderNR(TreeNode node) {
        if (node == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node); //根节点在while后入栈
                node = node.left;
            }
            //能到这一步说明 node==null,则出栈
            node = stack.pop();
            System.out.print(node.val + " ");
            node = node.right; //不需要判断node.right是否为空，如果为空则node也为null，然后又跳转到出栈那一步
        }
    }

    //后序遍历
    public static void postOrder(TreeNode node) {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + " ");
    }

    //非递归
    public static void postOrderNR(TreeNode node) {
        if (node == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null; //记录上一个后序序列的节点，用于判断节点是否被输出过
        while (node != null || !stack.isEmpty()) {
            //使用了中序的压入左子树方法
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            //这里的关键在于，弹出的节点有没有右子树，如果有则判断此右子树是否被输出过(因此引入prev判断)
            if (node.right == null || node.right == prev) {
                System.out.print(node.val + " ");
                prev = node;
                node = null; //赋null的原因是因为node要跳过最左压入，
                // 因为这里的node不是叶子结点，就是已经被压入过了，因为pop跳出来会跳回原来的节点，如果再次进行最左压入就会造成死循环
            } else {
                //如果此右子树没有被访问过，说明是新右子树，以该右子树为新节点返回进行最左压入
                stack.push(node);
                node = node.right;
            }
        }
    }


    //层序遍历/宽度优先
    public static void levelOrder(TreeNode node) {
        Deque<TreeNode> queue = new LinkedList<>();
        if (node == null) return;
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode pop = queue.pop();
            System.out.print(pop.val + " ");

            if (pop.left != null) queue.add(pop.left);
            if (pop.right != null) queue.add(pop.right);
        }

    }


    public static void main(String[] args) {
        TreeNode root = TreeNode.build(new Integer[]{0, 1, 2, 3, 4, 5, 6});
        System.out.println(root.toString());
        //前序
        System.out.print("preOrder: ");
        preOrder(root);
        System.out.println();

        //非递归
        System.out.print("preOrderNR: ");
        preOrderNR(root);
        System.out.println();

        //中序
        System.out.print("inOrder: ");
        inOrder(root);
        System.out.println();

        //非递归
        System.out.print("inOrderNR: ");
        inOrderNR(root);
        System.out.println();

        //后序
        System.out.print("postOrder: ");
        postOrder(root);
        System.out.println();

        //非递归
        System.out.print("postOrderNR: ");
        postOrderNR(root);
        System.out.println();

        //层序遍历
        System.out.print("levelOrder: ");
        levelOrder(root);
        System.out.println();
    }

}
