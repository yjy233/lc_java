package org.example;

public class Lc112 {
	boolean res =false;
	public boolean hasPathSum(TreeNode root, int targetSum) {
		if (root == null) {
			return false;
		}

		if (root.left == null && root.right == null) {
			if (root.val == targetSum) {
				res =true;
			}
			return res;
		}




		hasPathSum(root.left, targetSum-root.val);
		hasPathSum(root.right, targetSum-root.val);
		return res;
	}
}
