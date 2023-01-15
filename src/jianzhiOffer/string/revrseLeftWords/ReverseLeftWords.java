package jianzhiOffer.string.revrseLeftWords;

public class ReverseLeftWords {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseLeftWords("abcdefg",2));
    }
}

class Solution {
    public String reverseLeftWords(String s, int n) {
        String right = s.substring(0,n); // 更改后放到右边的
        String left = s.substring(n,s.length());
        return left + right;
    }
}
