package jianzhiOffer.twoPointers.getKthFromEnd;

import node.ListNode;

/**
 * @author guanhhhua
 */
public class GetKthFromEnd {
    public static void main(String[] args) {
        new Solution2().getKthFromEnd(new ListNode().generateList(new Integer[]{4, 5, 1, 9}),4).printSelf();

    }
}

/**
 * 法1：先遍历整个链表获取其长度
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len ++;
            cur = cur.next;
        }
        cur = head;
        for (int i = 0; i < len - k ; i++) {
            cur = cur.next;
        }
        return cur;
    }
}

/**
 * 法2：使用双指针，两个指针之间间隔k个位置，当former == null时，latter指向位置正好是该返回的位置
 */
class Solution2 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode former = head;
        ListNode latter = head;

        for (int i = 0; i < k; i++) {
            former = former.next;
        }
        while (former != null){
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }
}