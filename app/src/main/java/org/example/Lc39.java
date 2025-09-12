package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc39 {
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();

		candidates = Arrays.stream(candidates).sorted().toArray();
		List<Integer> path = new ArrayList<>();
		helper(candidates,target,0,path, res);

		return res;

	}

	public static void helper(int[] candidates, int target,int ind, List<Integer> path, List<List<Integer>> res){
		if (target <= 0){
			if (target == 0) res.add(new ArrayList<>(path));
			return ;
		}

		for (int i = ind; i < candidates.length;i++) {
			if (candidates[i] > target) break;
			path.add(candidates[i]);
			helper(candidates, target-candidates[i], i, path, res);
			path.removeLast();
		}
	}

	public static void main(String[] args){

		combinationSum(new int[]{2,3,5}, 8);
	}
}
