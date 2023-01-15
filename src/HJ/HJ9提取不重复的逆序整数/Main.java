package HJ.HJ9提取不重复的逆序整数;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer num = sc.nextInt();
        String s = num.toString();
        ArrayList<Character> list = new ArrayList<>(s.length());
        for (int i = s.length() - 1; i >= 0; i--) {
            boolean existence = list.contains(s.charAt(i));
            if (!existence){
                list.add(s.charAt(i));
            }
        }
        for (Character c : list) {
            System.out.print(c);
        }
    }
}
