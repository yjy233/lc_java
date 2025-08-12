package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc78 {

	public List<List<Integer>> subsets(int[] nums) {
		Arrays.sort(nums);

		//for (int x: nums) System.out.println(x + " ");

		List<List<Integer>> res = new ArrayList<>();
		res.add(new ArrayList<>());
		List<List<Integer>> tmp = new ArrayList<>();

		for (int i = 0;i< nums.length;i++) {
			tmp.clear();

			boolean needDo = false;
			if (i == 0) needDo = true;
			if (i > 0 && nums[i-1] != nums[i]) needDo = true;

			for (List<Integer> tn: res) {
				//System.out.println("----join");
				tmp.add(tn);

				if (needDo) {
					//    System.out.println("----join ntn");
					List<Integer> ntn = new ArrayList<>(tn);
					ntn.add(nums[i]);
					tmp.add(ntn);
					continue;
				}

				int c = nums[i];
				int totalC = 0;
				for (int j = i-1;j>=0;j--){
					if (nums[j] == c) {
						totalC++;
						continue;
					}
					break;
				}
				int termC = 0;
				for (int j = tn.size()-1;j>=0;j--){
					if (tn.get(j) == c){
						termC++;
						continue;
					}
					break;
				}
				if (termC == totalC) {
					List<Integer> ntn = new ArrayList<>(tn);
					ntn.add(nums[i]);
					tmp.add(ntn);
					continue;
				}


			}

			List<List<Integer>> mid = null;
			mid = res;
			res = tmp;
			tmp = mid;
		}

		return res;
	}
}
