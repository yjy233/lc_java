package org.example;

public class Lc53 {
    public int maxSubArray(int[] nums) {
        int res = -250000;
        for (int i = 1;i<nums.length;i++){
            if (nums[i-1] > 0) {
                nums[i] += nums[i-1];
            }
        }

        for (int n: nums){
            res = Math.max(res,n);
        }
        return res;
    }
}
