package jianzhiOffer.stackAndQueue.minStack;

// 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数
// 在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)

// 时间复杂度为O(1)，肯定不能遍历栈

import java.util.LinkedList;
import java.util.Scanner;

public class MinStackProblem {
    public static void main(String[] args) {
        String input;
        int inputInt;
        MinStack minStack = new MinStack();
        Scanner scanner = new Scanner(System.in);
        do {
            input = scanner.next();
            switch (input) {
                case "pop":
                    minStack.pop();
                    break;
                case "push": {
                    inputInt = scanner.nextInt();
                    minStack.push(inputInt);
                }
                break;
                case "min":
                    System.out.println(minStack.min());
                    break;
                case "top":
                    System.out.println(minStack.top());
                    break;
            }
        } while (input != "quit");
    }
}

class MinStack {
    private LinkedList<Integer> nums;
    private LinkedList<Integer> minLink;

    public MinStack() {
        this.nums = new LinkedList<Integer>();
        this.minLink = new LinkedList<Integer>(); // 别忘了构造函数里也需要创建minLink
    }


    public void push(int input) {
        nums.add(input);
        if (nums.size() == 0) {
            minLink.add(input);
            return; // 用return来终止该函数，阻止函数后续操作
        }

        if (minLink.size() == 0) {
            minLink.add(input);
            return;
        }

        if (input <= minLink.getLast()) { // 阅读原码可知，如果minLink是空表，也会报错，因此需要分类处理
            minLink.add(input);
        }
    }

    public void pop() {
        if (minLink.getLast().equals(nums.removeLast())) { // 问题出在Integer包装类
            // minLink.getLast() == (nums.removeLast())
            minLink.removeLast();
        }
    }

    public int top() {
        return nums.get(nums.size() - 1);
    }

    public int min() {
        return minLink.getLast();
    }
}