package HJ.HJ23删除字符串中出现次数最少的字符;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 可以优化的地方在于不需要将最小次数用List存储起来，也不需要使用StringBuild
 * 直接在原字符串输出时，不输出出现次数最少的字母即可
 */
public class Main {
    public static void main(String[] args) {
        HashMap<Character, Integer> countMap = new HashMap();
        ArrayList<Character> minChars = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int min = 20;
        // 统计个数
        for (int i = 0; i < str.length(); i++) {
            Integer previousCount = countMap.putIfAbsent(str.charAt(i), 1);
            if (previousCount != null) {
                countMap.put(str.charAt(i), previousCount + 1);
            }
        }
        // 找出最少字母：可以直接用HashMap自带的min？
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() < min) {
                min = entry.getValue();
                minChars.clear();
                minChars.add(entry.getKey());
            } else if (entry.getValue() == min) {
                minChars.add(entry.getKey());
            }
        }

        // 重构字符串
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (!minChars.contains(str.charAt(i))) {
                sb.append(str.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }
}

class Main2 {
    public static void main(String[] args) {
        HashMap<Character, Integer> countMap = new HashMap();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int min = 20;
        // 统计个数
        for (int i = 0; i < str.length(); i++) {
            Integer previousCount = countMap.putIfAbsent(str.charAt(i), 1);
            if (previousCount != null) {
                countMap.put(str.charAt(i), previousCount + 1);
            }
        }
        // 找出最少字母：可以直接用HashMap自带的min？
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            min = Math.min(min, entry.getValue());
        }

        // 重构字符串
        for (int i = 0; i < str.length(); i++) {
            if (!(countMap.get(str.charAt(i)) == min)) {
                System.out.print(str.charAt(i));
            }
        }
    }
}
