package org.example;

public class Lc80 {
	public int removeDuplicates(int[] nums) {
		if (nums.length == 0) return 0;

		int cnt = 1;
		int deCnt = 0;
		int num = nums[0];
		for (int i = 1; i < nums.length;i++) {
			if (nums[i] != num) {
				num = nums[i];
				nums[i-deCnt] = nums[i];
				cnt = 1;
				continue;
			}

			if (cnt >= 2){
				deCnt++;
			} else{
				nums[i-deCnt] = nums[i];
			}

			cnt++;

		}

		return nums.length - deCnt;
	}
}
