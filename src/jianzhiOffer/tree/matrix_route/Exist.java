package jianzhiOffer.tree.matrix_route;

/**
 * @author guanhhhua
 */
public class Exist {
    public static void main(String[] args) {
        System.out.println(new Solution().exist(new char[][]{{'a', 'b','c','e'},{'s','f','c','s'},{'a','d','e','f'}}
                ,"abcced"));
    }
}

class Solution {
    public boolean exist(char[][] board, String word) {
        int index = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                /**从这里开始触发相等，用深度优先遍历来查找*/
                if (board[i][j] == word.charAt(index)) {
                    if (word.length() == 1) {
                        return true;
                    }
                    if (doSearch(board, i, j, word, ++index)) {
                        return true;
                    }
                    continue;
                }
            }
        }
        return false;
    }

    public boolean doSearch(char[][] board, int i, int j, String word, int index) {
        if (i > 0  && board[i - 1][j] == word.charAt(index)) {
            // UP
            return doSearch(board, i - 1, j, word, ++index);
        }
        if (i < board.length - 1  && board[i + 1][j] == word.charAt(index)) {
            // DOWN
            return doSearch(board, i + 1, j, word, ++index);
        }
        if (j > 0  && board[i][j - 1] == word.charAt(index)) {
            // LEFT
            return doSearch(board, i, j - 1, word, ++index);
        }
        if (j < board[0].length - 1  && board[i][j + 1] == word.charAt(index)) {
            // RIGHT
            return doSearch(board, i, j + 1, word, ++index);
        }
        return false;
    }
}