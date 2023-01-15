package jianzhiOffer.search.missingNumber;

public class MissingNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1};

        System.out.println(solution.missingNumberBinary(nums));
    }
}

class Solution{
    public int missingNumber(int[] nums){
        if (nums[0] != 0 ) return 0;
        int n = nums.length;
        if (nums[n - 1] != n) return n - 1;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] != (nums[i + 1] - 1))
                return nums[i] + 1;
        }return -1;
    }

    /*
    根据题意，数组可以按照以下规则划分为两部分。
    左子数组： nums[i] = inums[i]=i ；
    右子数组： nums[i] \ne inums[i]
    
    缺失的数字等于 “右子数组的首位元素” 对应的索引；因此考虑使用二分法查找 “右子数组的首位元素” 。
     */
    public int missingNumberBinary(int[] nums){
        int leftEnd = 0;
        int rightStart = nums.length - 1;

        while(leftEnd < rightStart){
            int mid = (leftEnd + rightStart) / 2;
            if (nums[mid] == mid){ leftEnd = mid + 1;}
            else { rightStart = mid;}
        }return nums[rightStart] == rightStart ? nums.length : rightStart; // 即[0,1,2]，缺少3，长度为3，即n=4，数的范围0~3
    }
}

