package jianzhiOffer.linkedList.reverseList;

import node.ListNode;

import java.util.Stack;

public class ReverseList {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2};

        ListNode node1 = new ListNode();
        node1.val = nums[0];

        ListNode node2 = new ListNode();
        node2.val = nums[1];
        node1.next = node2;

        ListNode node3 = new ListNode();
        node3.val = nums[2];
        node2.next = node3;

        Solution2 solution = new Solution2();

        ListNode nullNode = new ListNode();
        solution.reverseList(nullNode);
//        solution.reverseList(node1);

    }
}

class Solution2 {
    public ListNode reverseList(ListNode head) {
        if (head != null) {
            ListNode currentNode = head;
            Stack<Integer> stack = new Stack<>();

            while (currentNode != null) {
                stack.push(currentNode.val);
                currentNode = currentNode.next;
            }

            int[] output = new int[stack.size()]; // Stack的size()方法可以获得栈中元素数
            for (int i = 0; i < output.length; i++) {
                output[i] = stack.pop();
            }

            // 可以先把链表连起来，再赋值
            ListNode newHead = new ListNode();
            newHead.val = output[0];
            currentNode = newHead;
            for (int i = 1; i < output.length; i++) {
                ListNode insertNode = new ListNode();
                insertNode.val = output[i]; // 忘了给链表节点赋值
                currentNode.next = insertNode;
                currentNode = insertNode;
            }
            return newHead;
        }
        return null;
    }
}
