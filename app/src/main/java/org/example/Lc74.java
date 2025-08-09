package org.example;

public class Lc74 {
	public int lowerBoundLineIndx(int[][] matrix, int target) {
		int h = matrix.length;
		if (matrix[0][0] >= target) return 0;
		if (matrix[h-1][0] <= target) return h-1;

		int l = 0;
		int r = h-1;

		if (matrix[l][0] == target) return l;
		if (matrix[r][0] == target) return r;

		while(l<r){
			int mid = (l+r)/2;
			if (matrix[mid][0] == target) return mid;

			if (l == mid || r == mid) {
				if (matrix[r][0] > target ) return l;
				return r;
			}

			if (matrix[mid][0] <= target) {
				l = mid;
			} else{
				r = mid;
			}

			if (matrix[l][0] == target) return l;
			if (matrix[r][0] == target) return r;
		}
		return l;
	}


	public boolean binsearch(int[] nums, int target){
		int w = nums.length;
		if (target > nums[w-1]) return false;
		if (target < nums[0]) return false;


		int l = 0;
		int r = w-1;

		//System.out.println("-----");
		while(l<=r){
			if (nums[r] == target || nums[l] == target) return true;

			int mid = (r+l)/2;
			if (nums[mid] == target) return true;
			if (mid == r || mid == l)  return false;

			if (nums[mid] > target) {
				r = mid;
			} else{
				l = mid;
			}

		}
		return false;
	}
	public boolean searchMatrix(int[][] matrix, int target) {
		int lineIndex = lowerBoundLineIndx(matrix,target);
		//System.out.print(lineIndex);
		return binsearch(matrix[lineIndex], target);
	}
}
