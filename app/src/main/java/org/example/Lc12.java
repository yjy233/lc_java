package org.example;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Lc12 {
    private static Map<Integer,String> c2Str = new HashMap<>();
    public static String intToRoman(int num) {
        c2Str.put(1,"I");
        c2Str.put(10,"X");
        c2Str.put(100,"C");
        c2Str.put(1000,"M");
        c2Str.put(5,"V");
        c2Str.put(50,"L");
        c2Str.put(500,"D");

        int level = 1000;
        StringBuilder res = new StringBuilder();
        while(num > 0){
            if (num < level) {
                level /= 10;
                continue;
            }

            if (level == 1000){
                res = new StringBuilder(res + c2Str.get(level));
                num -= 1000;
                continue;
            }

            int w = num/level;
            if (w == 9) {
                res = new StringBuilder(res + c2Str.get(level) + c2Str.get(level * 10));
                num -= 9 * level;
                continue;
            }

            if (w == 4){
                res = new StringBuilder(res + c2Str.get(level) + c2Str.get(level * 5));
                num -= 4 * level;
                continue;
            }

            if (w >= 5) {
                res = new StringBuilder(res + c2Str.get(level * 5));
                num -= 5 * level;
                continue;
                //default:
            }

            res = new StringBuilder(res + c2Str.get(level));
            num -= level;
        }




        return res.toString();
    }

    public static void main(String[] args){
        String a = "1";
        a = a + "2";
        System.out.println(intToRoman(1994));
    }
}
