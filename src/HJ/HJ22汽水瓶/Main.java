package HJ.HJ22汽水瓶;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int bottles = scanner.nextInt();
            if (bottles == 0) break;
            int drink = 0;
            while (true) {
                int drinkThisTime = bottles / 3;
                drink += drinkThisTime;
                bottles = drinkThisTime + bottles % 3;
                if (bottles == 2) {
                    drink ++;
                    break;
                }else if (bottles < 2){
                    break;
                }
            }
            System.out.println(drink);
        }
    }
}