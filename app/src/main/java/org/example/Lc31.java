package org.example;

import java.util.Arrays;

public class Lc31 {
    boolean isAsc(int[] nums){
        for (int i = 1;i<nums.length;i++){
            if (nums[i] < nums[i-1]) return false;
        }

        return true;
    }

    public void nextPermutation(int[] nums) {
        // 1 4 3 2
        if (nums.length <= 1) return ;

        int potInd = -1;
        for (int i = nums.length-1;i>0;i--){
            if (nums[i-1] < nums[i]) {
                potInd = i-1;
                break;
            }
        }

        if (potInd == -1) {
            Arrays.sort(nums);
            return;
        };
        int judgeInd = 0;
        int[] sortNums = new int[nums.length-potInd-1];
        for (int k = 0;k<sortNums.length;k++) {
            sortNums[k] = nums[k+potInd+1];
        }

        int exInd = 0;
        for (int i = 0;i<sortNums.length;i++) {
            if (sortNums[i] > nums[potInd] && sortNums[exInd] > sortNums[i]){
                exInd = i;
            }
        }

        int tmp = nums[potInd];
        nums[potInd] = sortNums[exInd];
        sortNums[exInd] = tmp;


        Arrays.sort(sortNums);
        for (int i = 0;i<sortNums.length;i++){
            nums[i+1+potInd] = sortNums[i];
        }

    }
}
