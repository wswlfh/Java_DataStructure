package com._leetcode.jianzhi;

public class J33 {
    // Solution：递归+后序遍历特性
    // 序列从左往右，第一个比根节点大的值就是右子树部分，右子树部分都比根节点大，如果这部分出现比根节点小的值，说明不是正确的后序遍历
    // 递归判断
    // 关注！
    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorder(postorder, postorder.length - 1, 0);
    }

    private boolean verifyPostorder(int[] postorder, int root, int left) {
        if (left < 0 || root < 0 || root <= left) return true;
        //找出右子树部分开始的索引
        int right = -1;
        for (int i = left; i < root; i++) {
            if (postorder[i] > postorder[root]) {
                right = i;
                break;
            }
        }

        //没有右子树，去判断左子树
        //没有右子树时，左子树根节点为root-1
        if (right == -1) return verifyPostorder(postorder, root - 1, left);

        //有右子树
        //遍历判断
        for (int i = right; i < root && i != -1; i++) {
            if (postorder[i] < postorder[root]) return false;
        }

        //判断左右子树
        return verifyPostorder(postorder, root - 1, right) &&
                verifyPostorder(postorder, right - 1, left);
    }

    public static void main(String[] args) {
        boolean b = new J33().verifyPostorder(new int[]{5, 2, -17, -11, 25, 76, 62, 98, 92, 61});
        System.out.println(b);
    }

}
