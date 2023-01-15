//package jianzhiOffer.copyRandomList;
//
//public class CopyRandomList {
//}
//
//class Solution{
//    public Node copyRandomList(Node head) {
//        if (head == null){
//            return null;
//        }
//        Node currentNode = head;
//        Node backUpNode = null;
//        Node currentNewNode = null;
//
//        while(currentNode!= null){
//            backUpNode = new Node(currentNode.val);
//            backUpNode.next = currentNode.next;
//            currentNode.next = backUpNode;
//
//            backUpNode.random = currentNewNode.random.next;
//        } // 为每一个节点都插入一个备份节点
//
//        currentNode = head;
//        while(currentNode!= null){
//
//        }
//    }
//}
//
//class Node{
//    int val;
//    Node next;
//    Node random;
//
//    public Node(int val) {
//        this.val = val;
//        this.next = null;
//        this.random = null;
//    }
//}