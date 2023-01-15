package jianzhiOffer.twoPointers.exchangeOdd;

public class Exchange {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1};
        Solution2 solution = new Solution2();
        for (int i : solution.exchange(nums)) {
            System.out.println(i);
        }
    }
}

class Solution {
    public int[] exchange(int[] nums) {
        if (nums.length <= 1) return nums; // 只有一个或为空则无需交换

        int oddPos = 0; // oddPos初始化为0，但是不能保证nums[0]从一开始就是奇数
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                while (nums[oddPos] % 2 == 1 && oddPos < i) // 如果oddPos里存的是奇数，不交换，并将oddPos后移
                {
                    oddPos++;
                }
                int temp = nums[i];
                nums[i] = nums[oddPos];
                nums[oddPos] = temp;
            }
        }
        return nums;
    }
}

class Solution2 {
    /**
     * 双指针，左指针遇到偶数就等着，右指针遇到奇数就交换
     */
    public int[] exchange(int[] nums) {
        if (nums.length == 0) return nums;
        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            while (i < j && nums[i] % 2 == 1) i++; // 注意要把循环结束条件加入到每一次指针移动的while判定中
            while (i < j && nums[j] % 2 == 0) j--;

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--; // 交换完之后再移动到下一个位置
        }
        return nums;
    }
}