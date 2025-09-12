package org.example;

public class Lc26 {
	public int removeDuplicates(int[] nums) {
		int ind = 0;
		for (int i=1;i<nums.length;i++) {
			if (nums[ind] == nums[i]) {
				continue;
			}
			ind++;
			nums[ind] = nums[i];
		}
		return ind+1;
	}
}
