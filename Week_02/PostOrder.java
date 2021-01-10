// Name:  Qinyang Song
// Email: qinyang.song@vanderbilt.edu
// Date:  1/8/2021

import java.util.ArrayList;
import java.util.List;

//定义N叉数
class NNode {
    public int val;
    public List<NNode> children;

    public NNode() {}

    public NNode(int _val) {
        val = _val;
    }

    public NNode(int _val, List<NNode> _children) {
        val = _val;
        children = _children;
    }
}

//递归 后序：子节点-根节点
public class PostOrder {
    public List<Integer> postorder(NNode root) {
        List<Integer> res = new ArrayList<>();
        post(root, res);
        return res;
    }

    private void post(NNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        for (NNode child : root.children) {
            post(child, res);
        }
        res.add(root.val);
    }
}
