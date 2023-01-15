package 栈和单调栈练习;

/**
 * 本题：
 * 1.只要求小括号匹配
 * 2.并非只有括号，而是存在其他非括号字符串
 * 思路：
 * 以左括号为基准，判断其需要多少右括号，一旦右括号不足，才需要补左括号
 */
public class MinAddToValidBrackets {
    public static void main(String[] args) {
        System.out.println(Solution2.minAddToMakeValid("()))"));
    }

    static class Solution {
        public static int minAddToMakeValid(String s) {
            int needRight = 0;
            int needLeft = 0;

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == '(') {
                    needRight ++;
                }
                if (ch == ')') {
                    needRight--;
                    // 并非每次一旦不匹配就需要添加括号，而是以左括号为基准来进行右括号的匹配
                    if (needRight == -1){
                        needRight = 0;
                        needLeft ++;
                    }
                }
            }
            return needLeft+needRight;
        }
    }

    // 假设一个左括号需要匹配两个右括号
    static class Solution2{
        public static int minAddToMakeValid(String s) {
            int needRight = 0;
            int needLeft = 0;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == '(') {
                    needRight += 2;
                }
                if (ch == ')') {
                    needRight--;
                    // 并非每次一旦不匹配就需要添加括号，而是以左括号为基准来进行右括号的匹配
                    if (needRight == -2){
                        needRight = 0;
                        needLeft ++;
                    }
                }
            }
            if (needRight == -1){
                needRight = 1;
                needLeft ++;
            }
            return needLeft+needRight;
        }
    }
}
