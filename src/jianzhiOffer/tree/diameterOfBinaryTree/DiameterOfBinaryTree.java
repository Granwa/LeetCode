package jianzhiOffer.tree.diameterOfBinaryTree;

import node.TreeNode;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node1.left = node2;

        new Solution().diameterOfBinaryTree(node1);
    }
}

class Solution {
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return res;

        // 为什么不能直接return depth(root)?
        // 因为depth是用来找单边最大深度的，且每次return都是回到上一层节点，并且深度 + 1
        // return depth(root)就相当于求单边最大深度然后 + 1
    }

    public int depth(TreeNode node){
        if (node == null) return 0;
        int left = depth(node.left);
        int right = depth(node.right);

        res = Math.max(res, left + right);

        // return返回值 + 1，表示的是：从当前读取的节点返回到其父节点
        // 父节点的left值（或right值），就等于当前节点的左右最大路径 + 1
        return Math.max(left, right) + 1;
    }
}