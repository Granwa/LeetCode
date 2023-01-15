package HJ.HJ8合并表记录;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        HashMap<Integer,Integer> map = new HashMap(count);
        while (sc.hasNext()){
            // 可以直接使用nextInt()来读，不是必须要直接读一整行再来拆分字符串
            String row = sc.nextLine();
            String[] split = row.split(" ");
            Integer index = Integer.parseInt(split[0]);
            Integer value = Integer.parseInt(split[1]);
            Integer existence = map.get(index);
            if (existence != null){
                map.put(index,value + existence);
            } else {
                map.put(index,value);
            }
        }
        Set<Integer> integers = map.keySet();
        for (Integer integer : integers) {
            System.out.print(integer + " " + map.get(integer));
        }
    }
}
