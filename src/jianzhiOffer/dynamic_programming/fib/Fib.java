package jianzhiOffer.dynamic_programming.fib;

/**
 * @author guanhhhua
 */
public class Fib {
    public static void main(String[] args) {
        System.out.println(new Solution().fib(48));
    }

}

class Solution {
    public int fib(int n) {
        if (n == 1) return n;
        int a = 1;
        int b = 1;
        int c = a;
        while (n > 2){
            c = a + b;
            if (c >= 1000000007){
                c -= 1000000007;
            }
            a = b;
            b = c;
            n --;
        }
        return c;
    }
}