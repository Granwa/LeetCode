package 动态规划练习;

import java.util.*;

public class 最长回文串 {
    public static void main(String[] args) {
        System.out.println(Solution.longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"
        ));
    }

    static class Solution {
        public static int longestPalindrome(String s) {
            // 构成回文串的充要条件：最多可以有一个字母出现次数为奇数，其他字母出现次数为偶数
            HashMap<Character, Integer> map = new HashMap();
            for (int i = 0; i < s.length(); i++) {
                Integer count = map.putIfAbsent(s.charAt(i), 1);
                if (count != null) {
                    map.put(s.charAt(i), count + 1);
                }
            }

            Set set = map.entrySet();
            int sum = 0;
            int hasOdd = 0;
            for (Integer value : map.values()) {
                if ((value % 2) == 1) {
                    hasOdd = 1 ;
                }
                sum += (value/2) * 2;
            }
            return hasOdd + sum;
        }
    }
}
