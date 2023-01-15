package jianzhiOffer.twoPointers.mergeTwoLists;

import node.ListNode;

/**
 * @author guanhhhua
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        new Solution().mergeTwoLists(new ListNode().generateList(new Integer[]{1,2,4})
                ,new ListNode().generateList(new Integer[]{1,3,4})).printSelf();
    }
}

/**
 * 双指针解法
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(0);
        ListNode cur = dum;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        /*当一条链表遍历结束后，直接将另一条链表拼接在后面*/
        cur.next = l1 != null ? l1 : l2;
        return dum.next;
    }
}

/**
 * 递归解法
 */
class Solution2{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}