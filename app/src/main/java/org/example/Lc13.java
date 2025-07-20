package org.example;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class Lc13 {
    public int romanToInt(String s) {
        HashMap<Character,Integer> c2Int = new HashMap<Character,Integer>();

        //I             1
        //V             5
        //X             10
        //L             50
        //C             100
        //D             500
        //M             1000
        c2Int.put('I',1);
        c2Int.put('V',5);
        c2Int.put('X',10);
        c2Int.put('L',50);
        c2Int.put('C',100);
        c2Int.put('D',500);
        c2Int.put('M',1000);

        char[] ch = s.toCharArray();
        int res = 0;
        for (int i=0;i<ch.length;i++){
            char c = ch[i];
            if (i == ch.length-1){
                res += c2Int.get(c);
                continue;
            }

            char nc = ch[i+1];
            if (c2Int.get(c) >= c2Int.get(nc)){
                res += c2Int.get(c);
                continue;
            }

            res -= c2Int.get(c);
        }

        return res;
    }
}
