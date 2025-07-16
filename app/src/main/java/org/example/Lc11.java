package org.example;

public class Lc11 {
    public int maxArea(int[] height) {
        int res = 0;


        int l = 0;
        int r = height.length-1;

        while(l < r){

            int area = Math.min(height[l],height[r]) * (r-l);
            res = Math.max(res,area);

            int x = height[r] < height[l] ? --r : l++;
        }
        return res;
    }
}
