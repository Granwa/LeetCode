package jianzhiOffer.twoPointers.deleteNode;

import node.ListNode;

/**
 * @author guanhhhua
 */
public class DeleteNode {
    public static void main(String[] args) {
        new Solution().deleteNode(new ListNode().generateList(new Integer[]{4, 5, 1, 9}),9).printSelf();
    }
}

class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val){
            return head = head.next;
        }
        /**使用双指针记录要删除节点的前驱节点*/
        ListNode cur = head.next;
        ListNode prev = head;
        while (cur != null){
            if (cur.val == val){
                prev.next = cur.next;
                cur.next = null; // help gc
                break;
            }
            else {
                prev = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}