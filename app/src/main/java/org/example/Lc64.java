package org.example;

public class Lc64 {
    public int minPathSum(int[][] grid) {
        int h = grid.length;
        if (h < 0) return 0;
        int w = grid[0].length;
        for (int i =0;i<grid.length;i++) {
            for (int j = 0;j<grid[0].length;j++){
                if (i == 0 && j==0) continue;
                if (i<=0) {
                    grid[i][j] += grid[i][j-1];
                    continue;
                }
                if (j<=0) {
                    grid[i][j] += grid[i-1][j];
                    continue;
                }
                grid[i][j] += Math.min(grid[i-1][j],grid[i][j-1]);
            }

        }

        return grid[h-1][w-1];
    }
}
