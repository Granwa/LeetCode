package HJ.HJ27查找兄弟单词;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] split = input.split(" ");
        // 本题目中的要求不需要去重……
        ArrayList<String> brothers = new ArrayList<>();
        int count = Integer.parseInt(split[0]);
        String original = split[count + 1];
        for (int i = 1; i < count + 1; i++) {
            if (isBrother(split[i], original)) {
                brothers.add(split[i]);
            }
        }
        System.out.println(brothers.size());
        brothers.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        if (brothers.size() > 0){
            System.out.println(brothers.get(0));
        }
    }

    // 字符串不和原字符串相同，且每隔字母数量相等，则是兄弟单词
    // 换言之，将两个字符串中的字母排序，若排序后的字符串相同，则可以说明其中的每个字母的数量都相同
    private static boolean isBrother(String s1, String s2) {
        if (s1.equals(s2)) {
            return false;
        }
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        // 即不是只有将数组转换成List后才能排序，使用Arrays可以直接对数组排序
        Arrays.sort(chs1);
        Arrays.sort(chs2);
        // 数组作为引用数据类型，还是要用equals来判断相等
        // 但是不是用chs1.equals()。而是用Arrays工具类的api
        if (!Arrays.equals(chs1,chs2)) {
            return false;
        }
        return true;
    }
}
