package org.example;

import java.util.Stack;

public class Lc20 {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();

        Stack<Character> st = new Stack<>();
        for (char c: chars){
            switch (c){
                case '(','[','{':
                    st.push(c);
                    break;
                case ')':
                    if (!st.isEmpty() && st.peek() == '('){
                        st.pop();
                        break;
                    }
                    return false;
                case ']':
                    if (!st.isEmpty() && st.peek() == '['){
                        st.pop();
                        break;
                    }
                    return false;
                case '}':
                if (!st.isEmpty() && st.peek() == '{'){
                    st.pop();
                    break;
                }
                return false;
            }

        }

        return st.isEmpty();
    }
}
