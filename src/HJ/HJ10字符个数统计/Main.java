package HJ.HJ10字符个数统计;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author guanhhhua
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> set = new HashSet<>();
//            nextInt()以空格为分隔符
//            int c = sc.nextInt();
        String s = sc.next();
        for (int i = 0; i < s.length(); i++) {
            set.add((int) s.charAt(i));
        }
        System.out.println(set.size());
    }
}

/**
 * 位图
 */
class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BitSet bitSet = new BitSet(128);
        String s = sc.next();
        for (int i = 0; i < s.length(); i++) {
            bitSet.set(s.charAt(i));
        }
        System.out.println(bitSet.cardinality());
    }
}

/**
 * 直接用数组统计，耗时最短但是空间占用最大3
 */

class Main3 {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        String s = sc.next();
        int[] array = new int[128];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(array[s.charAt(i)] != 0){
                continue;
            }
            array[s.charAt(i)] = 1;
            count++;
        }
        System.out.println(count);
    }
}