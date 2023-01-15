package 动态规划练习;

public class MaxValueOfGift {
    public static void main(String[] args) {
        System.out.println(new Solution().maxValue(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }


    static class Solution {
        public int maxValue(int[][] grid) {
            if (grid.length == 0) return 0;
            int m = grid.length;
            int n = grid[0].length;
            int[][] value = new int[m][n];
            value[0][0] = grid[0][0];
            // 预先初始化首列
            for (int i = 1; i < m; i++) {
                value[i][0] = value[i - 1][0] + grid[i][0];
            }
            // 初始化首行
            for (int i = 1; i < n; i++) {
                value[0][i] = value[0][i - 1] + grid[0][i];
            }
            // 填充内部
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    value[i][j] = Math.max(value[i - 1][j] + grid[i][j], value[i][j - 1] + grid[i][j]);
                }
            }
            return value[m - 1][n - 1];
        }
    }
}