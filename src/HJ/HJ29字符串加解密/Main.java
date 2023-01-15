package HJ.HJ29字符串加解密;

import org.junit.Test;

import javax.lang.model.util.ElementFilter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println(encrypt(s1));
        System.out.println(decrypt(s2));
    }

    public static String encrypt(String str){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= '0' && ch <= '9'){
                sb.append((ch - '0' + 1) % 10);
            }else if (ch >= 'a' && ch < 'z'){
                sb.append((char) (((ch + 1)) - 'a' + 'A'));
            }else if (ch >= 'A' && ch < 'Z'){
                sb.append((char) (((ch + 1)) - 'A' + 'a'));
            }else if (ch == 'z'){
                sb.append('A');
            }else if (ch == 'Z'){
                sb.append('a');
            }
        }
        return sb.toString();
    }

    public static String decrypt(String str){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= '0' && ch <= '9'){
                sb.append((ch - '0' - 1 + 10) % 10);
            }else if (ch > 'a' && ch <= 'z'){
                sb.append((char) ((ch - 1) - 'a' + 'A'));
            }else if (ch > 'A' && ch <= 'Z'){
                sb.append((char) ((ch - 1) - 'A' + 'a'));
            }else if (ch == 'a'){
                sb.append('Z');
            }else if (ch == 'A'){
                sb.append('z');
            }
        }
        return sb.toString();
    }

    @Test
    public void test(){
        System.out.println(Integer.valueOf('0'));
    }
}
