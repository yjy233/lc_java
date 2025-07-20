package org.example;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Lc18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Long>> res = new ArrayList<>();


        Arrays.sort(nums);

        int l = nums.length;
        for (int i=0;i<=l-4;i++){
            if (i>0&&nums[i-1] == nums[i]) continue;

            long iv = (long) nums[i];
            if (4*iv > target) break;

            for (int j=i+1;j<=l-3;j++){
                if (j>i+1 && nums[j-1] == nums[j]) continue;
                long jv = (long) nums[j];
                if (3*jv > target-nums[i]) break;

                int k = j+1;
                int z = l-1;
                while(k<z){
                    if (k>j+1 && nums[k-1] == nums[k]){
                        k++;
                        continue;
                    }

                    if (z < l-1 && nums[z] == nums[z+1]){
                        z--;
                        continue;
                    }

                    long kv = (long) nums[k];
                    long zv = (long) nums[z];
                    if (2*kv > target-nums[i]-nums[j]) break;
                    if (2*zv < target-nums[i]-nums[j]) break;

                    long tmp = iv + jv + zv + kv;
                    if (tmp == target) {
                        List<Long> ln = new ArrayList<>();
                        ln.add((long)nums[i]);
                        ln.add((long)nums[j]);
                        ln.add((long)nums[k]);
                        ln.add((long)nums[z]);
                        res.add(ln);
                    }

                    if (tmp> target) {
                        z--;
                        continue;
                    }

                    k++;
                }
            }
        }

        List<List<Integer>> realRes = new ArrayList<>();

        for (List<Long> r:res){
            List<Integer> rn = new ArrayList<>();
            for (long n:r){
                rn.add((int)n);
            }
            realRes.add(rn);
        }

        return realRes;
    }
}
