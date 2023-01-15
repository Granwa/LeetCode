package HJ.HJ77火车进站;

import java.text.CollationElementIterator;
import java.util.*;

public class Main {
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] trains = new int[count];
        for (int i = 0; i < count; i++) {
            trains[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        // 开始遍历
        recursion(trains, 0, 0, stack, "");
        Collections.sort(list); // 字典序排序
        for (String s : list) {
            System.out.println(s);
        }
        sc.close();
    }

    public static void recursion(int[] trains, int inNum, int outNum, Stack<Integer> stack, String outSequence){
        if (outNum == trains.length){
            list.add(outSequence);
        }
        // stack模拟出入栈，如果火车还没进去完，则可继续入栈
        if (inNum < trains.length){
            stack.push(trains[inNum]);
            recursion(trains, inNum + 1, outNum,stack,outSequence); // 入栈，则出栈序列不变
            stack.pop(); // 恢复
        }

        // 如果栈不为空，则可以继续出栈
        if (!stack.empty()){
            Integer temp = stack.pop();
            recursion(trains, inNum, outNum + 1,stack,outSequence + temp + " "); // 出栈，则出栈序列增加，出栈元素就是这一次弹出的元素
            stack.push(temp); // 恢复，把刚刚出栈的再入栈
        }
    }
}
