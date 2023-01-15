package jianzhiOffer.search.findNumberIn2DArray;

public class FindNumberIn2DArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {{1,1}};
        System.out.println(solution.findNumberIn2DArray(matrix, 20));
    }
}

class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        /*
            思路：将矩阵的左下或右上索引作为根节点，将矩阵视为一个二叉排序树
         */
        if(matrix.length == 0) return false;
        int i = matrix.length - 1; // 要特别注意行和列的分别应该是什么.length
        int j = 0;
        while (i >= 0 && j <= matrix[0].length - 1) {
            if (target == matrix[i][j]) return true;
            else if (target > matrix[i][j]) j++;
            else if (target < matrix[i][j]) i--;
        }
        return false;
    }
}