package jianzhiOffer.search_backTrack_treeRecursive.maxDepth;

import node.TreeNode;

/**
 * 错误样例：
 * []
 * [3,4,5,-7,-6,null,null,-7,null,-5,null,null,null,-4]
 * @author guanhhhua
 */
public class MaxDepth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode().setTree(new Integer[]{3, 4, 5, -7, -6, null, null, -7, null, -5, null, null, null, -4});
        System.out.println(new Solution().maxDepth(root));
        System.out.println(new Solution2().maxDepth(root));
    }
}

class Solution {
    int depth = 0;
    int max = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        // 先序遍历
        depth++;
        if (root.left != null) maxDepth(root.left);
        if (root.right != null) maxDepth(root.right);
        if (root.left == null && root.right == null) {
            max = depth > max ? depth : max;
        }
        // 遍历处理结束后，需要返回到上一层，则每返回一次，depth --
        depth --;
        return max;
    }
}

/**
 * 更简洁的答案，但是空间占用并没有减少
 */
class Solution2 {
    public int maxDepth(TreeNode root)
    {
        // 当遍历到空节点时，将空节点的depth记为0
        if (root == null)
            return 0;
        else
            // 从空节点向上累加构建depth，将计算深度的逻辑，用自下而上地计算高度来实现
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}