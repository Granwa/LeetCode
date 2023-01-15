package jianzhiOffer.dynamic_programming.lengthOfLongestSubstring;

/**
 * @author guanhhhua
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("dvdf"));
    }
}

/**
 * 滑动窗口而不是动态规划
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if ("".equals(s)||s == null) return 0;
        int start = 0;
        int end = 0;
        int max = end - start + 1;
        for (int i = 0; i < s.length(); i++) {
            String substring = s.substring(start, end);
            char currentChar = s.charAt(i);
            if (!substring.contains(new Character(currentChar).toString())){
                /**注意是先计算max还是先++,会影响max是否需要+1*/
                max = Math.max(max, end - start + 1);
                end ++;
            }else {
                /**修改start为上一次重复数字出现的地方的后一位*/
                start = s.substring(0,end).lastIndexOf(currentChar) + 1;
                end = Math.max(end, start);
                max = Math.max(max, end - start + 1);
                end ++ ;
            }
        }
        return max;
    }
}