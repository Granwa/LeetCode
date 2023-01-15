package HJ.HJ63DNA序列;

import java.util.Scanner;

// 本题还应注意滑动窗口的解法，以及如何使用正则表达式来进行包含GC量的计算
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int subLen = sc.nextInt();
        String substring = input.substring(0, subLen);
        int count = 0;
        int index = 0;
        for (int i = 0; i < subLen; i++) {
            if (substring.charAt(i) == 'G' || substring.charAt(i) == 'C'){
                count ++;
            }
        }
        // 注意用于记录的max应该在何时被赋值
        int max = count;

        for (int i = 1; i < input.length() - subLen; i++) {
            if (input.charAt(i - 1) == 'G' || input.charAt(i - 1) == 'C'){
                count --;
            }
            if (input.charAt(i + subLen - 1) == 'G' || input.charAt(i +subLen - 1) == 'C') {
                count ++;
            }
            if (count > max) {
                index = i;
                max = count;
            }
        }
        System.out.println(input.substring(index,index+subLen));
    }
}
