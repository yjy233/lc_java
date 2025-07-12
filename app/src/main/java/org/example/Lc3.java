package org.example;

import java.util.HashMap;
import java.util.Map;

public class Lc3 {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();


        int res = 0;

        int st = 0;
        int ed = 0;

        Map<Character,Integer> memory = new HashMap<>();
        for (int i = 0;i<s.length();i++){
            memory.put(s.charAt(i),0);
        }

        System.out.println("----");
        memory.put(s.charAt(0),1);
        try {
            while (st < s.length()) {
                if (ed - st + 1 > res) res = ed - st + 1;
                if (ed + 1 >= s.length() || memory.get(s.charAt(ed + 1)) > 0) {
                    char c = s.charAt(st);
                    memory.put(c, memory.get(c) - 1);
                    st++;
                    continue;
                }

                //ed++;
                char c = s.charAt(ed + 1);
                ed++;
                memory.put(c, memory.get(c) + 1);
            }
        } catch (Exception e){
            System.out.println(e);
        }


        return res;
    }

    public static void main(String[] args){
        String example = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(example));

    }
}
