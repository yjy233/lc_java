package org.example;

public class Lc72 {
    public int minDistance(String word1, String word2) {

            int l1 = word1.length();
            int l2 = word2.length();

            char[] ch1 = word1.toCharArray();
            char[] ch2 = word2.toCharArray();

            int[][] dp = new int[l1+1][l2+1];


            dp[0][0] = 0;
            for (int i = 1;i<=l1;i++) dp[i][0] = i;
            for (int i = 1;i<=l2;i++) dp[0][i] = i;


            for (int i = 0;i<l1;i++){
                for (int j = 0; j<l2;j++){
                    int tmp = ch1[i] == ch2[j]? dp[i][j]:dp[i][j]+1;

                    tmp = Math.min(tmp,dp[i][j+1]+1);
                    tmp = Math.min(tmp,dp[i+1][j]+1);

                    dp[i+1][j+1] = tmp;
                }
            }

            System.out.println(dp);
            return dp[l1][l2];
        }

}
