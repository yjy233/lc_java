package org.example;

import java.util.ArrayList;
import java.util.List;

public class Lc113 {
	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		List<List<Integer>> res = new ArrayList<>();

		return res;
	}

	public void helper(TreeNode root, int targetSum, List<Integer> path){
		if (root == null) return;
		if (root.left == null && root.right == null) {

		}
	}
}
