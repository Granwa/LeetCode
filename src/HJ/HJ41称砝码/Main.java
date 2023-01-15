package HJ.HJ41称砝码;

import java.util.Scanner;
import java.util.HashSet;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int categories = sc.nextInt();
        int[] weight = new int[categories];
        int[] count = new int[categories];
        HashSet<Integer> nonDuplicateSet = new HashSet();
        ArrayList<Integer> tempList = new ArrayList();
        nonDuplicateSet.add(0);
        for(int i = 0;i < categories;i ++){
            weight[i] = sc.nextInt();
        }
        for(int i = 0;i < categories;i ++){
            count[i] = sc.nextInt();
        }

        for(int i = 0;i < categories; i ++){
            for(int j = 0; j< count[i]; j++){
                for(Integer k : nonDuplicateSet){
                    int totalWeight = weight[i] * (j + 1) + k;
                    if (!nonDuplicateSet.contains(totalWeight)){
                        tempList.add(totalWeight);
                    }
                }
            }
            // 处理完一个砝码的可能重量后，才能将其全部存入set中
            for(Integer temp : tempList){
                nonDuplicateSet.add(temp);
            }
            tempList.clear();
        }
        System.out.println(nonDuplicateSet.size());
    }
}