package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Lc16 {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) return -1;

        Arrays.sort(nums);

        int res = nums[0] + nums[1] + nums[2];
        int l = nums.length;
        for (int i = 0;i<l-2;i++){
            if (i > 0 && nums[i-1] == nums[i]) continue;

            int j = i+1;
            int k = nums.length-1;
            while(j < k) {
                if (j > i+1 && nums[j] == nums[j-1]) {
                    j++;
                    continue;
                }

                if (k != l-1 && nums[k] == nums[k+1]){
                    k--;
                    continue;
                }

                int tmp = nums[i] + nums[j] + nums[k];

                if (tmp == target) return target;
                if (Math.abs(tmp - target) < Math.abs(res -target)){
                    res = tmp;
                }

                if (tmp < target) {
                    j++;
                    continue;
                }

                k--;
            }
        }

        return res;
    }
}
