package HJ.HJ39判断两个IP是否属于同一子网;

import java.util.Scanner;

/**
 * 包含了如何将ip转化成二进制，如何对二进制进行位运算等问题
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String mask = sc.nextLine();
            String ip1 = sc.nextLine();
            String ip2 = sc.nextLine();
            System.out.println(sameSubnet(mask,ip1,ip2));
        }
    }

    private static int sameSubnet(String mask, String ip1, String ip2){
        if (!ipLegal(ip1) || !ipLegal(ip2)){
            return 1;
        }
        if (!maskLegal(mask)){
            return 1;
        }
        if (doMask(mask,ip1).equals(doMask(mask,ip2))){
            return 0;
        }
        return 2;
    }

    private static boolean ipLegal(String ip){
        String[] split = ip.split("\\.");
        for (int i = 0; i < split.length; i++) {
            int decNum = Integer.parseInt(split[i]);
            if (decNum < 0 || decNum > 255){
                return false;
            }
        }
        return true;
    }

    private static boolean maskLegal(String mask){
        String[] split = mask.split("\\.");
        for (int i = 0; i < split.length; i++) {
            int decNum = Integer.parseInt(split[i]);
            if (decNum < 0 || decNum > 255){
                return false;
            }
        }

        String binaryMask = toBinary(mask);
        int first0 = binaryMask.indexOf('0');
        int last1 = binaryMask.lastIndexOf('1');
        if (first0 < last1){
            return false;
        }
        return true;
    }

    private static Long doMask(String mask, String ip){
        return toLong(mask) & toLong(ip);
    }

    private static Long toLong(String mask) {
        String binary = toBinary(mask);
        return Long.parseLong(binary,2);
    }

    private static String toBinary(String mask) {
        String[] split = mask.split("\\.");
        String binary = "";
        // 点分十进制转“非点分二进制时”，要将每个二进制数补全成8位
        for (int i = 0; i < 4; i++) {
            String binarySplit = Integer.toBinaryString(Integer.parseInt(split[i]));
            int length = binarySplit.length();
            for (int j = 0; j < 8 - length; j++) {
                binarySplit = '0' + binarySplit;
            }
            binary += binarySplit;
        }
        return binary;
    }
}
