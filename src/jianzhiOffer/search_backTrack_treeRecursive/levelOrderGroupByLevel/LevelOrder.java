package jianzhiOffer.search_backTrack_treeRecursive.levelOrderGroupByLevel;

import node.TreeNode;

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

        Solution2 solution = new Solution2();
        System.out.println(solution.levelOrder(node1));
    }
}

class Solution {
    /**
     * 通过包含null节点在内的节点数去判断，在实操时会遇到大量的边界判定处理（好像是跑不起来的）
     */
    public ArrayList<ArrayList<Integer>> levelOrderCountingNullPointer(TreeNode root) {
        if(root == null) return null;

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>() {{add(root);}};
        ArrayList<ArrayList<Integer>> printArray = new ArrayList<ArrayList<Integer>>() {}; // 创建集合时一定！一定要记得使用泛型！！！
        printArray.add(new ArrayList<>());
        int levelNums = 0;
        int n = 0;

        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll(); // 层次遍历以出队列的节点作为当前操作节点 // poll为空返回null，remove为空抛出异常
            if (currNode != null) {
                printArray.get(n).add(currNode.val);
            }

            try {
                queue.add(currNode.left);
            } catch (NullPointerException e) {
                queue.add(null);
            }
            try {
                queue.add(currNode.right);
            } catch (NullPointerException e) {
                queue.add(null);
            }

            levelNums ++;
            if (levelNums == (Math.pow(2,n + 1) - 1)){
                n++;
                printArray.add(new ArrayList<>());
            }
        }
        return printArray;
    }
}

class Solution2 {
    /**
     * 根据进while时queue的长度来判定一轮while包含几轮for(即当前层共有几个节点)
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        // 用List存储List来实现分层显示
        List<List<Integer>> list = new ArrayList<>(); // ArrayList赋值给List自动向上转型，不需要其他额外操作

        if (root != null){ queue.add(root);}
        while(!queue.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<>();
            int len = queue.size(); // queue.size()在左右节点进队列时会导致queue.size()增长，因此需要用临时变量事先存储
            for (int i = 0; i < len; i++) {
                TreeNode currNode = queue.poll();
                temp.add(currNode.val);

                if (currNode.left != null) queue.add(currNode.left);
                if (currNode.right != null) queue.add(currNode.right);
            }
                list.add(temp);
        }return list;
    }
}
