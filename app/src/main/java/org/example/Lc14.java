package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Lc14 {

    public String longestCommonPrefix(String[] strs) {
        LinkedList<Character> resCh = new LinkedList<>();

        //
        if (strs.length <= 0) return "";
        if (strs.length <= 1) return strs[0];

        for (int i = 0;i<Math.min(strs[0].length(),strs[1].length());i++){
            if (strs[0].charAt(i) == strs[1].charAt(i)){
                resCh.add(strs[1].charAt(i));
                continue;
            }
            break;
        }

        for (int i = 2;i<strs.length;i++){
            if (resCh.isEmpty()) return "";

            LinkedList<Character> newResCh = new LinkedList<>();
            for (int j = 0;j<Math.min(strs[i].length(),resCh.size());j++) {
                if (!resCh.get(j).equals(strs[i].charAt(j))){
                    break;
                }

                newResCh.add(resCh.get(j));
            }

            resCh = newResCh;
        }

        char[] realCh = new char[resCh.size()];
        for (int i =0;i<resCh.size();i++){
            realCh[i] = resCh.get(i);
        }
        return new String(realCh);
    }
}
