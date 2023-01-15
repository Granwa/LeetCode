package HJ.HJ70矩阵乘法中乘法运算次数;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * 栈操作，表达式求值类，需要再次复习
 */
// 给定运算顺序，求需要做多少次乘法运算
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[][] matrices = new int[count][2];
        for (int i = 0; i < count; i++) {
            matrices[i][0] = sc.nextInt();
            matrices[i][1] = sc.nextInt();
        }
        String expression = sc.next();
        System.out.println(multiplyCount(matrices, expression));
    }

    /**
     * 遇到字母表示的矩阵，就将矩阵行列入栈
     * 左括号直接入栈，右括号出栈直到左括号，字母直接入栈
     */
    private static int multiplyCount(int[][] matrices, String expression){
        int sum = 0;
        // 存入行和列
        // 本题的括号中有且只有两个矩阵
        Stack<Integer[]> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            int index = ch - 'A';
            if (ch >= 'A' && ch <= 'Z'){
                stack.push(new Integer[]{matrices[index][0],matrices[index][1]});
            }else if (ch == '('){
//                stack.push(new Integer[]{-1,-1});
            }else if (ch == ')'){
                // 1.因为括号中最多两个矩阵，因此不需要出栈直到遇到左括号
                // 如果括号中有三个以上，则需要将矩阵存入List，并反向计算
                Integer[] matrix2 = stack.pop();
                Integer[] matrix1 = stack.pop();
                sum += matrix1[0]*matrix1[1]*matrix2[1];
                stack.push(new Integer[]{matrix1[0],matrix2[1]}); // 存入矩阵1的行，矩阵2的列到栈中
            }
            // 2.因为所有表达式都被括号包起来，所以不需要出栈直到为空
        }
        return sum;
    }
}
