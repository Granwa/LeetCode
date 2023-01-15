package HJ.HJ17坐标移动;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.RegularExpression;

import java.util.Scanner;

/**
 * 正则表达式的使用
 * @author guanhhhua
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.next().split(";");
        // 可以直接使用String类自带的matches方法，即String内置了正则表达式
        RegularExpression reg = new RegularExpression("^[WASD][0-9]+$");
        int[] coordinate = {0,0};
        for (int i = 0; i < split.length; i++) {
            if (reg.matches(split[i])){
                char direction = split[i].charAt(0);
                int length = Integer.parseInt(split[i].substring(1,split[i].length()));
                if (direction == 'W'){
                    coordinate[1] += length;
                }else if (direction == 'A'){
                    coordinate[0] -= length;
                }else if (direction == 'S'){
                    coordinate[1] -= length;
                }else if (direction == 'D'){
                    coordinate[0] += length;
                }
            }
        }
        System.out.println(coordinate[0] + "," +coordinate[1]);
    }
}
