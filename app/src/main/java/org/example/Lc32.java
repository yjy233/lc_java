package org.example;

import java.util.Map;
import java.util.Stack;

public class Lc32 {
    public int longestValidParentheses(String s) {

        int l = s.length();
        int[] dp = new int[l];

        Stack<Integer> st = new Stack<>();
        for (int i = 0;i<s.length();i++) {
            if (s.charAt(i) == '('){
                st.push(i);
                continue;
            }

            if (st.isEmpty()) continue;
            int stInd = st.pop();
            int len = i - stInd + 1;
            dp[i] = len;
            if (stInd>0) dp[i] += dp[stInd-1];
        }

        int res = 0;
        for (int r:dp) res = Math.max(r,res);
        return res;
    }
}
