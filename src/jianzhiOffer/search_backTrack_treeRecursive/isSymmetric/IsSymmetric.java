package jianzhiOffer.search_backTrack_treeRecursive.isSymmetric;

import node.TreeNode;

/**
                     1
                    / \
                   2   2
                  /\  /\
                 3 4 4 3

 */
public class IsSymmetric {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node21 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node31 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node41 = new TreeNode(4);
        node1.left = node2;
        node1.right = node21;
        node2.left = node3;
        node2.right = node4;
        node21.left = node41;
        node21.right = node31;

        Solution solution = new Solution();
        System.out.println(solution.isSymmetric(node1));
    }
}

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true:recur(root.left,root.right);
    }

    /**
     * 递归判断对称性
     * @param left
     * @param right
     * @return
     */
    public boolean recur(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        // 注意判断的是左节点的左边和右节点的右边
        return recur(left.left, right.right) && recur(left.right, right.left);
    }
}