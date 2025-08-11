package org.example;

import java.util.Stack;

public class Lc42 {
	public int trap(int[] height) {
		int res = 0;

		Stack<Integer> st = new Stack<>();


		for(int i = 0; i < height.length; i++) {
			while(!st.isEmpty() && height[st.peek()] < height[i]){
				int mh = height[st.peek()];
				st.pop();

				if (st.isEmpty()) break;

				int rh = Math.min(height[i], height[st.peek()]) - mh;
				res += (rh*(i - st.peek() - 1));
			}

			st.push(i);
		}


		return res;
	}
}
