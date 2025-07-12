package org.example;

public class Lc5 {
    public static String longestPalindrome(String s) {
        int len = s.length();

        boolean[][] dp = new boolean[len][len];


        String res = s.substring(0,1);
        for (int i =0; i<len;i++){
            dp[i][i] = true;
        }

        for (int i=1;i<len;i++){
            if (s.charAt(i) == s.charAt(i-1)) {
                dp[i-1][i] = true;
                if (res.length() < 2){
                    res = s.substring(i-1,i+1);
                }
            }
        }

        for (int l=3;l<=s.length();l++){
            for (int i = 0;i+l<=s.length();i++){
                if (s.charAt(i) == s.charAt(i+l-1) && dp[i+1][i+l-2]){
                    dp[i][i+l-1] = true;
                    if (l > res.length()) res = s.substring(i,i+l);
                }

            }

        }

        return res;
    }

    public static void main(String[] args){
        System.out.println(longestPalindrome("ccc"));
    }
}
