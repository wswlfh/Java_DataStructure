package com._leetcode.L201__L300;

import com._leetcode.TreeNode;

import java.util.HashMap;
import java.util.List;

public class L236 {

    //Solution
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        //找到其中一个p或q 只能证明这个节点是p或q的祖先，但不是共同祖先
        if (root.val == p.val || root.val == q.val) return root;

        //决定共同祖先的是这段，因为所有元素互不相同，所以左子树和右子树不可能同时是p和q的祖先

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //所以当左右子树都找到时(不论是左p右q还是左q右p)，这个节点就是最近的共同祖先
        if (left != null && right != null) return root;

        //如果有一方为空，说明不为空的那一方肯定是共同祖先
        //底层细节，找到节点之后，回到上层判断是否左右不为空，如不满足，继续向上传递所找到的节点
        if (left == null) return right;
        if (right == null) return left;
        return null;

    }


}
