package HJ.HJ107求解立方根;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double target = sc.nextDouble();
        double left = 0;
        double right = 0;
        if (0 <= target && target <= 1) {
            left = 0;
            right = 1;
        } else if (-1 <= target && target <= 0) {
            left = -1;
            right = 0;
        } else if (target > 1) {
            left = 1;
            right = 3;
        } else if (target < -1) {
            left = -3;
            right = -1;
        }

        System.out.println(String.format("%.1f",binarySearch(left,right,target)));
    }

    public static double binarySearch(double left, double right, double target) {
        if (left == target) return left;
        if (right == target) return right;
        double num = 0;
        double tryNum = 0;
        do {
            num = (left + right) / 2;
            tryNum = num * num * num;
            if (tryNum > target){
                right = num;
            }else if (tryNum < target){
                left = num;
            }
        } while (Math.abs(target - tryNum) > 0.01);
        return num;
    }
}
