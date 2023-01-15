package HJ.HJ15求int型正整数在内存中存储时1的个数;

import java.util.Scanner;

/**
 * 将数字转化为二进制并统计其中1的个数
 * @author guanhhhua
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dec = scanner.nextInt();
        String s = Integer.toBinaryString(dec);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count ++ ;
            }
        }
        System.out.println(count);
    }
}
