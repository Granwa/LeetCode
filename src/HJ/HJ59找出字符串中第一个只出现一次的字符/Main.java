package HJ.HJ59找出字符串中第一个只出现一次的字符;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// 要找第一个出现的，因此需要记录下index
// 可以直接使用indexOf()和lastIndexOf()是否相等来判断
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            Integer index = map.putIfAbsent(input.charAt(i), i);
            if (index != null) {
                map.put(input.charAt(i), -1);
            }
        }
        // 注意stream.filter.collect的用法
        // collect()里的参数是一个Collector，我们可以用Collectors工具类的方法toList()来获取一个用于转换成List的Collector
        List<Integer> indexList = map.values().stream().filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer != -1;
            }
        }).collect(Collectors.toList());
        indexList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        if (indexList.size() != 0) {
            System.out.println(input.charAt(indexList.get(0)));
        } else {
            System.out.println(-1);
        }
    }
}

/**
 * 使用indexOf()和lastIndexOf()是否相等来判断
 */
class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        ArrayList<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (input.indexOf(ch) == input.lastIndexOf(ch)){
                indexList.add(i);
            }
        }
        if (indexList.size() != 0){
            System.out.println(input.charAt(indexList.get(0)));
        }else {
            System.out.println(-1);
        }
    }
}