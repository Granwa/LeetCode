package leetCodeHot100;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

// 输入：nums = [2,7,11,15], target = 9
// 输出：[0,1]
public class TwoSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = {3, 2,4};
        int target = 6;
        Solution solution = new Solution();

        for (int i : solution.twoSum(nums, target)) {
            System.out.println(i);
        }
    }
}

// 本题解决的关键：
// 1.由于需要返回的是索引，因此只能将 索引 存在Value，而 数值 存在Key中
// 2.如果不向上面这样存，那么用map.containsKey(target - map.getKey(i))方法在Value中找到需要的数值时
//      只能由遍历数组的方式来得到数组对应的索引，此时HashMap反而增加了时间复杂度
// 3.通过边存边判断，而不是一次直接存入的方法，可以避免重复问题。

// 最好能说明一下为什么不怕重复。看评论里有很多人提出这个问题，说hash冲突。
// 我在这里解答一下这个问题。
// 1.每次写入时，判断条件 不是当前的key本身存不存在，而是key和 tag 之间的差值存不存在，这一点很重要。
// 2.题目命题说明了一点，假定只有一个解。也就是说重复元素再多都无所谓。
// case 1：如果有3个或者以上的重复元素，代表这个重复元素不可能是解，所以写入map的时候直接覆盖也无所谓；
// case2：如果只有两个重复元素，同样的道理，假如这个重复元素是解，那么必定是两个重复元素的和等于tag。
// 这种情况下，当遇到第二个重复元素时，不会写入map，这个时候直接已经取到解了。
// 所以这种方式，不用考虑hash冲突的问题。

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap map = new HashMap<Integer, Integer> ();
        for(int i = 0; i < nums.length ;i ++){
            if(map.containsKey(target - nums[i])){
                return new int[]{(Integer)map.get(target - nums[i]), i};
            }
            /**先判断是否存在，再将数存入HashMap，可以避免同一个数重复使用，比如6=3+3*/
            map.put(nums[i],i);
        }
        return null;
    }
}

//class Solution {
//    public int[] twoSum(int[] nums, int target) {
//        HashMap<Integer,Integer> map = new HashMap<>();
//        int[] output = new int[2];
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i],i); // 注意put时要区分Key-Value的顺序
//        }
//        Set keySet = map.keySet();
//        for (Object key : keySet) {
//            if (map.containsKey(target - (int)key) && map.get(key) != map.get(target - (int)key)){
//                output[0] = (int)map.get(key);
//                output[1] = (int)map.get(target - (int)key);
//            }
//        }
//        return output;
//    }
//}