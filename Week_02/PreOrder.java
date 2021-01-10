// Name:  Qinyang Song
// Email: qinyang.song@vanderbilt.edu
// Date:  1/8/2021

import java.util.ArrayList;
import java.util.List;

//递归 前序：根节点-子节点
public class PreOrder {
    public List<Integer> preorder(NNode root) {
        List<Integer> res = new ArrayList<>();
        pre(root, res);
        return res;
    }

    private void pre(NNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        for (NNode child : root.children) {
            pre(child, res);
        }
    }
}
