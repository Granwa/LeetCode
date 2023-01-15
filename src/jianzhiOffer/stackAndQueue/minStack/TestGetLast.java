package jianzhiOffer.stackAndQueue.minStack;

import java.util.LinkedList;

public class TestGetLast {
    public static void main(String[] args) {
        String s = new String("a");

        LinkedList<String> stringList1 = new LinkedList<>();
        LinkedList<String> stringList2 = new LinkedList<>();
        stringList1.add(s);
        stringList2.add(s);
        System.out.println(stringList1.getLast() == stringList2.getLast());


        int i = 1000;

        LinkedList<Integer> integerList1 = new LinkedList<>();
        LinkedList<Integer> integerList2 = new LinkedList<>();
        integerList1.add(i);
        integerList2.add(i);
        System.out.println(integerList1.getLast() == integerList2.getLast());
    }
}
