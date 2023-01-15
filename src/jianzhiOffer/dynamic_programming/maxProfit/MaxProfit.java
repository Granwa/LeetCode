package jianzhiOffer.dynamic_programming.maxProfit;

/**
 * @author guanhhhua
 */
public class MaxProfit {
    public static void main(String[] args) {
        System.out.println(new Solution2().maxProfit(new int[]{7,1,5,3,6,4}));
    }
}

/**
 * 这个解法虽然用数组记录下了子问题的解，但是完全没有在后续问题中复用
 * 是披着动态规划皮的暴力双循环解法
 */
class Solution {
    public int maxProfit(int[] prices) {
        /**开辟空间时使用已有条件限制大小*/
        int max = 0;
        int[][] profit = new int[prices.length][prices.length];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < i ; j++) {
                profit[i][j] = prices[i] - prices[j];
                max = profit[i][j] > max ? profit[i][j] : max;
            }
        }
        return max;
    }
}

class Solution2 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        /**最大利润赋初值为0，第i天前一天的最小价格，应该赋值为第0天的价格*/
        int maxProfit = 0;
        int minPriceTillTheDayBeforeDayI = prices[0];
        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit,prices[i] - minPriceTillTheDayBeforeDayI);
            minPriceTillTheDayBeforeDayI = Math.min(minPriceTillTheDayBeforeDayI,prices[i]);
        }
        return maxProfit;

    }
}