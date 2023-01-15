package HJ.HJ57高精度整数加法错误版;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 本题即用字符串来模拟一个运算器，不要直接调用parseLong()这个API
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        boolean carry = false;
        // 双端队列，pollFirst先进后出
        LinkedList<Integer> list = new LinkedList<>();

        int i;
        int j;
        for (i = str1.length() - 1,j = str2.length() - 1;(i >= 0) &&(j >= 0);i--,j--) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(j);
            int num1 = Integer.parseInt("" + ch1);
            int num2 = Integer.parseInt("" + ch2);
            if (carry){
                list.push((1 + (num1 + num2) %10) % 10);
                if (1 + (num1 + num2) >=10){
                    carry = true;
                }
            }else {
                list.push((num1 + num2) % 10);
            }
            if (num1 + num2 >= 10){
                carry = true;
            } else {
                carry = false;
            }
        }
        i ++;
        j ++;
        // 处理长字符串剩下部分
        String rest = i == 0? null : str1.substring(0,i);
        rest = i < j ? str2.substring(0,j) : rest;

        if (rest != null){
            for (int k = rest.length() - 1; k >= 0; k --){
                int anInt = Integer.parseInt("" + rest.charAt(k));
                if (carry){
                    list.push((1 + anInt) % 10);
                    carry = false;
                    if (1 + anInt >= 10){
                        carry = true;
                    }
                }else {
                    list.push(anInt);
                }
            }
        }
        // 处理最后一个进位
            if (carry){
                list.push(1);
            }
        for (Integer integer : list) {
            System.out.print(integer);
        }
    }
}
