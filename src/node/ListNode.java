package node;

import javax.xml.soap.Node;

public class ListNode {// 这个ListNode在LeetCode中是内置的类
    public int val; // 在LeetCode中， 这个属性叫val
    public ListNode next; // 单链表只能有一个指针 // 在java中不需要使用指针，直接用同类对象即可

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }

    public ListNode generateList(Integer[] nums){
        ListNode head = new ListNode();
        head.val = nums[0];
        if (nums.length >= 2) head.next = new ListNode(nums[1]);
        ListNode cur = head.next;
        for (int i = 2; i < nums.length; i++) {
            ListNode next = new ListNode(nums[i]);
            cur.next = next;
            cur = next;
        }
        return head;
    }

    public void printSelf(){
        ListNode cur = this;
        while (cur!=null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }
}