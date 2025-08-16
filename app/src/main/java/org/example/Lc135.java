package org.example;

public class Lc135 {
	public int candy(int[] ratings) {
		int l = ratings.length;
		int[] left = new int[l];
		int[] right = new int[l];

		int tmp = 0;
		for (int i = 1;i<l;i++){
			if (ratings[i] > ratings[i-1]) {
				tmp++;
				left[i] = tmp;
				continue;
			}
			tmp = 0;
		}

		tmp = 0;
		for (int i = l-2;i >= 0;i--){
			if (ratings[i] >  ratings[i+1]) {
				tmp++;
				right[i] = tmp;
				continue;
			}
			tmp = 0;
		}

		int res = l;
		for (int i = 0;i<l;i++) res += Math.max(left[i], right[i]);
		return res;
	}
}
