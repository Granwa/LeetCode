package HJ.HJ32密码截取.最长对称子串;

import java.util.Scanner;

// 放弃动态规划，暴力双循环
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            int oddLen = 1;
            int evenLen = 0;
            for (int j = 1; j < str.length(); j++) {
                // 以下标i为中心的奇数长度回文串
                if ((i - j >= 0) && (i + j < str.length())) {
                    if (str.charAt(i - j) == str.charAt(i + j)) {
                        oddLen += 2;
                    } else {
                        // 不是回文串就要中断，否则会出现中间一段不对称，两边又对称的情况，导致多判
                        break;
                    }
                }
                max = Math.max(max, oddLen);
            }

            for (int j = 1; j < str.length(); j++) {
                // 以下标i为左偏移中心的偶数长度回文串
                if ((i - j + 1 >= 0) && (i - j + 1 < str.length()) && (i + j < str.length())) {
                    if (str.charAt(i - j + 1) == str.charAt(i + j)) {
                        evenLen += 2;
                    } else {
                        break;
                    }
                }
                max = Math.max(max,evenLen);
            }
        }
        System.out.println(max);
    }
}
