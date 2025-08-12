package org.example;

import java.util.ArrayList;
import java.util.List;

public class Lc77 {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<>();

		List<Integer> path = new ArrayList<>();
		helper(res, 1, n, k, path);


		return res;
	}

	public void helper(List<List<Integer>> res, int ind, int n, int k,List<Integer> path){

		if (path.size() == k) {
			res.add(new ArrayList<>(path));
		}
		if (ind > n) return;

		if (path.size() >= k) return;

		helper(res,ind+1,n, k, path);

		path.add(ind);
		helper(res,ind+1,n, k, path);
		path.removeLast();




	}
}
