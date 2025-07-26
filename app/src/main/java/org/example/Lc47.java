package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        boolean[] use = new boolean[nums.length];
        for (int i = 0;i<nums.length;i++) use[i] = false;

        helper(res,nums,use,new ArrayList<>());
        return res;
    }

    private void helper(List<List<Integer>> res, int[] nums,boolean[] use,List<Integer> tmp){
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0;i<nums.length;i++){
            if (use[i]) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i-1]) {
                int nCnt = 0;
                int uCnt = 0;
                for (int j = tmp.size()-1;j>=0;j--) {
                    if (tmp.get(j) == nums[i]){
                        nCnt++;
                        continue;
                    }
                    break;
                }

                for (int j = i-1;j>=0;j--){
                    if (nums[j] == nums[i]){
                        uCnt++;
                        continue;
                    }
                    break;
                }

                if (nCnt != uCnt && !use[i-1]) continue;
            }

            tmp.add(nums[i]);
            use[i] = true;

            helper(res,nums,use,tmp);
            use[i] = false;
            tmp.removeLast();
        }
    }


}
