package HJ.HJ20密码验证合格;

import org.junit.Test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.next();
            int length = s.length();
            if (length < 8) {
                System.out.println("NG");
                continue    ;
            }
            boolean upper = false;
            boolean lower = false;
            boolean num = false;
            boolean others = false;
            int count = 0;
            for (int i = 0; i < length; i++) {
                if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                    num = true;
                } else if ('a' <= s.charAt(i) && s.charAt(i) <= 'z') {
                    lower = true;
                } else if ('A' <= s.charAt(i) && s.charAt(i) <= 'Z') {
                    upper = true;
                } else {
                    others = true;
                }
            }
            if (upper) count++;
            if (lower) count++;
            if (num) count++;
            if (others) count++;
            if (count < 3) {
                System.out.println("NG");
                continue;
        }
        if (Main.hasRepeatSubString(s)) {
            System.out.println("NG");
            continue;
        }
        System.out.println("OK");
    }
}

    /**
     * O(n^2)时间复杂度，判断重复子串
     * 要求仅判断长度大于2(不含2)的子串
     * @param str
     * @return
     */
    public static boolean hasRepeatSubString(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String sub = str.substring(i, j);
                boolean containsFront = sub.length() <= 2 ? false : str.substring(0, i).contains(sub);
                boolean containsBack = sub.length() <= 2 ? false : str.substring(j, str.length()).contains(sub);
                if (containsBack || containsFront) {
//                    System.out.println("重复");
                    return true;
                }
            }
        }
//        System.out.println("不重复");
        return false;
    }
}