package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc46 {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        boolean[] use = new boolean[nums.length];
        for (int i = 0;i<nums.length;i++) use[i] = false;
        helper(res,nums,use,new ArrayList<>());

        return res;
    }

    public void helper(List<List<Integer>> res, int []nums, boolean[] use,List<Integer> tmp){

        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0;i<nums.length;i++){
            if (use[i]) {
                continue;
            }

            tmp.add(nums[i]);
            use[i] = true;
            helper(res,nums,use,tmp);
            tmp.removeLast();
            use[i] = false;
        }


    }
}
