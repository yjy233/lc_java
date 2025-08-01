package org.example;

import java.util.ArrayList;
import java.util.List;

public class Lc71 {

    public static String simplifyPath(String path) {
        String[] terms = path.split("/");
        List<String> newTerm = new ArrayList<>();

        for (String term: terms) {

            if (term.isEmpty()){
                continue;
            }

            if (term.equals(".")) continue;
            if (term.equals("..")){
                if (newTerm.size() >= 1){
                    newTerm.removeLast();

                }
                continue;
            }

            newTerm.add(term);

        }



        return  "/" + String.join("/",newTerm);
    }

    public static void main(String[] args){

        String  s =simplifyPath("/a/./b/../../c/");
        System.out.println("wfwefwe");
        System.out.println(s);
    }
}
