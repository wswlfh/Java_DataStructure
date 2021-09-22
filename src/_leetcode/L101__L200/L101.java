package _leetcode.L101__L200;

public class L101 {
    //对称二叉树：给定一个二叉树，检查它是否是镜像对称的。
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        //Solution1：递归法，判断左右子节点是否对称，val (left,right) (right,left)
        public boolean isSymmetric(TreeNode root) {
            return _isSymmetric(root, root);
        }

        //p、q始终为同一层
        private boolean _isSymmetric(TreeNode p, TreeNode q) {
            if (p == null && q == null)
                return true;
            if (p == null || q == null)
                return false;
            return p.val == q.val && _isSymmetric(q.left, p.right) &&
                    _isSymmetric(q.right, p.left);
        }

    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode();
        TreeNode node2 = new TreeNode();
        System.out.println(node1.left == node2.right);
    }
}
