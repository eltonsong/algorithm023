// Name:  Qinyang Song
// Email: qinyang.song@vanderbilt.edu
// Date:  1/8/2021

import java.util.ArrayList;
import java.util.List;

// 递归，前序：根-左-右
public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    private void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }
}