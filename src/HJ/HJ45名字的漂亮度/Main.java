package HJ.HJ45名字的漂亮度;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 给定字符串，给每个字符赋分(给定分数范围)，求最大的可能分数
 * 即找到各个字符(本题中，只有小写字母出现)出现的次数
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        while (sc.hasNext()) {
            String str = sc.nextLine();
            HashMap<Character, Integer> map = new HashMap<>();
            // 记录出现次数
            for (int i = 0; i < str.length(); i++) {
                Integer count = map.putIfAbsent(str.charAt(i), 1);
                if (count != null) {
                    map.put(str.charAt(i), count + 1);
                }
            }
            // 将value转化成list并将其排序
            ArrayList<Integer> countList = new ArrayList<>(map.values());
            // 逆序排序
            countList.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            int beauty = 0;
            for (int i = 0; i < countList.size(); i++) {
                 beauty += countList.get(i) * (26 - i) ;
            }
            System.out.println(beauty);
        }
    }
}
