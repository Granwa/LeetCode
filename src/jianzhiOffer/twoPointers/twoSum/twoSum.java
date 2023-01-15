package jianzhiOffer.twoPointers.twoSum;


public class twoSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.twoSum(new int[] {14,15,16,22,53,60},76));
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int pointer1 = 0;
        int pointer2 = nums.length - 1;
        while(true){
            int sum = nums[pointer2] + nums[pointer1];

            if (sum == target) break;
            if (pointer1 == pointer2) return new int[] {};
            if (sum > target){pointer2 -- ;}
            if (sum < target){pointer1 ++ ;}
        }
//        assertArrayEquals(new int[] {16,60},new int[] {nums[pointer1],nums[pointer2]});
        return new int[] {nums[pointer1],nums[pointer2]};
    }
}
