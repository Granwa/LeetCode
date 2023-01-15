package jianzhiOffer.search.findRepeatNumber;

import java.util.HashSet;

public class FindRepeatNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3,4,5,6,6};
        System.out.println(solution.findRepeatNumber(nums));
        System.out.println(solution.findRepeatNumberSpaceO1(nums));
    }
}


class Solution {
    public int findRepeatNumber(int[] nums) { // 向哈希表中依次添加数值，每添加一个都查看哈希表中是否已存在
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)){ return num; } // 若添加元素已存在，add()返回false
        }return -1;
    }

    public int findRepeatNumberSpaceO1(int[] nums) {
        int i = 0;
        while (i < nums.length){
            if (nums[i] == i) i++;//交换直到 in order或者本身就已经in order，才能操作下一个索引
             else if (nums[nums[i]] == nums[i]) return nums[i];
                /*
                交换当前数字到和数字相同的索引位置上 ，即交换 nums[i] 和 nums[nums[i]]
                注意交换时要先给nums[nums[i]]赋值，否则num[i]改变后会导致索引更改
                 */
            else
            {
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }

        } return -1;
    }
}