package jianzhiOffer.search.minArrayRotated;

public class MinArrayRotated {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] numbers = {1,3,3};
        System.out.println(solution.minArray(numbers));
    }
}

class Solution {
    public int minArray(int[] numbers) {
        int mid = 0;
        int left = 0;
        int right = numbers.length - 1;
        while(left <= right){
            mid = (left + right) / 2;
            if (numbers[mid] > numbers[right]) left = mid + 1;
            else if (numbers[mid] < numbers[right]) right = mid;
//            else if (numbers[mid] == numbers[right]) right --;
            else if (numbers[mid] == numbers[right]) {
                // 二分查找中遇到nums[mid] == nums[right]的情况，改为从前往后遍历
                int min = numbers[right];
                for (int i = right; i >= left ; i --) {
                    if (numbers[i] < min) min = numbers[i];
                }
                return min;
            }
        }
        return numbers[mid];
    }
}
