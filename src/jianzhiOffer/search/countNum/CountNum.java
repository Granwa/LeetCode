package jianzhiOffer.search.countNum;

import org.junit.Test;

import java.util.HashMap;
import java.util.Random;


public class CountNum {
    public static void main(String[] args) {
        int[] nums = {6,6,6,6,6,6,6,6};
        int target = 6;
        SolutionBinarySearch solution = new SolutionBinarySearch();
        System.out.println(solution.search(nums,target));
    }

    @Test
    public void testComplexity(){
        Random random = new Random(); // 注意：二分查找只适用于有序数组
        int[] nums = new int[999999];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = 1; // 这样每个数就存得有两个
        }
        int target = 1;

        SolutionMap solutionMap = new SolutionMap();
        long startTime = System.nanoTime();
        System.out.println(solutionMap.search(nums, target));
        long endTime = System.nanoTime();
        System.out.println("创建map对象并put的时间为：" + (endTime - startTime));

        SolutionBinarySearch solutionBinary = new SolutionBinarySearch();
        long startTime2 = System.nanoTime();
        System.out.println(solutionBinary.search(nums, target));
        long endTime2 = System.nanoTime();
        System.out.println("二分查找的时间为：" + (endTime2 - startTime2));


    }
}

class SolutionBinarySearch {
    public int search(int[] nums, int target) {
        // 本题给的是有序数组，可以考虑通过BinarySearch查找，可以有效缩小时间复杂度
        // 由于要统计次数，可以二分查找后从查找到的索引位置，
        // 向左右继续依次查找

        //不存在
        int indexOriginal = BinarySearch(nums,target);
        if ( indexOriginal== -1){return 0;}
        //存在
        int index = indexOriginal;
        int num = target;
        int count = 1; // 若等于0就已经在前一步if返回

        // 如果写 -- index ，若indexOriginal左边所有的数字都 == target时，则当index == 0时仍会 --；
        // 先做越界判定，再访问数组，可避免数组越界// && 短路与应该可以停止后面判定
        // 注意由于访问数组时使用 -- i,因此越界判定要用(index - 1)!= -1,否则 -- 之后仍然越界

        while((index - 1)!= -1 &&(num = nums[ -- index]) == target) {count ++;}
        index = indexOriginal; // 重置索引为binarySearch的返回值
        while((index + 1)!= nums.length &&(num = nums[ ++ index]) == target) {count ++;}

        return count;
    }

    public static int BinarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid= (right + left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target){
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }
}

class SolutionMap {
    public int search(int[] nums, int target) { // 关于HashMap的时间复杂度再去学习一个
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(target,0);
        for (int num : nums) {
            if (num == target){
                map.put(target,map.get(target)  + 1); // 难道是put的过程中耗费了比较多的时间？？？
            }
        }return map.get(target);
    }
}