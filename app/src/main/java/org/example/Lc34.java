package org.example;

import java.util.Arrays;

public class Lc34 {
	int st = -1;
	int ed = -1;
	public int[] searchRange(int[] nums, int target) {
		int ind = binarySearch(nums,target);
		if (ind != -1) {
			st = ind;
			ed = ind;
		}
		//System.out.println("ind:" + ind);
		int left = ind -1;
		int b = 0;
		while ((left >= b) && (left >= 0)) {
			if (nums[left] != target) break;;

			st = Math.min(left, st);

			int mid = (b + left)/2;
			if (mid == left || mid == b) {
				if (nums[b] == target)  st = Math.min(st, b);
				if (nums[left] == target)st = Math.min(left, st);
				break;
			}
			if (nums[mid] == target) {
				left = mid;
				continue;
			}

			b = mid + 1;
		}

		int right = ind + 1;
		b = nums.length-1;
		while (b >= right && right < nums.length) {
			//System.out.println("wfgwefewfew");
			if (nums[right] != target) break;;

			ed = Math.max(right, ed);

			int mid = (b + right)/2;
			if (mid == right || mid == b) {
				if (nums[b] == target)  ed = Math.max(ed, b);
				if (nums[right] == target)ed = Math.max(right, ed);
				break;
			}
			if (nums[mid] == target) {
				right = mid;
				continue;
			}

			b = mid -1;
		}



		int[] res = new int[]{st,ed};
		return res;
	}

	public int binarySearch(int[] nums, int target) {
		int si = 0;
		int se = nums.length-1;

		while(si <= se) {
			if (nums[si] == target) return si;
			if (nums[se] == target) return se;

			int mid = (si + se)/2;
			if (nums[mid] == target) return  mid;
			if (mid == si || mid == se) {
				return -1;
			}


			if (target > nums[mid]) {
				si = mid + 1;
				continue;
			}

			se = mid -1;

		}
		return -1;
	}

}
