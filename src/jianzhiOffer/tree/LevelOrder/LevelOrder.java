package jianzhiOffer.tree.LevelOrder;

import node.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;

public class LevelOrder {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
//        TreeNode node1 = null;

        Solution solution = new Solution();
        for (int i : solution.levelOrder(node1)) {
            System.out.print(i);
        }

    }

    // 用于外部调用该方法的Solution方法副本
    public static void printLevelOlder(TreeNode root){
        for (int i : levelOrder(root)) {
            System.out.print(i+ " ");
        }
    }

    public static int[] levelOrder(TreeNode root) { // 层序遍历二叉树需要借助队列
        if(root == null) return new int[] {};

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>() {{add(root);}}; // 这个语法叫什么？
        ArrayList<Integer> printArray = new ArrayList<>(); // 创建集合时一定！一定要记得使用泛型！！！

        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll(); // 层次遍历以出队列的节点作为当前操作节点 // poll为空返回null，remove为空抛出异常
            printArray.add(currNode.val);
            if (currNode.left != null) queue.add(currNode.left);
            if (currNode.right != null) queue.add(currNode.right); // 注意不是elif
        }

        int[] nums = new int[printArray.size()];
        for (
                int i = 0;
                i < printArray.size(); i++) {
            nums[i] = printArray.get(i);
        }
        return nums;
    }
}

class Solution {

    public int[] levelOrder(TreeNode root) { // 层序遍历二叉树需要借助队列
        if(root == null) return new int[] {};

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>() {{add(root);}}; // 这个语法叫什么？
        ArrayList<Integer> printArray = new ArrayList<>(); // 创建集合时一定！一定要记得使用泛型！！！

        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll(); // 层次遍历以出队列的节点作为当前操作节点 // poll为空返回null，remove为空抛出异常
            printArray.add(currNode.val);
            if (currNode.left != null) queue.add(currNode.left);
            if (currNode.right != null) queue.add(currNode.right); // 注意不是elif
        }

        int[] nums = new int[printArray.size()];
        for (
                int i = 0;
                i < printArray.size(); i++) {
            nums[i] = printArray.get(i);
        }
        return nums;
    }
}
