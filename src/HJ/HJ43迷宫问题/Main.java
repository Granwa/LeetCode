package HJ.HJ43迷宫问题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

// 矩阵的深度优先遍历
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] matrix = new int[m][n];

        // 构造迷宫
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // 记录路径的数组
        List<Coordinate> path = new ArrayList<>();
        // 使用深度优先搜索dfs遍历路径，从左上角开始搜索
        dfs(matrix, path, 0 ,0 );
        for (Coordinate coordinate : path) {
            System.out.println(coordinate);
        }
    }

    // 从左上角(0,0)到右下角(m-1,m-1)
    private static boolean dfs(int[][] matrix, List<Coordinate> path, int x, int y){
        // 加入可达路径
        path.add(new Coordinate(x,y));
        // 标记为已经走过，不能再走
        matrix[x][y] = 1;
        // 走完了
        if (x == matrix.length - 1 && y == matrix[0].length -1){
            return true;
        }

        // 能向下走
        if (x + 1 < matrix.length  && matrix[x + 1][y] == 0){
            if(dfs(matrix, path, x + 1,y)){
                return true;
            }
        }
        // 能向上走
        if (x - 1 >= 0  && matrix[x - 1][y] == 0){
            if(dfs(matrix, path, x - 1,y)){
                return true;
            }
        }
        // 能向右走
        if (y + 1 < matrix[0].length  && matrix[x][y + 1] == 0){
            if(dfs(matrix, path, x ,y + 1)){
                return true;
            }
        }
        // 能向左走
        if (y - 1 >= 0  && matrix[x][y - 1] == 0){
            if(dfs(matrix, path, x ,y - 1)){
                return true;
            }
        }
        // 都走不通，则回溯
        // 从路径中删除当前坐标，将当前坐标标记为还没走过
        path.remove(path.size() -1);
        matrix[x][y] = 0;
        return false;
    }
}

class Coordinate {
    int x;
    int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "("+x+","+y+")";
    }
}
