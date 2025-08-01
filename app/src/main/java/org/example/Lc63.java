package org.example;

public class Lc63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int h = obstacleGrid.length;
        if (h <= 0) return 0;
        int w = obstacleGrid[0].length;
        if (w<=0) return 0;

        int dp[][] = new int[h][w];
        dp[0][0] = 1;

        if (obstacleGrid[0][0] == 1) return 0;

        for (int i = 0;i < h;i++){
            for (int j = 0;j<w;j++){
                if (i == 0 && j == 0) continue;;

                if (obstacleGrid[i][j] == 1) continue;

                if (i > 0) dp[i][j] += dp[i-1][j];
                if (j > 0) dp[i][j] += dp[i][j-1];
            }
        }


        return dp[h-1][w-1];
    }

}
