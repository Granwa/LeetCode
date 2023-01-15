package HJ.HJ66配置文件恢复.最短唯一匹配;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

// 最短唯一匹配，利用String的API：startsWith()
// 只有字符串数量相同的指令才能匹配
// 利用HashMap来存储key和value
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> map = new HashMap<>();
        map.put("reset", "reset what");
        map.put("reset board", "board fault");
        map.put("board add", "where to add");
        map.put("board delete", "no board at all");
        map.put("reboot backplane", "impossible");
        map.put("backplane abort", "install first");
        // 将key以字符串数组的形式存入set中
        HashSet<String[]> set = new HashSet<>();
        for (String s : map.keySet()) {
            set.add(s.split(" "));
        }

        while (sc.hasNext()) {
            String str = sc.nextLine();
            String[] inputArr = str.split(" ");
            ArrayList<String> matchKeyList = new ArrayList<>();
            if (inputArr.length == 1) {
                for (String[] keyArr : set) {
                    // 输入单字符串无法和双字符串匹配
                    if (keyArr.length == 2) {
                        continue;
                    }
                    if (keyArr[0].startsWith(inputArr[0])) {
                        matchKeyList.add(keyArr[0]);
                    }
                }
                // 匹配结束
                if (matchKeyList.size() == 1) {
                    System.out.println(map.get(matchKeyList.get(0)));
                } else {
                    System.out.println("unknown command");
                }
            }

            if (inputArr.length == 2) {
                for (String[] keyArr : set) {
                    // 输入单字符串无法和双字符串匹配
                    if (keyArr.length == 1) {
                        continue;
                    }
                    if (keyArr[0].startsWith(inputArr[0]) && keyArr[1].startsWith(inputArr[1])) {
                        matchKeyList.add(keyArr[0] + " " + keyArr[1]);
                    }
                }
                // 匹配结束
                if (matchKeyList.size() == 1) {
                    System.out.println(map.get(matchKeyList.get(0)));
                } else {
                    System.out.println("unknown command");
                }
            }
        }
    }
}