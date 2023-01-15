package jianzhiOffer.search.countNum2;

import java.util.HashMap;

public class CountNum {
    public static void main(String[] args) {
        int[] nums = {6,6,6,6,6,6,6,6};
        int target = 6;
        Solution solution = new Solution();
//        System.out.println(solution.search(nums,target));
    }
}

class Solution {
    public int search(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(target,0);
        for (int num : nums) {
            if (num == target){
                map.put(target,map.get(target)  + 1);
            }
        }return map.get(target);
    }
}
