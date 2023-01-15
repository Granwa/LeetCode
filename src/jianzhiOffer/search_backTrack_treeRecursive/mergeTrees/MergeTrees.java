package jianzhiOffer.search_backTrack_treeRecursive.mergeTrees;

import jianzhiOffer.search_backTrack_treeRecursive.LevelOrder.LevelOrder;
import node.TreeNode;

/**
 * @author guanhhhua
 */
public class MergeTrees {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode().setTree(new Integer[]{1,2,null,3});
        TreeNode root2 = new TreeNode().setTree(new Integer[]{1,null,2,null,3});

        LevelOrder.printLevelOlder(new Solution2().mergeTrees(root1, root2));
    }
}

/**
 * 相比我原来写的Solution，Solution2中的方法可以避免很多不必要的if-else判断
 *
 * 我的Solution的处理方法：如果两个节点中有一个为null，则getValForNull方法会将null节点的值当做0来计算
 * 这样会导致即使两棵树中已经有一个节点为null，仍然会深度搜索null的左右子树，不仅需要多一层递归，而且会导致空指针异常
 * 因此不得不用大量的if-else语句来解决
 *
 * Solution2处理方法：如果是只有一个为空，就直接将另一个节点当做合并树的节点
 * (但是显然会导致合并树和合并前的树，共享部分内存，这样会在删除修改树时带来不便)
 * 因此可以更改成Solution3的版本(会出错！！！！！！)
 */

/**
 * 效率高，且不存在共享内存问题
 * 但是，new TreeNode之后就清除了原有节点带有的left和right，因此在某些测试用例下，合并没有完成就中止了
 *
 * 原Solution能够正确执行的原因，就是因为虽然每一个节点都是新建，但是每一个新节点都完整经历了
 * 创建(赋初值)，设置left,right的过程。
 *
 * Solution2直接复用了原来两棵树的节点，自带left,right
 */
@Deprecated
class Solution3 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        if (root1 == null) return new TreeNode(root2.val);
        if (root2 == null) return new TreeNode(root1.val);

        TreeNode newNode = new TreeNode(root1.val + root2.val);
        newNode.left = mergeTrees(root1.left, root2.left);
        newNode.right = mergeTrees(root1.right, root2.right);
        return newNode;
    }
}

/**
 * 官方题解，会导致合并树和原来两棵树共享内存
 */
class Solution2 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        TreeNode newNode = new TreeNode(root1.val + root2.val);
        newNode.left = mergeTrees(root1.left, root2.left);
        newNode.right = mergeTrees(root1.right, root2.right);
        return newNode;
    }
}

/**
 * 我的原题解，虽然安全但是效率低
 */
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // 都为null的时候才return null，否则就要计算
        if (root1 == null && root2 == null) return null;
        TreeNode newNode = new TreeNode(getValForNull(root1) + getValForNull(root2));
        /**递归*/
        if (root1 != null && root2 != null) {
            newNode.left = mergeTrees(root1.left, root2.left);
            newNode.right = mergeTrees(root1.right, root2.right);
        } else if (root1 == null) {
            newNode.left = mergeTrees(null, root2.left);
            newNode.right = mergeTrees(null, root2.right);
        } else if (root2 == null) {
            newNode.left = mergeTrees(root1.left, null);
            newNode.right = mergeTrees(root1.right, null);
        }

        return newNode;
    }

    public int getValForNull(TreeNode node) {
        if (node == null) return 0;
        return node.val;
    }
}
