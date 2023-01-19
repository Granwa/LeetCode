package leetCodeHot100;

import java.util.ArrayList;
import java.util.List;

public class 找到所有数组中没有出现的数字 {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(new Solution448().findDisappearedNumbers(nums));
    }
}

class Solution448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
//        // 1. hashmap
//        int[] map = new int[nums.length];
//        List res = new ArrayList();
//        for(int i = 0; i < nums.length; i ++){
//            map[nums[i] - 1] = nums[i];
//        }
//        for(int i = 0; i < nums.length; i ++){
//            if(map[i] == 0) res.add( i + 1);
//        }
//
//        return res;

        // 2. 不使用额外空间且时间复杂度为O(n)
        // 遍历两遍，总耗时为2n，但时间复杂度为O(n)
        List res = new ArrayList();

        for(int i = 0; i < nums.length; i++){
            // 在原数组中原地修改，既要记录下该数字出现过，又不能完全改变了数组存有的原信息
            // 可选方法：比如出现过的就变为负数，或出现过的就+n，让这个位置的数大于n
            nums[Math.abs(nums[i]) - 1] = - Math.abs(nums[Math.abs(nums[i]) - 1]);
        }
        for(int i = 0; i < nums.length; i ++){
            if (nums[i] > 0) res.add(i + 1);
        }
        return res;
    }
}