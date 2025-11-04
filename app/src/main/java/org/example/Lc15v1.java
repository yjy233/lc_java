package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc15v1 {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        int l = nums.length;

        Arrays.sort(nums);
        for (int num:nums) System.out.print(num);
        System.out.println("");
        for (int i=0;i<l-2;i++) {
            if (i > 0 && nums[i-1] == nums[i]) {
                continue;
            }

            if (nums[i] > 0) break;

            int left = i+1;
            int right = l-1;

            while(right > left) {
                if (left > i + 1 && nums[left-1] == nums[left]) {
                    left++;
                    continue;
                }
                if (right < l-1 && nums[right] == nums[right+1]) {
                    right--;
                    continue;
                }

                int s = nums[i] + nums[left] + nums[right];
                if (s == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                }
                if (s > 0) {
                    right--;
                    continue;
                }
                left++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        Lc15v1.threeSum(nums);
    }
}
