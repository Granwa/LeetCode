package HJ.HJ16购物单;

import java.util.Scanner;

/**
 * 改版0-1背包问题，还是不大会做
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalMoney = scanner.nextInt();
        int totalCount = scanner.nextInt();
        // 满意度备忘录数组
        int[][] result = new int[totalCount + 1][totalMoney + 1];
        // 为了下标对应，将以下3个数组也定义为长度totalCount + 1的数组，同时也为了在has数组中插入0号商品
        int[] price = new int[totalCount + 1];
        int[] content = new int[totalCount + 1];
        int[][] attachment = new int[totalCount + 1][2];
        int[] belongTo = new int[totalCount + 1];

        for (int i = 1; i < totalCount + 1; i++) {
            price[i] = scanner.nextInt();
            content[i] = scanner.nextInt() * price[i];
            int belongToIndex = scanner.nextInt();
            belongTo[i] = belongToIndex;
            if (belongToIndex != 0) {
                if (attachment[belongToIndex][0] == 0){
                    attachment[belongToIndex][0] = i;
                }else {
                    attachment[belongToIndex][1] = i;
                }
            }
        }

        for (int i = 1; i < totalCount + 1; i++) {
            for (int money = 1; money < totalMoney + 1; money++) {
                if (money < price[i] || belongTo[i] != 0) {
                    // 钱不够则不考虑购买这个物品，附件不单独考虑是否购买，而是在购买主件时考虑买几个附件
                    result[i][money] = result[i - 1][money];
                    continue; /**跳过后续判断，后续判断只针对主件和能买得起的状态*/
                }
                // 从上到下，每次都可以用前一次的结果来作为比较对象
                // 注意：买得起是取大于等于
                if (money >= price[i]){
                    result[i][money] = Math.max(result[i - 1][money], result[i - 1][money - price[i]] + content[i]);
                }
                if (money >= (price[i] + price[attachment[i][0]])){
                    result[i][money] = Math.max(result[i][money], result[i-1][money - (price[i] + price[attachment[i][0]])] + content[i] + content[attachment[i][0]]);
                }
                if (money >= (price[i] + price[attachment[i][1]])){
                    result[i][money] = Math.max(result[i][money], result[i-1][money - (price[i] + price[attachment[i][1]])] + content[i] + content[attachment[i][1]]);
                }
                if (money >= (price[i] + price[attachment[i][1]] + price[attachment[i][0]])){
                    result[i][money] = Math.max(result[i][money], result[i-1][money - (price[i] + price[attachment[i][1]] + price[attachment[i][0]])] + content[i] + content[attachment[i][0]] + content[attachment[i][1]]);
                }
            }
        }
        System.out.println(result[totalCount][totalMoney]);
    }
}
