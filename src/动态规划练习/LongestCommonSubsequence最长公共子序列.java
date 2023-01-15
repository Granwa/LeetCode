package 动态规划练习;

public class LongestCommonSubsequence最长公共子序列 {
    // 动态规划
    static class Solution {
        public static int longestCommonSubsequence(String text1, String text2) {
            // 表示text1第i位之前，text2第j位之前的最长子序列长度
            int[][] dp = new int[text1.length() + 1][text2.length() + 1];

            for (int i = 1; i < text1.length() + 1; i++) {
                for (int j = 1; j < text2.length() + 1; j++) {
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1],dp[i - 1][j]);
                    }
                }
            }
            return dp[text1.length()][text2.length()];
        }
    }
}
