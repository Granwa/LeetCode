package HJ.HJ13句子逆序;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 将每一个单词单独装进List
 *
 * @author guanhhhua
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        while (sc.hasNext()) {
            list.add(sc.next());
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
    }
}

/**
 * 将输入缓冲区的数据全部读出然后用split分割
 */
class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputStr = sc.nextLine();

        String[] split = inputStr.split(" ");
        for (int i = split.length - 1; i >= 0; i--) {
            System.out.println(split[i] + " ");
        }
    }
}

/**
 * 使用StringBuilder
 */