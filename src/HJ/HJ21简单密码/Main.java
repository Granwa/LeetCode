package HJ.HJ21简单密码;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'c') {
                sb.append('2');
            } else if (ch >= 'd' && ch <= 'f') {
                sb.append('3');
            } else if (ch >= 'g' && ch <= 'i') {
                sb.append('4');
            }else if (ch >= 'j' && ch <= 'l') {
                sb.append('5');
            } else if (ch >= 'm' && ch <= 'o') {
                sb.append('6');
            } else if (ch >= 'p' && ch <= 's') {
                sb.append('7');
            } else if (ch >= 't' && ch <= 'v') {
                sb.append('8');
            } else if (ch >= 'w' && ch <= 'z') {
                sb.append('9');
            } else if (ch >= 'A' && ch <= 'Y') {
                sb.append((char)(ch - 'A' + 'a' + 1));
            } else if (ch == 'Z') {
                sb.append('a');
            } else {
                sb.append(ch);
            }
        }
        System.out.println(sb.toString());
    }
}

class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (sc.hasNext()){
            // 是错误的，不能用nextInt()来接收字符，也没有专门的next来接收字符，只能接收字符串之后再逐字符处理
            char ch = (char) sc.nextInt();
            if (ch >= 'a' && ch <= 'c') {
                sb.append('2');
            } else if (ch >= 'd' && ch <= 'f') {
                sb.append('3');
            } else if (ch >= 'g' && ch <= 'i') {
                sb.append('4');
            }else if (ch >= 'j' && ch <= 'l') {
                sb.append('5');
            } else if (ch >= 'm' && ch <= 'o') {
                sb.append('6');
            } else if (ch >= 'p' && ch <= 's') {
                sb.append('7');
            } else if (ch >= 't' && ch <= 'v') {
                sb.append('8');
            } else if (ch >= 'w' && ch <= 'z') {
                sb.append('9');
            } else if (ch >= 'A' && ch <= 'Y') {
                sb.append((char)(ch - 'A' + 'a' + 1));
            } else if (ch == 'Z') {
                sb.append('a');
            } else {
                sb.append(ch);
            }
        }
        System.out.println(sb.toString());
    }
}
