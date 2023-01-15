package HJ.HJ57高精度整数加法;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        int m = str1.length() - 1;
        int n = str2.length() - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder();

        // 从后往前遍历
        while (n >= 0 || m >= 0) {
            // 缺位补0
            int num1 = m < 0 ? 0 :Integer.parseInt("" + str1.charAt(m));
            int num2 = n < 0 ? 0 :Integer.parseInt("" + str2.charAt(n));
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            res.append(sum % 10);
            m --;
            n --;
        }
        // 处理最后的进位
        if (carry > 0){
            res.append(carry);
        }

        System.out.println(res.reverse());
    }
}
