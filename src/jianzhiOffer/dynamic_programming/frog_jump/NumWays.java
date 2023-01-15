package jianzhiOffer.dynamic_programming.frog_jump;

import java.util.ArrayList;

/**
 * @author guanhhhua
 */
public class NumWays {
    public static void main(String[] args) {
        System.out.println(new Solution().numWays(2));
    }
}

class Solution {
    public int numWays(int n) {
        ArrayList<Integer> f = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            /**初始条件*/
            if (i == 0 || i == 1) f.add(i,1);
            /**动态规划的体现使用：总共跳n步的方法种类数，化为：跳n-1步的方法种类(最后跳1步)+跳n-2步的方法种类(最后跳2步)*/
            else if (f.get(i - 1) + f.get(i - 2) >= 1000000007) f.add(i,f.get(i - 1) + f.get(i - 2) - 1000000007);
            else f.add(i,f.get(i - 1) + f.get(i - 2));
        }
        return f.get(n);
    }
}

/**
 * 使用数组的版本
 */
class Solution2 {
    public int numWays(int n) {
        int []f = new int[101];
        for (int i = 0; i <= n; i++) {
            if (i == 0 || i == 1) f[i] = 1;
            else if (f[i - 1] + f[i -2] >= 1000000007) f[i] = f[i - 1] + f[i -2] - 1000000007;
            else f[i] = f[i - 1] + f[i -2];
        }
        return f[n];
    }
}

