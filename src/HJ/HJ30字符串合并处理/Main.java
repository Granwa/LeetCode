package HJ.HJ30字符串合并处理;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 对输入字符串逐字符处理，使用StringBuilder将字母拼接成单词
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        ArrayList<String> wordList = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                sb.append(ch);
            } else {
                wordList.add(sb.toString());
                sb.delete(0, sb.length());
            }
        }
        if (sb.length() > 0) {
            wordList.add(sb.toString());
        }
        for (int i = wordList.size() - 1; i >= 0; i--) {
            System.out.println(wordList.get(i));
        }
    }
}

/**
 * 分隔字符串时，输入正则表达式(regex，即regular expression)
 */
class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] wordArray = input.split("[^a-zA-Z]");
        for (int i = wordArray.length - 1; i >= 0; i--) {
            System.out.println(wordArray[i] + " ");
        }
    }
}