package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc40 {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		candidates = Arrays.stream(candidates).sorted().toArray();
		for (int x: candidates) {
			System.out.print(" " + x);
		}
		System.out.println(" ");

		List<List<Integer>> res = new ArrayList<>();
		List<Integer> path = new ArrayList<>();

		helper(res,candidates,target,0,path);
		return res;
	}

	public void helper(List<List<Integer>> res, int[] candidates, int target, int ind, List<Integer> path) {
		if (target <= 0 || ind >= candidates.length) {
			if (target == 0) res.add(new ArrayList<>(path));
			return ;
		}

		if (candidates[ind] > target) return ;


		// 不加本次
		helper(res, candidates, target, ind + 1, path);

		boolean need = true;
		if (ind > 0 && candidates[ind] == candidates[ind-1]){
			int cCnt = 0;
			int pCnt = 0;
			int num = candidates[ind];
			for (int j = ind-1; j >= 0;j--){
				if (candidates[j] != num) break;
				cCnt++;
			}

			for (int j = path.size()-1;j>=0;j--) {
				if (path.get(j) != num) break;
				pCnt++;
			}

			need = (cCnt == pCnt);
		}

		if (need) {
			path.add(candidates[ind]);
			helper(res, candidates, target-candidates[ind], ind + 1, path);
			path.removeLast();
		}
	}
}
