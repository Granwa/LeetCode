package jianzhiOffer.twoPointers.getIntersectionNode;

import node.ListNode;

/**
 * @author guanhhhua
 */
public class GetIntersectionNode {
    public static void main(String[] args) {
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        node2.next = node3;
        System.out.println(new Solution2().getIntersectionNode(node3, node2).val);
    }
}

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB) {
            if (curA == null) {
                curA = headB;
            }
            if (curB == null) {
                curB = headA;
            }
            if (curA == curB) {
                break;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }
}

class Solution2{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB) {
            curA = curA != null ? curA.next : headB;
            curB = curB != null ? curB.next : headA;
        }
        return curA;
    }
}