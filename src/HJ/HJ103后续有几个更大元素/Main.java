package HJ.HJ103后续有几个更大元素;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] nums = new int[count];
        for (int i = 0; i < count; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(maxIncrementSequence(nums));
    }

    // 双循环，但是也需要用单调栈
    // 解法错误，子串1545在5入栈后45都无法入栈
    @Deprecated
    private static int latterGreaterCount1(int[] nums) {
        int count = nums.length;
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < count; i++) {
            stack.push(nums[i]);
            for (int j = i + 1; j < count; j++) {
                if (nums[j] > stack.peek()) {
                    stack.push(nums[j]);
                }
            }
            max = Math.max(max, stack.size());
            stack.clear();
        }
        return max;
    }

    /**
     * 正确解法，求最长递增子序列
     */
    private static int maxIncrementSequence(int[] nums) {
        // 数组表示该下标之前，最长的递增子序列
        // 因为不需要给出要从哪个位置开始
        int length = nums.length;
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            dp[i] = 1; // 最小递增子序列长度为一个字符
            for (int j = 0; j < i; j++) {
                // 在i之前寻找最长的递增子序列，把自己加上去
                if (nums[j] < nums[i]) {
                    // dp[i]表示前一个最大值
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int maxLen = 0;
        for (int i = 0; i < length; i++) {
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
