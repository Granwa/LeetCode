package 动态规划练习;

import java.util.Scanner;

// 0-1背包问题
public class Package01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int totalWeight = sc.nextInt();
        int[] weight = new int[count];
        int[] values = new int[count];
        for (int i = 0; i < count; i++) {
            // 存储重量
            weight[i] = sc.nextInt();
        }
        sc.nextLine(); // 读取换行符
        for (int i = 0; i < count; i++) {
            // 存储价值
            values[i] = sc.nextInt();
        }

        // 创建动态规划备忘录
        // dp[i][w]：考虑前i个物品是否装入背包时，剩余可容纳的重量为j
        int[][] dp = new int[count + 1][totalWeight + 1];
        // 数组会自动进行默认初始化
        // 初始化第一列，即背包 可容纳重量为0
        // 初始化第一行，即放入物品数量为0
        for (int i = 1; i < count + 1; i++) {
            for (int w = 1; w < totalWeight + 1; w++) {
                if (w - weight[i - 1] < 0) {
                    // 放不进去就只能丢掉，那么该位置的最大价值，就等于只考虑前i - 1个物品，且重量不变的情况下的最大价值
                    dp[i][w] = dp[i - 1][w];
                }else {
                    // 第i个物品不放入背包和放入背包两种情况，取两者的价值的最大值
                    // 要注意的是，dp的长度为[count + 1][weight + 1]而weight和value的长度都是count，因此要注意正确的下标
                    dp[i][w] = Math.max(dp[i - 1][w],
                            dp[i - 1][w - weight[i - 1]] + values[i - 1]);
                }
            }
        }
        System.out.println(dp[count][totalWeight]);
    }
}