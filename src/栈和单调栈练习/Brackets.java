package 栈和单调栈练习;

import java.util.Stack;

public class Brackets {
    public static void main(String[] args) {
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                // 左括号则无需匹配进行入栈
                stack.push(ch);
            } else {
                // 一旦遇到右括号就需要进行匹配如果匹配就出栈，如果不匹配就立刻退出方法
                if (!stack.empty() && isLeftBracket(ch, stack.peek())){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        // 到最后栈为空，则表示括号匹配成功
        return stack.empty();
    }

    private static boolean isLeftBracket(char ch1, char ch2) {
        switch (ch1) {
            case '}' : return ch2 == '{';
            case ']' : return ch2 == '[';
            case ')' : return ch2 == '(';
            default: return false;
        }
    }
}
