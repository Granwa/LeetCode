package leetCodeHot100;

import node.ListNode;

public class 环形链表 {
}

class Solution141 {
    public boolean hasCycle(ListNode head) {
        // // 快慢指针
        ListNode pFast = head;
        ListNode pSlow = head;
        while(pFast != null && pFast.next != null) {
            pFast = pFast.next.next;
            pSlow = pSlow.next;
            if(pFast == pSlow) return true;
        }

        return false;

        // 先考虑好写的版本
        // 注意：链表的节点可以直接作为对象直接存储在ArrayList中
        // ArrayList list = new ArrayList();
        // ListNode curr = head;

        // while(curr != null) {
        //     if(list.contains(curr)) return true;
        //     list.add(curr);
        //     curr = curr.next;
        // }
        // return false;
    }
}