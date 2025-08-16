package org.example;

import java.util.HashMap;
import java.util.Map;

public class Lc1 {
	public int[] twoSum(int[] nums, int target) {

		int[] res = new int[2];
		Map<Integer,Integer> num2Ind = new HashMap<>();

		if (nums.length < 2){
			return res;
		}
		num2Ind.put(nums[0],0);
		for (int i = 1;i<nums.length;i++){
			int rest = target-nums[i];
			if (num2Ind.get(rest) != null){
				res[0] = num2Ind.get(rest);
				res[1] = i;
				return res;
			}

			num2Ind.put(nums[i],i);
		}

		return res;
	}
}
