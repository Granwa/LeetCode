package leetCodeHot100;

import java.util.HashMap;

public class 多数元素 {
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        new Solution169().majorityElement(nums);
    }
}

class Solution169 {
    public int majorityElement(int[] nums) {
        // 简单版：hashmap
        HashMap map = new HashMap();
        for(int i = 0; i < nums.length; i ++) {
            if (!map.containsKey(nums[i])) {map.put(nums[i], 0); }
            else {map.put(nums[i],(int)map.get(nums[i]) + 1);}
        }
        for(Object key : map.keySet()){
            if ((int)map.get(key) > nums.length/2) return (int)key;
        }
        return -1;
    }
}