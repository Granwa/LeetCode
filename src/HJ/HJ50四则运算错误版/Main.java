package HJ.HJ50四则运算错误版;

import java.util.Scanner;
import java.util.Stack;

/**
 * 使用后缀表达式来计算，但答案是错的！？？
 * @author guanhhhua
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.next();
        System.out.println(calculate(toPostOrder(expression)));
    }

    private static int calculate(String[] postOrderExpression){
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < postOrderExpression.length; i++) {
            if (isNumber(postOrderExpression[i])){
                // 如果不自己判断是否为数字，而是直接try-catch，将会非常缓慢
                int num = Integer.parseInt(postOrderExpression[i]);
                stack.push(num);
            } else {
                char operator = postOrderExpression[i].charAt(0);
                // 先出栈是操作数2
                Integer num2 = stack.pop();
                // 后出栈是操作数1
                Integer num1 = stack.pop();
                switch (operator){
                    case '+' : stack.push(num1 + num2);break;
                    case '-' : stack.push(num1 - num2);break;
                    case '*' : stack.push(num1 * num2);break;
                    case '/' : stack.push(num1 / num2);break;
                }
            }
        }
        return stack.pop();
    }

    /**
     * 该中缀表达式算法错误
     *
     *  已知表达式一定合法
     *  1.如何处理减号和负号
     *  2.括号统一换成小括号
     *  3.字符串要用equals()
     *  4.转后序表达式的方法：
     *      1.操作数全部压入nums
     *      2.运算符，为空时随意压入，'('在栈顶时随意压入，'('自身也随意压入
     *      3.运算符，优先级高于栈顶则压入，低于栈顶则弹出栈顶到nums，再把自己压入
     *      4.遍历完成后，把nums全部弹到operators中，
     *      5.弹出operators，这个序列就是后序表达式
     */
    private static String[] toPostOrder(String expression) {
        // 如果减号的前面是符号或为空，则当做负号处理
        Stack<String> nums = new Stack<>();
        Stack<String> operators = new Stack<>();
        StringBuilder current = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            // 是操作数
            if (isNum(ch)) {
                current.append(ch);
                int j = i;
                while (++j < expression.length() && isNum(ch = expression.charAt(j))) {
                    current.append(ch);
                }
                // 入栈当前操作数，清空current
                nums.push(current.toString());
                current.delete(0, current.length());
            }
            // 是运算符
            else {
                // 首先替换括号
                ch = ch == '{' ? '(' : ch;
                ch = ch == '}' ? ')' : ch;
                ch = ch == '[' ? '(' : ch;
                ch = ch == ']' ? ')' : ch;
                String chStr = "" + ch;
                // 判断优先级，(级别高于任何
                // stackTop是字符串，应该用equals判断！！！！
                String stackTop = operators.size() == 0 ? null : operators.peek();
                if (ch == '(') {
                    operators.push(chStr);
                }
                if (ch == '*' || ch == '/') {
                    if (stackTop == null || stackTop.equals("(")) {
                        operators.push(chStr);
                    } else if (stackTop == null || stackTop.equals("*") || stackTop.equals("/")) {
                        nums.push(operators.pop());
                        operators.push(chStr);
                    } else if (stackTop == null || stackTop.equals("+") || stackTop.equals("-")) {
                        operators.push(chStr);
                    }
                }

                if (ch == '+') {
                    if (stackTop == null || stackTop.equals("(")) {
                        operators.push(chStr);
                    } else {
                        nums.push(operators.pop());
                        operators.push(chStr);
                    }
                }

                if (ch == '-') {
                    // 减号肯定不出现在最后
                    // 只要前面不是数字，就是负号
                    if (i == 0 || !isNum(expression.charAt(i - 1))) {
                        current.append(ch);
                        int j = i;
                        while (++j < expression.length() && isNum(ch = expression.charAt(j))) {
                            current.append(ch);
                        }
                        // 入栈当前操作数，清空current
                        nums.push(current.toString());
                        current.delete(0, current.length());
                    } else {
                        if (stackTop == null || stackTop.equals("("))
                            operators.push(chStr);
                        else {
                            nums.push(operators.pop());
                            operators.push(chStr);
                        }
                    }
                }

                // operations连续pop并放入nums直到遇到(
                if (ch == ')') {
                    while (!stackTop.equals("(")) {
                        nums.push(operators.pop());
                        stackTop = operators.peek();
                    }
                    // 弹出(
                    operators.pop();
                }
            }
        }
        // 将operators中的内容全部弹入到nums
        while (!nums.empty()){
            operators.push(nums.pop());
        }

        int size = operators.size();
        String[] postOrderExpression = new String[size];
        for (int i = 0; i < size; i++) {
            postOrderExpression[i] = operators.pop();
        }
        return postOrderExpression;
    }


    private static boolean isNum(char ch) {
        if (ch >= '0' && ch <= '9') {
            return true;
        }
        return false;
    }

    public static boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }
}

