package jianzhiOffer.dynamic_programming.maxSubArray;

/**
 * @author guanhhhua
 */
public class MaxSubArray {
    public static void main(String[] args) {
        System.out.println(new Solution2().maxSubArray(new int[]{1,2}));
    }
}

/**
 * 我的做法：用滑动窗口去做
 */
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int start = 0;
        int end = 0;
        int sumFromStartToEnd = nums[0];
        int max = sumFromStartToEnd;
        for (int i = 0; i < nums.length - 1; i++) {
            /**如果sum为负数，则直接将start指针移动到end的后一位*/
            if (sumFromStartToEnd <= 0) {
                start = ++end;
                end = start;
                sumFromStartToEnd = nums[start];
                max = max > sumFromStartToEnd ? max : sumFromStartToEnd;
            }
            else {
                end++;
                sumFromStartToEnd += nums[end];
                max = max > sumFromStartToEnd ? max : sumFromStartToEnd;
            }
        }
        return max;
    }
}

class Solution2 {
    public int maxSubArray(int[] nums) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        int max = sum[0];
        /**nums.length == 1 则不会进入到这个循环内部*/
        for (int i = 1; i < nums.length; i++) {
            /**如果sum为负数，则说明将前面的数组加进去对和是负贡献，则令sum[i] = nums[i]，直接排除掉前面的所有数组*/
            /**这个操作就是将滑动窗口转换成动态规划的关键*/
            sum[i] = sum[i - 1] > 0 ? sum[i - 1] + nums[i] : nums[i];
            // Math.max的实现就是用三元运算符……
            max = Math.max(sum[i], max);
        }
        return max;
    }
}