package 动态规划练习;

import java.util.Arrays;

public class MaxTranslateNum {
    public static void main(String[] args) {
        System.out.println(Solution.translateNum(1068385902
        ));
    }
    static class Solution {
        public static int translateNum(int num) {
            String numStr = "" + num;
            int[] categories = new int[numStr.length() + 1];
            for (int i = 0; i < categories.length; i ++){
                if(i == 0) categories[i] = 1;
                if(i == 1) categories[i] = 1;
                if(i > 1 && (Integer.parseInt(numStr.substring(i-2,i)) >= 10) && (Integer.parseInt(numStr.substring(i-2,i)) <= 25)){
                    categories[i] = categories[i - 1] + categories[i - 2];
                }else if (i > 1){
                    categories[i] = categories[i - 1];
                }
            }
            Arrays.sort(categories);
            return categories[categories.length - 1];
        }
    }
}
