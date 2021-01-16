// Name:  Qinyang Song
// Email: qinyang.song@vanderbilt.edu
// Date:  1/14/2021

public class LowestCommonAncestor {

    // 找出最近公共祖先 递归
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // terminator
        if (root == null || root == p || root == q) {
            return root;
        }

        // current logic
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // drill down
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
