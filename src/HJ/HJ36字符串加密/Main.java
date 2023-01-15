package HJ.HJ36字符串加密;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 确实，用HashMap是一个更好的选择
        // 字母顺序表首先全部用小写吧
        Scanner scanner = new Scanner(System.in);
        String encrypt = scanner.nextLine();
        String input = scanner.nextLine();

        HashMap<Character, Character> map = new HashMap<>();

        // 对给定密码字符串去重并建立字母表
        // 要注意对谁加密，就用做key
        for (int i = 0; i < encrypt.length(); i++) {
            if (!map.containsValue(Character.toLowerCase(encrypt.charAt(i)))){
                map.putIfAbsent( (char) ('a' + map.size()), Character.toLowerCase(encrypt.charAt(i)));
            }
        } // 对剩余未出现的字母建立字母表
        for (int i = 0; i < 26; i++) {
            if (!map.containsValue((char) ('a' + i))){
                map.putIfAbsent((char) ('a' + map.size()), (char) ('a' + i));
            }
        }

        for (int i = 0; i < input.length(); i++) {
            if ((input.charAt(i) >= 'a') && (input.charAt(i) <= 'z')){
                System.out.print(map.get(input.charAt(i)));
            }else if ((input.charAt(i) >= 'A') && (input.charAt(i) <= 'Z')){
                System.out.print(Character.toUpperCase(map.get(input.charAt(i))));
            }else {
                System.out.println(input.charAt(i));
            }
        }
    }
}
