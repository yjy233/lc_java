package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int num:nums) System.out.println(num);

        for (int i=0;i<nums.length-2;i++){
            if (nums[i] > 0) break;
            if (i>0 && nums[i] == nums[i-1]) continue;

            int j = i+1;
            int k = nums.length-1;

            while(j < k){
                if (j != i+1 && nums[j] == nums[j-1]) {
                    j++;
                    continue;
                }

                if (k != nums.length-1 && nums[k] == nums[k+1]){
                    k--;
                    continue;
                }

                int sum = nums[i] + nums[j];
                if (sum > 0){
                    break;
                }
                sum += nums[k];
                if (sum == 0){
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                }
                if (sum > 0){
                    k--;
                    continue;
                }
                j++;
            }

        }

        return res;
    }

    public static void main(String[] args){
        int[] nums = new int[]{3,1,2};
        threeSum(nums);
    }
}
