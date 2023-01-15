package jianzhiOffer.linkedList.reversePrint;

import node.ListNode;

import java.util.Stack;

public class ReversePrint {
    public static void main(String[] args) {
        // 注：本题中此处采取的是头结点为空的单链表；
        ListNode head = new ListNode();
        int[] nums = {1, 3, 2};

        ListNode node1 = new ListNode();
        node1.val = nums[0];
        head.next = node1;

        ListNode node2 = new ListNode();
        node2.val = nums[1];
        node1.next = node2;

        ListNode node3 = new ListNode();
        node3.val = nums[2];
        node2.next = node3;

        Solution solution = new Solution();
        int[] receive = solution.reversePrint(head);

        for (int i : receive) {
            System.out.println(i);
        }
    }
}

class SolutionOriginal {
    public int[] reversePrint(ListNode head) {
        ListNode currentNode = head.next; // 要从head.next开始计数，否则长度会多算1
        int len = 0;
        while (currentNode != null) {
            len++;
            currentNode = currentNode.next;
        }

        int[] output = new int[len];
        currentNode = head.next;
        for (int i = 0; i < len; i++) {
            output[len - i - 1] = currentNode.val; // 倒着遍历，如果 fori 从 i = 0开始， 则索引应该为 [len - i -1]
            currentNode = currentNode.next;
        }
        return output;
    }
}

class Solution {
    public int[] reversePrint(ListNode head) {
        ListNode currentNode = head.next;
        Stack<Integer> stack = new Stack<>();
        
        while(currentNode != null){
            stack.push(currentNode.val);
            currentNode = currentNode.next;
        }

        int[] output = new int[stack.size()]; // Stack的size()方法可以获得栈中元素数
        for (int i = 0; i < output.length; i++) {
            output[i] = stack.pop();
        }
        return output;
    }
}



// java ListNode 链表 就是用Java自定义实现的链表结构。
//
// 基本结构：
//
// class ListNode {        //类名 ：Java类就是一种自定义的数据结构
//    int val;            //数据 ：节点数据
//    ListNode next;      //对象 ：引用下一个节点对象。在Java中没有指针的概念，Java中的引用和C语言的指针类似
// }

// java中LinkedList类使用的结点类Node // 一个双向链表节点
//private static class Node<E> {
//    E item;
//    LinkedList.Node<E> next;
//    LinkedList.Node<E> prev;
//
//    Node(LinkedList.Node<E> prev, E element, LinkedList.Node<E> next) {
//        this.item = element;
//        this.next = next;
//        this.prev = prev;
//    }
//}

//    void linkLast(E e) {
//        final LinkedList.Node<E> l = last;
//        final LinkedList.Node<E> newNode = new LinkedList.Node<>(l, e, null);
//        last = newNode;
//        if (l == null)
//            first = newNode;
//        else
//            l.next = newNode;
//        size++;
//        modCount++;
//    }