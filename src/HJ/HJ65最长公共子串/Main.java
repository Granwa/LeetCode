package HJ.HJ65最长公共子串;

import java.util.Scanner;

/**
 * 有没有时间复杂度低于O(n^2)的做法？
 */
// 如果有多个最长公共子串，则输出在“较短的字符串中”第一个出现的
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        String strShorter = str1.length() < str2.length() ? str1 : str2;
        String strLonger = str1.length() > str2.length() ? str1 : str2;
        int maxLen = 0;
        String maxString = null;
        for (int i = 0; i < strShorter.length(); i++) {
            for (int j = i + 1; j < strShorter.length() + 1; j++) {
                String substring = strShorter.substring(i, j);
                if (strLonger.contains(substring) && (substring.length() > maxLen)) {
                    maxString = substring;
                    maxLen = maxString.length();
                }
            }
        }
        if (maxString != null) {
            System.out.println(maxString);
        }
    }
}