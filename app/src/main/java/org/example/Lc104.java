package org.example;

import java.util.Stack;

public class Lc104 {
	public int maxDepth(TreeNode root) {
		return helper(root,0);
	}

	public int helper(TreeNode root, int dep){
		if (root == null) {
			return dep;
		}

		return Math.max(helper(root.left, dep+1), helper(root.right, dep + 1));
	}
}
