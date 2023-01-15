package HJ.HJ11数字颠倒;

import java.util.Scanner;

/**
 * @author guanhhhua
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputStr = sc.next();
        for (int i = inputStr.length() - 1; i >= 0; i--) {
            System.out.print(inputStr.charAt(i));
        }
    }
}

/**
 * 使用StringBuilder+reverse
 */
class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new StringBuilder(in.next()).reverse());
    }
}