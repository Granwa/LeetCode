package jianzhiOffer.dynamic_programming.max_value_gift;

/**
 * 状态转移：max[i][j] = Math.max(max[i - 1][j], max[i][j - 1]) + grid[i][j]
 * 初始条件：max[0][0] = grid[0][0];
 *
 * @author guanhhhua
 */
public class MaxValue {
    public static void main(String[] args) {
        System.out.println(new Solution().maxValue(new int[][]{{1,3,1},{1,5,1},{3,2,1}}));
    }
}

/**
 * 存放中间结果的数组可以直接在原数组上操作，可以将空间复杂度降低为O(1)
 * 虽然在LeetCode上测试看来，内存消耗并不一定减少……
 */
class Solution {
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                /**处理矩阵的第一行和第一列，数组越界问题*/
                if (i > 0 && j > 0 ) grid[i][j] =  Math.max(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                if (i == 0 && j > 0) grid[i][j] = grid[i][j - 1] + grid[i][j];
                if (i > 0 && j == 0) grid[i][j] = grid[i - 1][j] + grid[i][j];
                if (i == 0 && j == 0) grid[i][j] = grid[0][0];
            }
        }
        return grid[m - 1][n - 1];
    }
}

/***
 * 先将矩阵的第一行和第一列初始化了，再遍历，可以有效减少if-else判断，提高运行效率
 */
class Solution2 {
    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int j = 1; j < n; j++) // 初始化第一行
            grid[0][j] += grid[0][j - 1];
        for(int i = 1; i < m; i++) // 初始化第一列
            grid[i][0] += grid[i - 1][0];
        for(int i = 1; i < m; i++)
            for(int j = 1; j < n; j++)
                grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
        return grid[m - 1][n - 1];
    }
}
