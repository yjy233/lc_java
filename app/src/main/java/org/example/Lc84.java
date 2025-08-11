package org.example;

import java.util.Stack;

public class Lc84 {
	public int largestRectangleArea(int[] heights) {
		int l = heights.length;
		if (l <= 0) return 0;

		int[] left = new int[l];
		int[] right = new int[l];

		Stack<Integer> st = new Stack<>();

		for (int ind = 0; ind < l; ind++) {
			while(!st.isEmpty() && heights[ind] < heights[st.peek()]) {
				left[st.peek()] = ind - st.peek();
				st.pop();
			}
			st.push(ind);
		}

		while(!st.isEmpty()) {
			left[st.peek()] = l - st.peek();
			st.pop();
		}

		//for (int w: left) System.out.println(w + " ");

		for (int i = l-1; i>=0;i--) {
			while(!st.isEmpty() && heights[i] < heights[st.peek()]) {
				right[st.peek()] = st.peek() - i;
				st.pop();
			}
			st.push(i);
		}

		while(!st.isEmpty()) {
			right[st.peek()] = st.peek()+1;
			st.pop();
		}


		int res = 0;
		for (int i = 0;i<l;i++) {
			res = Math.max(res, (left[i] + right[i] - 1)* heights[i]);
		}
		return res;
	}
}
