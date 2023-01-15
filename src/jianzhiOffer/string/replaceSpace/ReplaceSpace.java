package jianzhiOffer.string.replaceSpace;

public class ReplaceSpace {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "    ";
        System.out.println(solution.replaceSpace(s));

//        StringBuilder的delete()方法测试
//        StringBuilder stringBuilder = new StringBuilder("1234");
//        System.out.println(stringBuilder.delete(0,2));
//        System.out.println(stringBuilder);
    }
}

class Solution{
    public String replaceSpace(String s){
//        String[] stringArray = s.split(" ");
//        String output = "";
//        for (int i = 0; i < stringArray.length; i++) {
//            output += stringArray[i] + "%20";
//        }
//        return output;
        // split只能用于无连续空格的情况；
        StringBuilder sb = new StringBuilder(s);
        int index = sb.indexOf(" ");
        while(index != -1){
            sb.replace(index,index + 1,"%20");
            // replace[start,end),左闭右开
            // 一开一闭就可以做到用replace添加而不替换
            index = sb.indexOf(" ");
        }
        return new String(sb);
    }
}
