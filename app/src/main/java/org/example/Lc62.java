package org.example;

public class Lc62 {
    public int uniquePaths(int m, int n) {
        if (m==0 || n == 0) return 0;
        int[][] dp = new int[m][n];

        for (int i = 0;i<m;i++){
            for (int j = 0;j<n;j++) dp[i][j] = 0;
        }

        dp[0][0] = 1;
        for (int i = 0;i<m;i++){
            for (int j = 0;j<n;j++){
                if (i > 0) {
                    dp[i][j] += dp[i-1][j];
                    //continue;;
                }


                if (j > 0) {
                    dp[i][j] += dp[i][j-1];
                }

            }
        }

        return dp[m-1][n-1];
    }
}
