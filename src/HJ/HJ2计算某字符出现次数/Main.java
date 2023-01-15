package HJ.HJ2计算某字符出现次数;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char read = (char) br.read();
        int diff = 'a' - 'A';
        read = ('A' <= read)&&(read <= 'Z') ? (char) (read + diff) : read;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            c = ('A' <= c)&&(c <= 'Z') ? (char) (c + diff) : c;
            if (c == read){
                count ++ ;
            }
        }
        System.out.println(count);
    }
}