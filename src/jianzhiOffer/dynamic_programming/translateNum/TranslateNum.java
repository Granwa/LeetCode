package jianzhiOffer.dynamic_programming.translateNum;

/**
 * @author guanhhhua
 */
public class TranslateNum {
    public static void main(String[] args) {
        System.out.println(new Solution2().translateNum(25));
    }
}

/**
 * 青蛙跳台阶frog_jump
 * 青蛙每次可跳1步或者2步，求青蛙跳了n步总共有几种跳法
 * class Solution {
 *     public int numWays(int n) {
 *         int []f = new int[101];
 *         for (int i = 0; i <= n; i++) {
 *             if (i == 0 || i == 1) f[i] = 1;
 *             else f[i] = f[i - 1] + f[i -2];
 *         }
 *         return f[n];
 *     }
 * }
 * 转移方程：若x(i)和x(i-1)组成的两位数字可以翻译，则dp[i] = dp[i - 1] + dp[i - 2];
 * 若这两位数字只能拆开翻译不能组合翻译，则dp[i] = dp[i - 1];
 *
 * 初始条件：dp[1] = 1 ; 若前两位可以组合翻译，则dp[2] = dp[1] + dp[0]，则推出dp[0] == 1;
 * 注意：截止到字符串的某个字符的可能翻译次数，其索引比在dp数组中小1
 */
class Solution {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 0; i < dp.length; i++) {
            String temp = s.substring(i - 2, i);
            if (temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0){
                dp[i] = dp[i - 1] + dp[i - 2];
            }else{
                dp[i] = dp[i - 1];
            }
        }
        return dp[dp.length - 1];
    }
}

/**
 * 在Solution中，我们发现，随着循环的前进，所有记录过的子问题的解在使用一次之后就不再使用了
 * 因此可以在空间上将dp数组优化成两个变量
 */
class Solution2 {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int a = 1, b = 1;
        for(int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i - 2, i);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }
}