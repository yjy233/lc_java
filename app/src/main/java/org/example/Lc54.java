package org.example;

import java.util.ArrayList;
import java.util.List;

public class Lc54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> nums = new ArrayList<>();

        int d = 0;
        int h = matrix.length;
        if (h<=0) return nums;
        int w = matrix[0].length;
        int n = h*w;

        int i = 0;
        int j = 0;
        while(n>0) {
            System.out.println(i+" "+j+" "+n);
            if (matrix[i][j] != -1234) {
                nums.add(matrix[i][j]);
                matrix[i][j] = -1234;
                n--;
            }

            if (d%4 == 0) {
                if (j+1<w && matrix[i][j+1] != -1234){
                    j++;
                    continue;
                }else{
                    d++;
                    continue;
                }
            }

            if (d%4 ==1) {
                if (i+1<h && matrix[i+1][j] != -1234){
                    i++;
                    continue;
                } else{
                    d++;
                    continue;
                }
            }
            if (d%4 ==2) {
                if (j-1 >= 0 && matrix[i][j-1] != -1234){
                    j--;
                    continue;
                } else{
                    d++;
                    continue;
                }
            }

            if (i-1 >= 0 &&matrix[i-1][j] != -1234 ){
                i--;
                continue;
            }
            d++;
        }
        return nums;
    }
}
