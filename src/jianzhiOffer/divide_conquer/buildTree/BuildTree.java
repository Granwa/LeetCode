package jianzhiOffer.divide_conquer.buildTree;

import jianzhiOffer.tree.LevelOrder.*;
import java.util.HashMap;
import node.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

public class BuildTree{
    public static void main(String[] args) {
        int[] preorder = {3,9,20};
        int[] inorder = {9,3,20};
        Solution solution = new Solution();
        TreeNode root = solution.buildTree(preorder, inorder);
        LevelOrder levelOrder = new LevelOrder();
        for (int i : levelOrder.levelOrder(root)) {
            System.out.println(i);
        }
    }
}

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            /*建立中序遍历中数值和索引的映射*/
            /*前提是二叉树中没有重复数据*/
            map.put( inorder[i],i);
        }
        return myBuildTree(preorder, 0, len - 1, map, 0, len - 1);
    }

    private TreeNode myBuildTree(int[] preorder, int preLeft, int preRight,
                                 HashMap<Integer, Integer> map, int inLeft, int inRight) {
        /*递归边界*/
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        /*分治+递归/每一次都从前序遍历中挑选出根节点，以此为依据在中序遍历中划分左右子树*/
        /*获取根节点值时，注意前序遍历的第一个节点是根节点*/
        int rootValue = preorder[preLeft];
        /*创建根节点*/
        TreeNode root = new TreeNode(rootValue);
        /*根据rootValue的值在中序遍历里找到根节点索引*/
        int rootIndex = map.get(rootValue);
        /*划分左右子树，创建并连接到根节点上*/
        int leftSubLen = rootIndex -inLeft;
        /*创建并连接左子树*/
        root.left = myBuildTree(preorder, preLeft + 1, preLeft + leftSubLen,
                map, inLeft, rootIndex - 1);
        /*创建并连接右子树*/
        root.right = myBuildTree(preorder, preLeft + leftSubLen + 1/*preRight - rightSubLen*/, preRight,
                map, rootIndex + 1, inRight);
        return root;
    }
}