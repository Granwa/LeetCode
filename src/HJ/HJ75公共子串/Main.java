package HJ.HJ75公共子串;

import java.util.Scanner;

// 公共子串。不是子序列哦
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        int m = str1.length();
        int n = str2.length();

        // 自动初始化首行首列为0
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                // 子串要求连续性
                if ((str1.charAt(i - 1) == str2.charAt(j - 1))) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        System.out.println(max);
    }
}