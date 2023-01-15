package jianzhiOffer.search_backTrack_treeRecursive.mirrorTree;

import node.TreeNode;

public class MirrorTree {

}

/**
 * 和invertTree相同
 */
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode leftNewNode = mirrorTree(root.right);
        TreeNode rightNewNode = mirrorTree(root.left);

        root.left = leftNewNode;
        root.right = rightNewNode;

        return root;
    }


    // 递归真的是我一辈子的噩梦...
//    public TreeNode mirrorTree(TreeNode root) {
//        if (root == null) return null;
//        return recur(root);
//    }
//
//    private TreeNode recur(TreeNode root) {
//        TreeNode newNode = newMirrorNode(root.left);
//        newNode.left=newMirrorNode(root.right);
//        newNode.right=newMirrorNode(root.left);
//        return newNode;
//    }
//
//    /**
//     * 创建镜像新节点
//     * @param currNode
//     * @return
//     */
//    public TreeNode newMirrorNode(TreeNode currNode){
//        TreeNode newNode = new TreeNode(currNode.val);
//        newNode.left = currNode.right == null ?
//                null : new TreeNode(currNode.right.val);
//        newNode.right = currNode.left == null ?
//                null : new TreeNode(currNode.left.val);
//        return newNode;
//    }
}