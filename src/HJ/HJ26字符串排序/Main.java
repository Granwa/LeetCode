package HJ.HJ26字符串排序;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        ArrayList<Character> letters = new ArrayList();
        ArrayList nonLetterChIndex = new ArrayList();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!(ch >= 'a' && ch <= 'z') && !(ch >= 'A' && ch <= 'Z')) {
                nonLetterChIndex.add(i);
            } else {
                letters.add(ch);
            }
        }
        letters.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                // 可以直接用Character类的静态方法toLowerCase，注意：类的对象是可以调用静态方法的
                return Character.toLowerCase(o1) - Character.toLowerCase(o2);
//                char c1 = o1.charValue();
//                char c2 = o2.charValue();
//                if (c1 >= 'A' && c1 <= 'Z') {
//                    c1 = (char) (c1 - 'A' + 'a');
//                }
//                if (c2 >= 'A' && c2 <= 'Z') {
//                    c2 = (char) (c2 - 'A' + 'a');
//                }
//                return c1 - c2;
            }
        });
        StringBuilder sb = new StringBuilder();
        int j = 0;
        for (int i = 0; i < str.length(); i++) {
            if (nonLetterChIndex.contains(i)) {
                sb.append(str.charAt(i));
            } else {
                sb.append(letters.get(j));
                j++;
            }
        }
        System.out.println(sb.toString());
    }
}
