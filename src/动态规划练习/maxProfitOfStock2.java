package 动态规划练习;

public class maxProfitOfStock2 {

}

class Solution {
    public int maxProfit(int[] prices) {
        int[][] profits = new int[prices.length][2];
        if (profits.length > 0) {
            profits[0][0] = 0;
            profits[0][1] = -prices[0];
        }
        for (int i = 1; i < profits.length; i++) {
            profits[i][0] = Math.max(profits[i - 1][0], profits[i - 1][1] + prices[i]); // 无操作或卖出
            profits[i][1] = Math.max(profits[i - 1][1], profits[i - 1][0] - prices[i]); // 无操作或买入
        }
        return profits[prices.length - 1][0]; // 最大利润一定是在最后一天卖出或无操作，不可能是最后一天买入
    }
}