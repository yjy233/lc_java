package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Lc17 {
    public List<String> letterCombinations(String digits) {
        //List<String> res = new ArrayList<>();
        if (digits.isEmpty()){
            return new ArrayList<>();
        }

        HashMap<Character,char[]> numberC2cs = new HashMap<>();

        //Arrays.asList();
        numberC2cs.put('2',new char[]{'a', 'b', 'c'});
        numberC2cs.put('3',new char[]{'d', 'e', 'f'});
        numberC2cs.put('4',new char[]{'g', 'h', 'i'});
        numberC2cs.put('5',new char[]{'j', 'k', 'l'});
        numberC2cs.put('6',new char[]{'m', 'n', 'o'});
        numberC2cs.put('7',new char[]{'p', 'q', 'r', 's'});
        numberC2cs.put('8',new char[]{'t', 'u', 'v'});
        numberC2cs.put('9',new char[]{'w', 'x', 'y','z'});


        List<List<Character>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for (int i=0;i<digits.length();i++){
            char c = digits.charAt(i);
            char[] cs = numberC2cs.get(c);
            if (cs == null || cs.length == 0) continue;

            List<List<Character>> tmpRes = new ArrayList<>();

            for (List<Character> r: res){
                for (char cc:cs){
                    List<Character> rr = new ArrayList<>(r);
                    rr.add(cc);
                    tmpRes.add(rr);
                }
            }

            res = tmpRes;
        }

        List<String> realR = new ArrayList<>();

        for (List<Character> r:res){
            char[] ch = new char[r.size()];
            for (int i = 0;i<r.size();i++){
                ch[i] = r.get(i);
            }

            realR.add(new String(ch));
        }

        return realR;
    }
}
