package jianzhiOffer.tree.isSubtree;

import node.TreeNode;

/**
 * 子树和子结构是有区别的，子树要求的是从子根节点直到叶节点的一整个部分都是子树
 *
 * @author guanhhhua
 */
public class IsSubtree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode().setTree(new Integer[]{3, 4, 5, 1, 2});
        TreeNode subRoot = new TreeNode().setTree(new Integer[]{4, 1, 2});
        System.out.println(new Solution().isSubtree(root, subRoot));
    }
}

class Solution {
    /**
     * 两棵树是否完全相等？以root的left和right为根节点的树是否和subRoot为根节点的树相等？......
     *
     * @param root
     * @param subRoot
     * @return
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        /**不断寻找直到主树找到空节点仍不满足，则退出*/
        if (root == null) return false;
        return isIdenticalTree(root,subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isIdenticalTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        return root.val == subRoot.val && isIdenticalTree(root.left, subRoot.left) && isIdenticalTree(root.right, subRoot.right);
    }
}