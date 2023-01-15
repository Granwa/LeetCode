package jianzhiOffer.stackAndQueue.stackQueue;

import java.util.LinkedList;
import java.util.Scanner;

//        ["CQueue","appendTail","deleteHead","deleteHead"]
//        [[],[3],[],[]]
//        输出：[null,null,3,-1]

public class TwoStackToAQueue {
    public static void main(String[] args) {
    }
    public static void testStack(){
        CStack cStack = new CStack();

        Scanner scanner = new Scanner(System.in);
        String input;
        int inputInt;
        do {
            input = scanner.next();
            switch (input){
                case  "pop": cStack.pop();break;
                case  "push": {inputInt = scanner.nextInt(); cStack.push(inputInt);} break;
                case  "print": cStack.printStack();
            }
        }while(input != "quit");
    }
    public static void testQueue(){
        CQueue cQueue = new CQueue();
        Scanner scanner = new Scanner(System.in);
        String input;
        int inputInt;
        do {
            input = scanner.next();
            switch (input){
                case  "delete": System.out.println(cQueue.deleteHead());break;
                case  "append": {inputInt = scanner.nextInt(); cQueue.appendTail(inputInt);} break;
                case  "print": cQueue.print();
            }
        }while(input != "quit");
    }
}

class CQueue {
    private CStack stackSave;
    private CStack stackTemp;
    public CQueue() {
        this.stackSave = new CStack();
        this.stackTemp = new CStack();
    }

    public void appendTail(int value) {
        stackSave.push(value);
    }

    public int deleteHead() {
        if (stackSave.isEmpty()) return -1;

        int deleteIndex = stackSave.size() -1;
        if (deleteIndex == 0){
            return stackSave.pop();
        }

        int res;
        do {
            stackTemp.push(stackSave.pop());
            deleteIndex --;
        } while(deleteIndex != 0);
        res = stackSave.pop();
        do {
            stackSave.push(stackTemp.pop());
        }while(stackTemp.isEmpty() == false);
        return res;
    }

    public void print(){
        System.out.println(stackSave);
    }
}

class CStack {
    private LinkedList<Integer> nums;
    // 使用ArrayList而不是数组的好处：可以动态增长 // 但是更推荐用LinkedList来实现栈

    // 使用java的同学请注意，如果你使用Stack的方式来做这道题，
    // 会造成速度较慢； 原因的话是Stack继承了Vector接口，
    // 而Vector底层是一个Object[]数组，那么就要考虑空间扩容和移位的问题了。
    // 可以使用LinkedList来做Stack的容器，因为LinkedList实现了Deque接口，
    // 所以Stack能做的事LinkedList都能做，其本身结构是个双向链表，扩容消耗少。

    public CStack() {
        this.nums = new LinkedList<Integer>();
    }

    public void push(int input){
        nums.add(input);
    }

    public int pop(){
        return nums.removeLast();
    }

    public boolean isEmpty(){
        return this.nums.isEmpty();// 注意在这里把CStack类和ArrayList的isEmpty定义成了相同的名称，因此造成了递归
    }

    public int size(){
        return this.nums.size();
    }

    public void printStack(){
        System.out.println(nums);
    }
//
//    @Override
//    public String toString() {
//        return "CStack{" +
//                "nums=" + nums +
//                '}';
//    }
}