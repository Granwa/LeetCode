package HJ.HJ52计算字符串的编辑距离;

import java.util.Scanner;

// 即最长公共子【序列】
public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str1 = sc.nextLine();
//        String str2 = sc.nextLine();
        System.out.println(minEditDistance("zikwvkijajpkaicihcffiemzexmwjjlyrylxcuoewdmpivudhmgkuodjaurazdjnlgtpwz",
                "wpnmubqfsnmapqpufmmsphqehjplwjkqspnnpywsvvjilxbcfsrygbelquaalenvkruyltiwqcpdrxgstywaja"));
    }

    // 最长公共子序列的算法
    // 本来想用最长长度减去公共子序列的长度，但是这么做是错的
    public static int maxPublicSequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static int minEditDistance (String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m + 1; i++) {
            // 要把子串str1的前i个字符，变成和str的前0个字符(空)相同，需要删除i个字符，所以初始化为i
            dp[i][0] = i;
        }
        for (int j = 0; j < n + 1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < m + 1 ; i++) {
            for (int j = 1; j < n + 1 ; j++) {
                if (str1.charAt(i - 1) != str2.charAt(j - 1)){
                    // 不相等，需要编辑
                    dp[i][j] = Math.min(dp[i - 1][j] + 1,dp[i][j - 1] + 1);
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, dp[i][j]);
                } else {
                    // 相等，不需要编辑
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
