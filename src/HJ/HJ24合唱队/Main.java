package HJ.HJ24合唱队;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 合唱队形即：找到最长上升子序列 和 最长下降子序列
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] left = new int[n]; // 每个数左边小于其的数的个数
        int[] right = new int[n]; // 每个数右边小于其的数的个数
        // 初始条件，序列包含自身，所以最后要-1
        left[0] = 1;
        right[n - 1] = 1;
        // 计算每个位置左侧的最长递增序列
        for (int i = 0; i < n; i++) {
            left[i] = 1; // 一个数字自己构成一个序列
            for (int j = 0 ; j < n; j++) { // j~i的范围内的最长子序列，因为要找的是左边的
                if (arr[j] < arr[i]){
                    left[i] = Math.max(left[j] + 1, left[i]);
                }
            }
        }

        // 计算每个位置右侧的最长递减序列
        for (int i = n - 1; i >= 0; i--) {
            right[i] = 1; // 一个数字自己构成一个序列
            for (int j = n - 1; j >= i; j--) { // 以每个数字为起点依次判断(并不是说用了动态规划就一定不能出现双循环！这是二维动态规划类型！)
                if (arr[j] < arr[i]){
                    right[i] = Math.max(right[j] + 1, right[i]);
                }
            }
        }

        // 对于第i个元素，已知其左边的最长递增序列，和其右边的最长递减㤡
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = n - (left[i] + right[i] - 1); // -1因为重复算了一次
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, result[i]);
        }
        System.out.println(min);
    }
}
