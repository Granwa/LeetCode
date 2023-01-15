package jianzhiOffer.twoPointers.reverseWords;

public class ReverseWords {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.reverseWords("a good   example"));
    }
}

class Solution {
    public String reverseWords(String s) {
        if (s == null) return null;
        if (s.length() == 0 || s.length() == 1) return s;
        String[] strings = s.split(" ");
        String[] output = new String[strings.length];
        int i = 0;
        int j = strings.length - 1; // 这里应该是split后的字符串数组

        while (i < strings.length && j >= 0) {
            output[i] = strings[j];
            output[j] = strings[i];

            i++;
            j--;
        }
        String outputString = "";
        for (String string : output) {
            if (!string.equals("")) outputString += string.trim() + " ";
        }
        return outputString.trim();
    }
}

class Solution2 {
    public String reverseWords(String s) {
        /**
         * String可以直接使用索引操作每一个字符，因其底层维护一个char[]数组
         * 本题从末尾处倒序遍历字符串，找出每一个单词的头尾，并用subString()取出子串依次添加在StringBuilder后面
         */
        s.trim();
        int i = s.length() - 1; // 单词头
        int j = i; // 单词尾
        StringBuilder stringBuilder = new StringBuilder();
        while (i >= 0) {
            /**
             * 边界判定？？？
             * 不要用 i!=0，直接用i>=0进行判定，可以涵盖所有可能的指针越界情况
             */
            while (i >= 0 && s.charAt(i) != ' ') i--;
//            if (i == 0) i--;
            // 当i = -1 时仍然会进行s.charAt(i)的判定，导致空指针异常，因此使用短路与进行为0判定，并在if中处理为0情况
            stringBuilder.append(s.substring(i + 1, j + 1) + " "); // 注意subString()返回子串不含右边界[) 左闭右开
//            if (i == -1) break;
            while (i >= 0 && s.charAt(i) == ' ') i--; // 跳过子串中间的空格
            j = i;
        }
        return stringBuilder.toString().trim();
    }
}