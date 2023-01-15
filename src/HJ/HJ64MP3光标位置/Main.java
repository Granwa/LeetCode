package HJ.HJ64MP3光标位置;


import org.junit.Test;

import java.util.Scanner;

public class Main {
    /**
     * 使用滑动窗口实现
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalCount = sc.nextInt();
        String instructions = sc.next();
        // 滑动窗口
        int[] window = new int[4];
        int index = 0;
        for (int i = 0; i < instructions.length(); i++) {
            char ch = instructions.charAt(i);
            switch (ch){
                case 'U': index = (index - 1 + 4) % 4;
                case 'D': index = (index + 1 ) % 4;
                default:;
            }
        }
    }
}

