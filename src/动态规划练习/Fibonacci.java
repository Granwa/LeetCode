package 动态规划练习;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fib(2));
    }

    private static int fib(int n) {
        // 这个数组，就是所谓的备忘录
        int[] fibList = new int[n];
        // 自底向上，解决子问题，合并成总问题
        for (int i = 0; i < n ; i++) {
            if (i == 0 || i == 1) {
                // 初始条件
                fibList[i] = 1;
            }else {
                fibList[i] = fibList[i - 1] + fibList[i - 2];
            }
        }
        return fibList[n - 1];
    }
}
