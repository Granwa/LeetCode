package jianzhiOffer.tree.levelOrderReverseByLever;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node6;
        node6.left = node7;
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.levelOrder(node1));
    }
}

class Solution {
    /**
     * 利用额外的int记录层数，每层结束后判断层数为奇或偶
     * 创建额外的reverseTemp存储偶数层反转后的ArrayList
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        int level = 0;

        if (root != null){ queue.add(root);}
        while(!queue.isEmpty()){
            level ++;
            /**
             * 根据进while时x`queue的长度来判定一轮while包含几轮for
             */
            ArrayList<Integer> temp = new ArrayList<>();
            ArrayList<Integer> reverseTemp = new ArrayList<>();
            int len = queue.size(); // queue.size()在左右节点进队列时会导致queue.size()增长，因此需要用临时变量事先存储
            for (int i = 0; i < len; i++) {
                TreeNode currNode = queue.poll();
                temp.add(currNode.val);

                if (currNode.left != null) queue.add(currNode.left);
                if (currNode.right != null) queue.add(currNode.right);
            }
            if (level % 2 == 0){
                for (int i = temp.size() - 1; i >= 0; i--) {
                    reverseTemp.add(temp.get(i));
                }
                list.add(reverseTemp);
            }else {
                list.add(temp);
            }
        }return list;
    }
}

class Solution2{
    /**
     * 利用一个boolean flag，每层都取非，来记录当前层是否需要反转
     * 使用双端队列完成反转功能
     */
    public  List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> list = new ArrayList<>();
        LinkedList<TreeNode> dequeue = new LinkedList<>(); // dequeue stands for double-ended queue
        boolean needsReverse = false;
        if (root != null) {dequeue.add(root);}
        while(!dequeue.isEmpty()){
            /**
             * 每层开始时都创建一个空的表temp用来存储当前层的节点
             * 每层结束后再将temp，add到list里
             */
            LinkedList<Integer> temp= new LinkedList<>();
            needsReverse = !needsReverse; // 反转标识每层取非
            int len = dequeue.size();
            for (int i = 0; i < len; i++) {
                /**
                 * 每次for循环开始时先出队，然后将出队节点当做currNode，将出队节点的值add进temp
                 */
                TreeNode currNode = dequeue.poll();
                if (needsReverse) {
                    temp.addLast(currNode.val);
                } else {
                    temp.addFirst(currNode.val);
                }
                if (currNode.left != null) dequeue.add(currNode.left);
                    if (currNode.right != null) dequeue.add(currNode.right);
            }list.add(temp);
        }return list;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}