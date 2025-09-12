package org.example;

public class Lc33 {
	public int search(int[] nums, int target) {
		return helper(nums, target,0, nums.length-1);
	}
	public int binarySearch(int[] nums, int target, int st, int ed) {
		//System.out.println(st+" " + ed);
		while(st <= ed) {
			if (nums[st] == target) return st;
			if (nums[ed] == target) return ed;

			int mid = (st+ed)/2;

			if (mid == st || ed == mid) {
				if (nums[st] == target) return st;
				if (nums[ed] == target) return ed;
				return -1;
			}

			if (nums[mid] == target) return mid;

			if (nums[mid] > target) {
				ed = mid ;
				continue;
			}
			st = mid;
		}

		return -1;
	}
	public int helper(int[] nums, int target, int st, int ed) {

		//System.out.println(st+" ssss " + ed);
		if (st > ed) return -1;

		if (st == ed) {
			return nums[st] == target?ed:-1;
		}

		int mid = (st + ed ) /2;
		if (mid == st || ed == mid) {
			if (nums[st] == target) return st;
			if (nums[ed] == target) return ed;
			return -1;
		}

		if (nums[st] < nums[mid]) {
			//System.out.println(mid+" <<<<< " + ed);
			int r = binarySearch(nums,target,st,mid);
			if (r != -1) return r;
		} else{
			//System.out.println(mid+" <<<<<sssss " + ed);
			int r = helper(nums,target,st,mid);
			if (r != -1) return r;
		}

		if (nums[mid] < nums[ed]) {
			//System.out.println(mid+" <<<gggg " + ed);
			int r = binarySearch(nums,target,mid,ed);
			if (r != -1) return r;
		} else{
			//System.out.println(mid+" --- " + ed);
			int r= helper(nums,target,mid,ed);
			if (r!=-1) return r;
		}

		return -1;
	}
}
