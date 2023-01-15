package jianzhiOffer.search_backTrack_treeRecursive.isBalanced;

import node.TreeNode;

/**
 * @author guanhhhua
 */
public class IsBalanced {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int depth(TreeNode node){
        if (node == null) return 0;
        return Math.max(depth(node.left),depth(node.right))+1;
    }
}