package org.example;

import java.util.ArrayList;
import java.util.List;

public class Lc6 {
    public static String convert(String s, int numRows) {
        if (numRows <= 1) return s;

        char[] res = new char[s.length()];


        int rowNum = numRows*2-2;

        List<List<Character>> dp = new ArrayList<>();

        for (int i = 0;i<numRows;i++) dp.add(new ArrayList<>());

        for (int i = 0;i<s.length();i++){
            int nr = i%rowNum;
            //int rr = i/rowNum;
            if (nr == 0 || nr == numRows-1){
                dp.get(nr).add(s.charAt(i));
                continue;
            }

            if (nr < numRows) {
                dp.get(nr).add(s.charAt(i));
                continue;
            }

            int ind = rowNum - nr ;
            dp.get(ind).add(s.charAt(i));
        }


        int i = 0;
        char[] resCh = new char[s.length()];
        for(List<Character> row:dp){
            for (Character c:row){
                resCh[i] = c;
                i++;
                System.out.print(c + " ");
            }
            System.out.print("\n");
        }

        return new String(resCh);
    }

    public static void main(String[] args){
        String s = "PAYPALISHIRING";
        System.out.println(convert(s,3));
    }
}

/*
P   A   H   N
A P L S I I G
Y   I   R
* */