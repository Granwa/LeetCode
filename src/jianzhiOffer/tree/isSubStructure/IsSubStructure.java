package jianzhiOffer.tree.isSubStructure;

import node.TreeNode;

public class IsSubStructure {
    public static void main(String[] args) {
        TreeNode A = new TreeNode().setTree(new Integer[]{1,4,1,2});
        TreeNode B = new TreeNode().setTree(new Integer[]{1,4});
        System.out.println(new Solution().isSubStructure(A, B));
    }
}


class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        /**处理空指针*/
        if (A == null && B == null) return true;
        if (A == null || B == null) return false;
        if (isEqualNode(A, B)) {
            return true;
        } else {
            return isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }
    }

    public boolean isEqualNode(TreeNode A, TreeNode B) {
        if (A == null && B == null) return true;
        if (A == null || B == null) return false;
        return A.val == B.val && (B.left != null ? isEqualNode(A.left, B.left) : true) && (B.right != null ? isEqualNode(A.right, B.right) : true);
    }
}