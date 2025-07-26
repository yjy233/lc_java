package org.example;

public class Lc10 {
    public boolean isMatch(String s, String p) {
        int h = s.length();
        int w = p.length();
        char[] sCh = s.toCharArray();
        char[] pCh = p.toCharArray();

        int[][] dp = new int[h+1][w+1];

        dp[0][0] = 1;

        for (int i = 0;i<h;i++) {
            for (int j = 0;j<w;j++) {
                if (sCh[i] == pCh[j] || pCh[j] == '.') {
                    dp[i+1][j+1] = dp[i][j];
                    continue;
                }

                if (j<=0 || pCh[j] != '*') continue;
                int c = pCh[j-1];
                System.out.println("xxxxxxx " + dp[i][j-1] + " " + sCh[i] + " " + pCh[j] );
                System.out.println((char) c);
                System.out.println(dp[1][1]);
                //if (dp[i][j-1] == 1 || (j==1 && i==0)) dp[i][j+1] = 1;
                // 这一句非常重要，就是i本轮匹配一定要注意
                //if (dp[i+1][j-1] == 1) dp[i+1][j+1] = 1;
                // 这里很重要就是全部不需要的匹配以下
                if (j == 1) dp[0][2] = 1;
                for (int k = 0;k<=h;k++){
                    if (dp[k][j-1] == 1) dp[k][j+1] = 1;
                }



                if (c == '.'){
                    if (j == 1 || dp[i][j-1] == 1) {
                        for (int k = 0;k<=h;k++){
                            dp[k][j+1] = 1;
                        }
                    }

                    continue;
                }

                if (dp[i][j-1] != 1) continue;

                for (int k = i;k<h;k++){
                    if (sCh[k] == c) {
                        dp[k+1][j+1] = 1;
                        continue;
                    }

                    break;
                }



            }
        }

        for (int i = 0; i <= h;i++){
            for (int j = 0;j<=w;j++){
                System.out.print(" " + dp[i][j]);
            }
            System.out.println("");
        }
        return dp[h][w] == 1;
    }
}
