package org.example;

public class Lc35 {
	public int searchInsert(int[] nums, int target) {
		if (nums.length == 0) return 0;


		if (target <= nums[0]) return 0;
		if (target > nums[nums.length - 1]) return nums.length;
		if (target == nums[nums.length - 1]) return nums.length - 1;


		int st = 0;
		int ed = nums.length - 1;
		while (st < ed) {
			int mid = (st + ed) / 2;
			if (mid == st || mid == ed) break;


			if (target > nums[mid]) {
				st = mid;
				continue;
			}
			ed = mid;
		}

		if (nums[st] == target) return st;
		if (nums[ed] == target) return ed;

		return ed;
	}
}
