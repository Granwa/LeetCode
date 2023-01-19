package leetCodeHot100;

import node.ListNode;

import java.util.ArrayList;

public class 回文链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode().generateList(new Integer[]{1, 2, 2, 1});
        new Solution234().isPalindrome(head);
    }
}

class Solution234 {
    public boolean isPalindrome(ListNode head) {
        ArrayList list = new ArrayList();
        // 转化成数组然后判断
        while(head != null){
            list.add(head.val);
            head = head.next;
        }

        Integer[] array = (Integer[]) list.toArray(new Integer[list.size()]);
        for(int i = 0; i < array.length; i ++) {
            if(array[i] != array[array.length - 1 -i]) return false;
        }
        return true;

        // 改进方法：不适用额外的空间：
        // 快慢指针找到链表的中间节点（或先遍历一遍统计链表节点数）
        // 后半段使用反转链表，再依次和前半段比较
    }
}
