package HJ.HJ1字符串最后一个单词长度;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author guanhhhua
 */
public class LastLength {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = 0;
        while (scanner.hasNext()){
            String next = scanner.next();
            length = next.length();
        }
        System.out.println(length);
    }
}
