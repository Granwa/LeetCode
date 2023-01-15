package 栈和单调栈练习;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterNum {
    public static void main(String[] args) {
        nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums1.length];
        // 从后往前入栈，因为要找的是下一个更大元素
        for (int i = nums2.length - 1; i >= 0; i--) {
            // 弹出不比当前元素大的元素
            while (!stack.empty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            // 剩下就是比当前元素大的 //
            int value = stack.empty() ? -1 : stack.peek();
            map.put(nums2[i],value);
            stack.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
