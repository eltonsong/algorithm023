// Name:  Qinyang Song
// Email: qinyang.song@vanderbilt.edu
// Date:  1/15/2021

import java.util.HashMap;
import java.util.Map;

// 根据先序和中序数组构建二叉树 递归
public class BuildTree {
    private Map<Integer, Integer> nodeMap = new HashMap<>();

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preLeftBound,
                                       int preRightBound, int inLeftBound, int inRightBound) {

        //terminator
        if (preLeftBound > preRightBound) {
            return null;
        }

        // current logic
        // 定位两种排序中的根节点
        int preRoot = preLeftBound;
        int inRoot = nodeMap.get(preorder[preRoot]);

        // 建立当前节点
        TreeNode root = new TreeNode(preorder[preRoot]);
        // 得到左子树中的节点数目
        int leftLength = inRoot - inLeftBound;

        // Drill down
        // 左子树
        root.left = myBuildTree(preorder, inorder, preLeftBound + 1,
                preLeftBound + leftLength, inLeftBound, inRoot - 1);

        // 右子树
        root.right = myBuildTree(preorder, inorder, preLeftBound + leftLength + 1,
                preRightBound, inRoot + 1, inRightBound);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //创建哈希表储存数组
        int n = preorder.length;
        nodeMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            nodeMap.put(inorder[i], i);
        }
        //开始递归创建树
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }
}
