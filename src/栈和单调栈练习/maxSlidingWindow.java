package 栈和单调栈练习;

import org.junit.Test;

import java.util.LinkedList;

// 使用单调队列解决滑动窗口中每次滑动的最大值
public class maxSlidingWindow {
    @Test
    public void test() {
        Solution solution = new Solution();
        int[] ints = solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int anInt : ints) {
            System.out.print(anInt+" ");
        }
    }

    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            MonotonicQueue MonotonicQueue = new MonotonicQueue();
            int[] res = new int[nums.length - k + 1];
            // 滑窗形成前
            for (int i = 0; i < k; i++) {
                MonotonicQueue.push(nums[i]);
            }
            // 滑窗刚好形成
            res[0] = MonotonicQueue.peekFirst();
            // i是滑动窗口的终点，i-k是滑动窗口起点的前一位置元素
            for (int i = k; i < nums.length; i++) {
                // 左移，判断队头是否出队
                if (nums[i - k] == MonotonicQueue.peekFirst()){
                    MonotonicQueue.pollFirst();
                }
                // 右移，新元素入队
                MonotonicQueue.push(nums[i]);
                res[i - k + 1] = MonotonicQueue.peekFirst();
            }
            return res;
        }
    }

    class MonotonicQueue {
        // 以双向链表实现队列
        LinkedList<Integer> queue = new LinkedList<>();

        public int peekFirst(){
            return queue.peekFirst();
        }

        public int pollFirst() {
            return queue.pollFirst();
        }

        // 弹出所有比入队元素小的前面的元素，这样能保证队列始终非严格单调递减
        public void push(int input) {
            while (!queue.isEmpty() && queue.peekLast() < input) {
                queue.pollLast();
            }
            queue.addLast(input);
        }
    }
}
