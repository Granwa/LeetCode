//package HJ.HJ18识别有效的IP地址和掩码并进行分类统计;
//
//import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
//
//import java.util.Scanner;
//
///**
// * @author guanhhhua
// * 所有的IP地址划分为 A,B,C,D,E五类
// * A类地址从1.0.0.0到126.255.255.255;
// * B类地址从128.0.0.0到191.255.255.255;
// * C类地址从192.0.0.0到223.255.255.255;
// * D类地址从224.0.0.0到239.255.255.255；
// * E类地址从240.0.0.0到255.255.255.255
// * ip地址除了可以输入具体数，还可以输入*表示任意匹配
// *
// * 子网掩码为二进制下前面是连续的1，然后全是0。（例如：255.255.255.32就是一个非法的掩码）
// * （注意二进制下全是1或者全是0均为非法子网掩码）
// */
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int A = 0;
//        int B = 0;
//        int C = 0;
//        int D = 0;
//        int E = 0;
//        int err = 0;
//        while (sc.hasNext()){
//            String ip = sc.next();
//            String mask = sc.next();
//            // ip要求对地址进行分类
//            // mask要求其二进制结果为前面全1，后面全0，且全0或全1是非法掩码
//            String[] ipSegments = ip.split(".");
//            String[] maskSegments = mask.split(".");
//
//            int[]
//
//            String maskString = "";
//            for (String maskSegment : maskSegments) {
//                // radix:进制
//                Integer segInteger = Integer.parseInt(maskSegment, 2);
//                String segString = segInteger.toString();
//                maskString += segString;
//            }
//            boolean matches = maskString.matches("1+0+");
//            if (!matches){
//                err ++;
//            }
//        }
//    }
//}
