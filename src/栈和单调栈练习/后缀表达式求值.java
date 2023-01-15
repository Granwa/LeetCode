package 栈和单调栈练习;

import org.junit.Test;

import java.util.Stack;

//后缀表达式中不含括号
public class 后缀表达式求值 {
    @Test
    public void test(){
        System.out.println(evalRPN(new String[]{"2","1","-"}));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < tokens.length; i++) {
            if (isNumber(tokens[i])){
                // 如果不自己判断是否为数字，而是直接try-catch，将会非常缓慢
                int num = Integer.parseInt(tokens[i]);
                stack.push(num);
            } else {
                char operator = tokens[i].charAt(0);
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

    public static boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }
}
