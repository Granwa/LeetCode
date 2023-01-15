package jianzhiOffer.search_backTrack_treeRecursive.isUnivalTree;

import node.TreeNode;

/**
 * unival即uni-value单值，即二叉树中所有节点的值相等
 * @author guanhhhua
 */
public class IsUnivalTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode().setTree(new Integer[]{2,2,2,5,2});
        System.out.println(new Solution().isUnivalTree(root));
    }
}

class Solution {
    public boolean isUnivalTree(TreeNode root) {
        /**root == null是递归的返回条件*/
        if (root == null) return true;
        return isEqual(root)&&isUnivalTree(root.left)&&isUnivalTree(root.right);
    }

    public boolean isEqual(TreeNode node) {
        if (node != null && node.left == null && node.right == null) return true;
        if (node != null && node.left != null && node.right == null) return node.val == node.left.val;
        if (node != null && node.left == null && node.right != null) return node.val == node.right.val;
        if (node != null && node.left != null && node.right != null) return node.val == node.left.val && node.val == node.right.val;
        return false;
    }
}