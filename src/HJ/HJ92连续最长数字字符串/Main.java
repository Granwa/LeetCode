package HJ.HJ92连续最长数字字符串;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MonotonicQueue monotonicQueue = new MonotonicQueue();

        while (sc.hasNext()) {
            String sub = "";
            String input = sc.nextLine();
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (ch >= '0' && ch <= '9') {
                    sub += ch;
                } else {
                    if (sub.length() > 0) {
                        monotonicQueue.pushLast(sub);
                        sub = "";
                    }
                }
            }
            // 处理最后一个sub
            monotonicQueue.pushLast(sub);
            int length = monotonicQueue.peekLastLen();
            while (monotonicQueue.size() != 0) {
                System.out.print(monotonicQueue.pollLast());
            }
            System.out.println("," + length);
            monotonicQueue.clear();
        }
    }
}

class MonotonicQueue {
    private LinkedList<String> queue = new LinkedList<>();

    // 队列尾进头出
    public int peekLastLen() {
        return queue.peekLast().length();
    }

    public void pushLast(String input) {
        if (queue.size() == 0 || input.length() >= this.peekLastLen()) {
            while (queue.size() != 0 && queue.peekLast().length() < input.length()) {
                queue.pollLast();
            }
            queue.push(input);
        }
    }

    public int size() {
        return queue.size();
    }

    public String pollLast() {
        return queue.pollLast();
    }

    public void clear() {
        queue.clear();
    }
}