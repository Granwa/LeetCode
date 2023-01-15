package HJ.HJ69矩阵乘法;

import javax.crypto.spec.PSource;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();

        int[][] A = new int[x][y];
        int[][] B = new int[y][z];
        int[][] AB = new int[x][z];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                A[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < z; j++) {
                B[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < z; j++) {
                for (int k = 0; k < y; k++) {
                    AB[i][j] += A[i][k]*B[k][j];
                }
                System.out.print(AB[i][j] + " ");
            }
            System.out.println("");
        }
    }
}

