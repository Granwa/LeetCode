package HJ.HJ93数组分组;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        ArrayList<Integer> list3 = new ArrayList<>();
        ArrayList<Integer> list5 = new ArrayList<>();
        for (int i = 0; i < count; i ++){
            int num = sc.nextInt();
            if (num % 3 == 0){
                list3.add(num);
            }
            if (num % 5 == 0){
                list5.add(num);
            }



        }
    }
}