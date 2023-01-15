package HJ.HJ4字符串分隔;

import java.util.Scanner;

/**
 * 使用StringBuilder
 * @author guanhhhua
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (sc.hasNext()) {
            String next = sc.next();
            sb.append(next);
        }
        for (int i = 0; i < sb.length()%8; i++) {
            sb.append('0');
        }
        String stringComplete = sb.toString();
        int i;
        for (i = 0; i < stringComplete.length(); i += 8) {
            System.out.println(stringComplete.substring(i, i + 8));
        }
    }
}

/**
 * 不使用StringBuilder，直接用String的加法
 */
class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = new String();
        while (sc.hasNext()) {
            String next = sc.next();
            s += next;
        }
        for (int i = 0; i < s.length()%8; i++) {
            s += '0';
        }
        int i;
        for (i = 0; i < s.length(); i += 8) {
            System.out.println(s.substring(i, i + 8));
        }
    }
}