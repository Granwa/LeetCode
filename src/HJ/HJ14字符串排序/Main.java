package HJ.HJ14字符串排序;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 使用TreeSet实现排序，通过重写compare方法来避免去重
 * 重点在于考察重写compare方法
 *
 * @author guanhhhua
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = Integer.parseInt(in.nextLine());
        TreeSet<String> set = new TreeSet<String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int i = o1.compareTo(o2);
                // 相等的情况下不返回0，避免去重
                return i == 0 ? 1 : i;
            }
        });
        while (in.hasNext()) {
            set.add(in.nextLine());
        }
        for (String s : set) {
            System.out.println(s);
        }
    }
}

/**
 * 使用List，在sort中重写compare方法
 */
class Main2 {
    public static void main(String[] args) {
        
    }
}