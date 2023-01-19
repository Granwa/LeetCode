package jianzhiOffer.tree.inorder;

import node.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Inorder {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.left = null;
        node1.right = node2;
        node2.left = node3;
        node2.right = null;
        node3.left = null;
        node3.right = null;

        new Solution().inorderTraversal(node1);
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    ArrayList traverseList = new ArrayList();

    public List<Integer> inorderTraversal(TreeNode root) {

        // 递归的退出条件1：当前节点为空时，不做任何操作直接退出
        if (root == null) return traverseList;

        inorderTraversal(root.left);

        traverseList.add(root.val);

        inorderTraversal(root.right);

        // 递归退出条件2：完成一次左、中、右的操作，直接退出
        return traverseList;
    }
}

class SolutionIteration {
    Stack<Integer> stack = new Stack<>();
    ArrayList traverseList = new ArrayList();

    public List<Integer> inorderTraversal(TreeNode root) {
        // 迭代

        return traverseList;
    }
}