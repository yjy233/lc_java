package org.example;

public class Lc136 {
	public int singleNumber(int[] nums) {
		int l = nums.length;
		if (l<=0) return 0;
		int res = nums[0];

		for (int i = 1;i<l;i++) res ^= nums[i];
		return res;
	}
}
