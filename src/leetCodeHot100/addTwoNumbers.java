package leetCodeHot100;

import node.ListNode;

public class addTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode().generateList(new Integer[]{9, 9, 9});
        ListNode l2 = new ListNode().generateList(new Integer[]{9, 9});
        ListNode node = new Solution2().addTwoNumbers(l1, l2);
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            // 想到用双指针（或三指针）
            ListNode curr1 = l1;
            ListNode curr2 = l2;
            ListNode resHead = new ListNode();
            ListNode currRes = resHead;

            int val1 = 0;
            int val2 = 0;
            int carry = 0;

            while (curr1 != null && curr2 != null) {
                val1 = curr1.val;
                val2 = curr2.val;
                currRes.val = (carry + val1 + val2) % 10;
                carry = val1 + val2 >= 10 ? 1 : 0;
                // 链表推进
                curr1 = curr1.next;
                curr2 = curr2.next;
                if (curr1 != null || curr2 != null) {
                    currRes.next = new ListNode();
                    currRes = currRes.next;
                }
            }

            // 可能有一条链表先完结，处理另一条未完结的
            while (curr1 != null) {
                val1 = curr1.val;
                currRes.val = (carry + val1 + val2) % 10;
                // 这里将carry置为0是错误的，进位只能为0或1，万一原始位为9，那就又进位了
                carry = 0;
                curr1 = curr1.next;
                if (curr1 != null) {
                    currRes.next = new ListNode();
                    currRes = currRes.next;
                }
            }

            while (curr2 != null) {
                val2 = curr2.val;
                currRes.val = (carry + val1 + val2) % 10;
                carry = 0;
                curr2 = curr2.next;
                if (curr2 != null) {
                    currRes.next = new ListNode();
                    currRes = currRes.next;
                }
            }
            return resHead;
        }
    }

    static class Solution2 {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            /**无需将长的那截单独处理，在赋值时将不足位补0*/
            ListNode curr1 = l1;
            ListNode curr2 = l2;
            /**尾结点也就是Solution1中的currRes*/
            ListNode head = null, tail = null;
            int carry = 0;

            while (curr1 != null || curr2 != null) {
                int val1 = curr1 == null ? 0 : curr1.val;
                int val2 = curr2 == null ? 0 : curr2.val;
                int num = (val1 + val2 + carry) % 10;
                carry = (val1 + val2 + carry) / 10;
                if (head == null) {
                    head = tail = new ListNode(num);
                } else {
                    tail.next = new ListNode(num);
                    tail = tail.next;
                }
                // 链表移动
                if (curr1 != null) curr1 = curr1.next;
                if (curr2 != null) curr2 = curr2.next;
            }
            // 处理最后一个进位，如果进位不为0，再追加一个节点
            if (carry > 0) {
                tail.next = new ListNode(carry);
            }
            return head;
        }
    }
}
