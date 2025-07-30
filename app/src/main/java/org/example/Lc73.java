package org.example;

public class Lc73 {
    public void setZeroes(int[][] matrix) {
        boolean firstRow = false;
        boolean firstCol = false;

        int h = matrix.length;
        if (h <= 0) return;
        int w = matrix[0].length;
        if (w<=0) return;
        for (int i = 0;i<h;i++){
            for (int j = 0;j<w;j++){

                if (matrix[i][j] == 0) {
                    if (i == 0) firstRow = true;
                    if (j == 0) firstCol = true;

                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }


        for (int i = 1;i<h;i++){
            for (int j = 1;j<w;j++){
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;

            }
        }

        if (firstRow) {
            for (int i = 0;i<w;i++) matrix[0][i] = 0;
        }

        if (firstCol) {
            for (int i = 0;i<h;i++) matrix[i][0] = 0;
        }
    }
}
