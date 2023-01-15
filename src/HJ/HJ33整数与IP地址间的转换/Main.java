package HJ.HJ33整数与IP地址间的转换;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ip = scanner.nextLine();
        String longStr = scanner.nextLine();

        System.out.println(toLong(ip));
        System.out.println(toIP(longStr));
    }

    private static String toIP(String longStr) {
        String binaryString = Long.toBinaryString(Long.parseLong(longStr));
        int len = binaryString.length();
        String ip = "";
        ip +=(Integer.parseInt(binaryString.substring(0, len - 32 + 8), 2) + ".");
        ip +=(Integer.parseInt(binaryString.substring(len - 32 + 8, len - 32 + 16), 2) + ".");
        ip +=(Integer.parseInt(binaryString.substring(len - 32 + 16, len - 32 + 24), 2) + ".");
        ip +=(Integer.parseInt(binaryString.substring(len - 32 + 24, len - 32 + 32), 2));
        return ip;
    }

    private static Long toLong(String ip) {
        // 将十进制ip转化为二进制，并补全为8位
        // split中的字符串就是一个正则表达式，
        String[] split = ip.split("\\.");
        String longBinaryStr = "";
        for (int i = 0; i < split.length; i++) {
            longBinaryStr += to8bitBinary(split[i]);
        }
        return Long.parseLong(longBinaryStr, 2);
    }

    public static String to8bitBinary(String str) {
        Integer dec = Integer.parseInt(str);
        String binaryString = Integer.toBinaryString(dec);
        int length = binaryString.length();
        for (int i = 0; i < 8 - length; i++) {
            binaryString = "0" + binaryString;
        }
        return binaryString;
    }
}
