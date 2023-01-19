package leetCodeHot100;

public class 汉明距离 {
}

class Solution461 {
    public int hammingDistance(int x, int y) {
        // 位运算，异或：相同的位为0，不同的位为1
        int s = x ^ y;
        // 依次判断异或结果的各个位是否为1
        int res = 0;
        while(s != 0){
            // 对2取余，判断末位是否为1
            if (s % 2 == 1) res ++;
            // 除2，等同于右移一位
            s = s/2;
        }
        return res;
    }
}