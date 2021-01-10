// Name:  Qinyang Song
// Email: qinyang.song@vanderbilt.edu
// Date:  1/8/2021

import java.util.ArrayList;
import java.util.List;

//层序遍历
public class LevelOrder {
    public List<List<Integer>> levelOrder(NNode root) {
        List<List<Integer>> res = new ArrayList<>();
        level(root, 0, res);
        return res;
    }

    private void level(NNode root, int depth, List<List<Integer>> res) {
        if (root == null) { //判断根是否为null
            return;
        }
        if (depth >= res.size()) { //判断是否为新层
            res.add(new ArrayList<>());
        }
        res.get(depth).add(root.val); //在当前层链表中加入根值
        for (NNode child : root.children) { //将下层节点放入递归队列
            level(child, depth+1, res);
        }
    }
}
