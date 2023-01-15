package HJ.HJ3明明随机数;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 给定N个1~500的随机数字，去除重复数字并按从小到大的顺序输出
 * 使用HashMap实现(实际上用HashSet就可以，但是HashSet的实现也是依赖于HashMap的)
 *
 * @author guanhhhua
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        HashMap<Object, Object> map = new HashMap<>(count);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            map.putIfAbsent(num, num);
        }
        for (int i = 1; i < 500; i++) {
            if (map.get(i) != null) {
                System.out.println(map.get(i));
            }
        }
    }
}

/**
 * 使用TreeSet去重排序机制
 */
class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        TreeSet set = new TreeSet();
        while (scanner.hasNext()){
            set.add(scanner.nextInt());
        }
        for (Object o : set) {
            System.out.println(o);
        }
    }
}

/**
 * 使用数组实现
 */
class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] nums = new int[count];
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            nums[num - 1] = num;
        }
        for (int num : nums) {
            if (num != 0) {
                System.out.println(num);
            }
        }
    }
}