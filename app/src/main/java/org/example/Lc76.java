package org.example;

public class Lc76 {
	public void sortColors(int[] nums) {
		int nextLeft = 0;
		int nextRight = nums.length-1;
		int l = nums.length;
		while(nextLeft < l && nums[nextLeft] == 0) nextLeft++;

		if (nextLeft == l) return;

		while(nextRight >= 0 && nums[nextRight] == 2) nextRight--;


		if (nextRight <= 0) return;

		int i = nextLeft;
		while (i<=nextRight) {
			if (i < nextLeft) {
				i = nextLeft;
				continue;
			}

			// for (int x: nums) System.out.print(" "+x);
			// System.out.println("");
			//System.out.println(nextLeft + " " + nextRight + " "+ i);
			if (nums[i] == 0) {
				int tmp = nums[i];
				nums[i] = nums[nextLeft];
				nums[nextLeft] = tmp;
				nextLeft++;
				continue;
			}

			if (nums[i] == 1){
				i++;
				continue;
			}

			int tmp = nums[i];
			nums[i] = nums[nextRight];
			nums[nextRight] = tmp;
			nextRight--;

		}
	}
}
