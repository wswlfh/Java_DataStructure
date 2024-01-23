package com._leetcode.jianzhi;

import com._leetcode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class J26 {

    //Solution：递归
    // 对于结点值相等的A和B，先判断三角结构，如果三角结构通过，则依次判断(A.left，B.left),(A.right，B.right)的三角结构，直至全部通过
    // 对于结点值不同的A和B，则到A的左或者右孩子去找B
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    boolean recur(TreeNode A, TreeNode B) {
        //多分支 A.left B.left A.right B.right 是否相等且为NULL的情况，在这里用两个带return值的if语句就能搞定
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        //只有A.val == B.val 才能触发这里
        return recur(A.left, B.left) && recur(A.right, B.right);
    }

}
