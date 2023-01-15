package HJ.HJ5进制转换;

import java.util.Scanner;

/**
 * @author guanhhhua
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String hex = sc.next();
        int numDec = 0;
        int cardinal = 1;
        int decimal = 0;
        for (int i = hex.length() - 1; i >= 2; i--) {
            char numHex = hex.charAt(i);
            if (numHex >= '0' && numHex <= '9') {
                // 可以都使用ASCII码来转换成十进制数字
                numDec = numHex - '0';
            }else {
                numDec = numHex - 'A' + 10;
            }
            decimal += numDec * cardinal;
            // 进位一次，基数变为之前的16倍
            cardinal *= 16;
        }
        System.out.println(decimal);
    }
}

/**
 * parseInt()参数可以直接传入进制
 */
class Main2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String hex = sc.next();
        System.out.println(Integer.parseInt(hex.substring(2,hex.length()),16));
    }
}
