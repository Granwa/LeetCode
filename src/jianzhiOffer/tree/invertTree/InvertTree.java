package jianzhiOffer.tree.invertTree;

import jianzhiOffer.tree.LevelOrder.LevelOrder;
import node.TreeNode;

/**
 * @author guanhhhua
 */
public class InvertTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode().setTree(new Integer[]{4, 2, 7, 1, 3, 6, 9});
        TreeNode invertTree = new Solution().invertTree(root);
        for (int i : LevelOrder.levelOrder(invertTree)) {
            System.out.println(i + " ");
        }
    }
}

/**
 * 和mirrorTree相同
 */
class Solution {
    TreeNode tempNode = new TreeNode();
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
