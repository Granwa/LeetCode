package 动态规划练习;

public class CoinChange {
    public static void main(String[] args) {
        System.out.println(dp2(new int[]{1, 2, 5}, 11));
    }

    // 递归，暴力解法O(2^n)
    private static int recursion(int[] coins, int amount) {
        // 初始条件和边界条件
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        // 递归，写出递推表达式
        int result = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = recursion(coins, amount - coin);
            // 子问题无解，则跳过后续操作，不能计入一种解
            if (subProblem == -1) continue;
            result = Math.min(result, subProblem + 1);
            // 状态转移方程：dp[n]表示面值为n需要硬币数，dp[n - coin]再凑上1个硬币，就成了dp[n - coin]
            // dp[n] = min(dp[n], dp[n - coin] + 1)
        }
        return result = result < Integer.MAX_VALUE ? result : -1;
    }

    // 使用备忘录消除重叠子问题，自底向上迭代法
    private static int dp1(int[] coins, int amount) {
        // 以数组建立备忘录，关键是抓准状态转移方程，数组中应该装的是什么
        int[] memo = new int[amount + 1];
        // 初始化为边界条件
        for (int i = 0; i < amount + 1; i++) {
            memo[i] = -1;
        }
        // 初始条件
        memo[0] = 0;
        // 建立备忘录
        for (int i = 1; i < amount + 1; i++) {
            int res = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i >= coin && memo[i - coin] != -1) {
                    res = Math.min(res, memo[i - coin] + 1);
                }
            }
            memo[i] = res == Integer.MAX_VALUE ? -1 : res;
        }
//        for (int i = 0; i < amount + 1; i++) {
//            System.out.println(dp[i]);
//        }
        return memo[amount];
    }

    // 使用备忘录消除重叠子问题，自顶向下用带备忘录的递归
    private static int dp2(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        // 边界条件和初始条件(-1表示无解，-2表示尚未计算)
        for (int i = 0; i < amount + 1; i++) {
            memo[i] = -2;
        }
        memo[0] = 0;
        return recursion2(coins,amount,memo);
    }

    private static int recursion2(int[] coins, int amount, int[] memo) {
        if (amount < 0) return -1;
        if (memo[amount] != -2) return memo[amount];
        int result = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 子问题的总金额，应该等于amount - coin，即减去已经匹配的面额
            int subProblem = recursion2(coins, amount - coin, memo);
            if (subProblem == -1) continue;
            result = Math.min(result, subProblem + 1);
        }
        memo[amount] = result == Integer.MAX_VALUE ? -1 : result;
        return memo[amount];
    }
}