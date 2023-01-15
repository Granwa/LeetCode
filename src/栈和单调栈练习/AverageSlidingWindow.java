package 栈和单调栈练习;

import org.junit.Test;

import java.util.LinkedList;

public class AverageSlidingWindow {

    @Test
    public void test(){
        MovingAverage movingAverage = new MovingAverage(3);
        movingAverage.next(1);
        movingAverage.next(10);
        movingAverage.next(3);
        movingAverage.next(5);
    }

    class MovingAverage {
        LinkedList<Integer> queue;
        int size;
        double sum;

        /** Initialize your data structure here. */
        // 滑动窗口的大小为size
        public MovingAverage(int size) {
            queue = new LinkedList();
            this.size = size;
            sum = 0;
        }

        public double next(int val) {
            if(queue.size() == size ){
                sum -= queue.pollFirst();
            }
            sum += val;
            queue.offer(val); // offer()在队列满时不会异常
            return sum / queue.size();
        }
    }

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
}
