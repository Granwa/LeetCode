package 凑24点游戏;

import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[] cards = {4, 1, 8, 7};
        System.out.println(Solution.judgePoint24(cards));
    }
}

class Solution {
    public static boolean judgePoint24(int[] cards){
        double[] doubles = Arrays.stream(cards).asDoubleStream().toArray();
        return judgePoint24(doubles);
    }

    public static boolean judgePoint24(double[] cards) {
        // 在后面递归的过程中，cards作为被传入的temp参数，其长度不断减少，以len == 1作为递归的出口
        int len = cards.length;
        if (len == 1){
            return Math.abs(cards[0] - 24) < 1e-9; // 差距小于这个范围就认为相等
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                boolean isValid = false;
                // 每次两数操作：由于两个数操作之后变成了一个数，因此创建新的长度为len-1的临时double[]数组，temp
                double[] temp = new double[len - 1];
                //使用copy待删除元素j的前部
                System.arraycopy(cards, 0, temp, 0, j);
                //使用copy待删除元素j的后部
                System.arraycopy(cards,j + 1, temp, j, temp.length - j);
                // temp就变成了除开元素cards[j]的剩余部分的数组
                // 比如[4.0, 1.0, 8.0, 7.0]，i=0，j=1时，temp就是[4.0, 8.0, 7.0];

                // 加法
                // temp中删掉了cards[j]元素，然后又替换了cards[i]元素，因此temp中最终存储的就是被选出的两个操作数的结果，和其他没有被选中的操作数
                temp[i] = cards[i] + cards[j];
                // 用isValid短路或作为判断条件，为true时跳过后续判断，实现剪枝。
                isValid = isValid || judgePoint24(temp);

                // 减和被减
                temp[i] = cards[i] - cards[j];
                isValid = isValid || judgePoint24(temp);
                temp[i] = cards[j] - cards[i];
                isValid = isValid || judgePoint24(temp);

                // 乘法
                temp[i] = cards[i] * cards[j];
                isValid = isValid || judgePoint24(temp);

                // 除和被除
                if (cards[j] != 0){
                    temp[i] = cards[i] / cards[j];
                    isValid = isValid || judgePoint24(temp);
                }
                if (cards[i] != 0){
                    temp[i] = cards[j] / cards[i];
                    isValid = isValid || judgePoint24(temp);
                }

                if (isValid){
                    return true;
                }
            }
        }
        return false;
    }
}