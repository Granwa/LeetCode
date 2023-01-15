package HJ.HJ74参数解析;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        boolean noneQuotation = true;
        ArrayList<String> arrayList = new ArrayList<>();
        int len = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '\"') {
                noneQuotation = !noneQuotation;
            } else if (ch == ' ' && noneQuotation) {
                arrayList.add(sb.toString());
                sb.delete(0,sb.length());
                len ++ ;
            } else {
                sb.append(ch);
            }
        }
        // 最后一个
        arrayList.add(sb.toString());
        System.out.println(++len);
        for (String s : arrayList) {
            System.out.println(s);
        }
    }
}