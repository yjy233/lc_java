package org.example;

import java.util.Stack;

public class Lc155 {
	private Stack<Integer> minSt = new Stack<>();
	private Stack<Integer> normalSt = new Stack<>();

	public Lc155() {

	}

	public void push(int val) {
		normalSt.push(val);
		if (minSt.isEmpty()) {
			minSt.push(val);
			return;
		}
		minSt.push(Math.min(val, minSt.peek()));
	}

	public void pop() {
		normalSt.pop();
		minSt.pop();
	}

	public int top() {
		return normalSt.peek();
	}

	public int getMin() {
		return minSt.peek();
	}
}
