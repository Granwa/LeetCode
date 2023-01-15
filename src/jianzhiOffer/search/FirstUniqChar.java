package jianzhiOffer.search;

import java.util.*;

public class FirstUniqChar {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstUniqCharUsingLinkedHashMap("leetCode"));
    }
}

class Solution {
    public char firstUniqChar(String s) { // 找出第一个只出现一次的数字
        HashSet<Character> set = new HashSet<>();
        LinkedList<Character> linkedList = new LinkedList<>(); // 记录出现次数变更的链表
        char[] chars = s.toCharArray();

        for (char ch : chars) { // set.add(ch) 若已存在会返回false
            if (!set.add(ch)) linkedList.remove((Character) ch);
            /*
                remove方法：
                remove(int index):移除指定索引的元素
                remove(Object o):移除指定内容的元素
                若传入的是char类型，则char自动转型为int，调用按索引移除，导致IndexOutOfBounds
             */
            else linkedList.add(ch);
        }
        return linkedList.size() != 0 ? linkedList.getFirst() : ' ';
    }

    public char firstUniqCharUsingLinkedHashMap(String s) {
        LinkedHashMap linkedHashMap = new LinkedHashMap<Character, Boolean>();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            linkedHashMap.put(ch, !linkedHashMap.containsKey(ch)); // 不存在放入值true,存在放入值false
        }
//        Set<Character> set = linkedHashMap.keySet();
//        for (Character key : set) {
//            if ((Boolean) linkedHashMap.get(key)) return key;
//        }
        Set<Map.Entry<Character,Boolean>> set = linkedHashMap.entrySet();
        for (Map.Entry<Character, Boolean> entry : set) {
            if (entry.getValue()) return entry.getKey();
        }
        return ' ';
    }
}
