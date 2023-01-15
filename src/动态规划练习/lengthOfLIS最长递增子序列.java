package 动态规划练习;

import java.util.Arrays;

public class lengthOfLIS最长递增子序列 {
    public static void main(String[] args) {

    }

    static class Solution {
        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]){
                        // 终于看懂这段代码了，由于dp[i]在被不断的赋值过程中(最开始是1)
                        // 等于在j遍历的过程中，不断寻找最长的递增序列。而不是直接用i的前一个
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                    }
                }
            }
            int max = 0;
            for (int i = 0; i < nums.length ;i++) {
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }
}
